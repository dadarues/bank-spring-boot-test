package co.com.sofka.prueba.pruebajavaspring.service.impl;

import co.com.sofka.prueba.pruebajavaspring.domain.Cuenta;
import co.com.sofka.prueba.pruebajavaspring.repository.CuentaRepository;
import co.com.sofka.prueba.pruebajavaspring.service.CuentaService;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaServiceImpl implements CuentaService {

  @Autowired
  CuentaRepository cuentaRepository;
  @Autowired
  Validator validator;

  @Override
  @Transactional(readOnly = true)
  public List<Cuenta> findAll() {
    return cuentaRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Cuenta> findById(Integer id) throws Exception {
    if(!cuentaRepository.existsById(id)){
      throw new Exception("La cuenta no existe");
    }
    return cuentaRepository.findById(id);
  }

  @Override
  @Transactional
  public Cuenta save(Cuenta entity) throws Exception {
    this.validate(entity);
    entity.setSaldoActual(entity.getSaldoInicial());
    return cuentaRepository.save(entity);
  }

  @Override
  @Transactional
  public Cuenta update(Cuenta entity) throws Exception {
    this.validate(entity);
    if (!cuentaRepository.existsById(entity.getIdCuenta())) {
      throw new Exception("La cuenta no existe");
    }
    if (entity.getSaldoActual() == null) {
      entity.setSaldoActual(cuentaRepository.getById(entity.getIdCuenta()).getSaldoActual());
    }

    return cuentaRepository.save(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void delete(Cuenta entity) throws Exception {
    if (entity == null) {
      throw new Exception("La cuenta es null");
    }

    if (entity.getIdCuenta() == null) {
      throw new Exception("El id de la cuenta es null");
    }

    if (!cuentaRepository.existsById(entity.getIdCuenta())) {
      throw new Exception("La cuenta no existe");
    }

    entity = cuentaRepository.findById(entity.getIdCuenta()).get();

    cuentaRepository.delete(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void deleteById(Integer id) throws Exception {
    if (id == null) {
      throw new Exception("El id no debe ser nulo");
    }

    delete(cuentaRepository.getById(id));
  }

  @Override
  public void validate(Cuenta entity) throws Exception {
    if (entity == null) {
      throw new Exception("El cliente es null");
    }
    Set<ConstraintViolation<Cuenta>> constraintViolations = validator.validate(entity);
    if (constraintViolations.isEmpty() == false) {
      throw new ConstraintViolationException(constraintViolations);
    }
  }

  @Override
  public Long count() {
    return cuentaRepository.count();
  }
}
