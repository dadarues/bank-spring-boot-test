package co.com.sofka.prueba.pruebajavaspring.service.impl;

import co.com.sofka.prueba.pruebajavaspring.domain.Cuenta;
import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import co.com.sofka.prueba.pruebajavaspring.repository.ClienteRepository;
import co.com.sofka.prueba.pruebajavaspring.repository.MovimientosRepository;
import co.com.sofka.prueba.pruebajavaspring.service.CuentaService;
import co.com.sofka.prueba.pruebajavaspring.service.MovimientosService;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimientoServiceImpl implements MovimientosService {

  @Autowired
  MovimientosRepository movimientosRepository;

  @Autowired
  CuentaService cuentaService;

  @Autowired
  Validator validator;

  @Override
  @Transactional(readOnly = true)
  public List<Movimientos> findAll() {
    return movimientosRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Movimientos> findById(Integer id) throws Exception {
    if(!movimientosRepository.existsById(id)){
      throw new Exception("el movimiento no existe");
    }
    return movimientosRepository.findById(id);
  }

  @Override
  @Transactional
  public Movimientos save(Movimientos entity) throws Exception {
    this.validate(entity);
    Cuenta cuenta = cuentaService.findById(entity.getCuenta().getIdCuenta()).get();
    Double saldoCuenta = cuenta
        .getSaldoActual();

    Double movimiento = saldoCuenta + entity.getValor();

    if(saldoCuenta == 0 || movimiento <= 0) {
      throw new Exception("Saldo no disponible");
    }

    cuenta.setSaldoActual(movimiento);
    cuentaService.update(cuenta);
    return movimientosRepository.save(entity);
  }

  @Override
  @Transactional
  public Movimientos update(Movimientos entity) throws Exception {
    this.validate(entity);
    if (!movimientosRepository.existsById(entity.getIdMovimiento())) {
      throw new Exception("El movimiento no existe");
    }
    return movimientosRepository.save(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void delete(Movimientos entity) throws Exception {
    if (entity == null) {
      throw new Exception("La cuenta es null");
    }

    if (entity.getIdMovimiento() == null) {
      throw new Exception("El id de la cuenta es null");
    }

    if (!movimientosRepository.existsById(entity.getIdMovimiento())) {
      throw new Exception("La cuenta no existe");
    }

    entity = movimientosRepository.findById(entity.getIdMovimiento()).get();

    movimientosRepository.delete(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void deleteById(Integer id) throws Exception {
    if (id == null) {
      throw new Exception("El id no debe ser nulo");
    }

    delete(movimientosRepository.getById(id));
  }

  @Override
  public void validate(Movimientos entity) throws Exception {
    if (entity == null) {
      throw new Exception("El cliente es null");
    }
    Set<ConstraintViolation<Movimientos>> constraintViolations = validator.validate(entity);
    if (constraintViolations.isEmpty() == false) {
      throw new ConstraintViolationException(constraintViolations);
    }
  }

  @Override
  public Long count() {
    return movimientosRepository.count();
  }

  @Override
  public List<Movimientos> generarReportePorFechaYCliente(Integer clienteId, LocalDate fecha1,
      LocalDate fecha2) {
    return movimientosRepository.findAllByCuentaClienteClienteIdAndFechaBetween(clienteId, fecha1, fecha2);
  }
}
