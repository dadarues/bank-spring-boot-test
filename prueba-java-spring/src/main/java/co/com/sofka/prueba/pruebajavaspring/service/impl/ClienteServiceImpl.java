package co.com.sofka.prueba.pruebajavaspring.service.impl;

import co.com.sofka.prueba.pruebajavaspring.domain.Cliente;
import co.com.sofka.prueba.pruebajavaspring.domain.Cuenta;
import co.com.sofka.prueba.pruebajavaspring.repository.ClienteRepository;
import co.com.sofka.prueba.pruebajavaspring.service.ClienteService;
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
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  Validator validator;

  @Override
  @Transactional(readOnly = true)
  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Cliente> findById(Integer id) throws Exception{
    if(!clienteRepository.existsById(id)){
      throw new Exception("el cliente no existe");
    }
    return clienteRepository.findById(id);
  }

  @Override
  @Transactional
  public Cliente save(Cliente entity) throws Exception {
    this.validate(entity);
    if (clienteRepository.existsByIdentificacion(entity.getIdentificacion())) {
      throw new Exception("Ya existe un cliente con esa identificación");
    }
    return clienteRepository.save(entity);
  }

  @Override
  @Transactional
  public Cliente update(Cliente entity) throws Exception {
    this.validate(entity);
    if (!clienteRepository.existsById(entity.getClienteId())) {
      throw new Exception("El cliente no existe");
    }
    return clienteRepository.save(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void delete(Cliente entity) throws Exception {
    if (entity == null) {
      throw new Exception("El cliente es null");
    }

    if (entity.getClienteId() == null) {
      throw new Exception("El id de el cliente es null");
    }

    if (!clienteRepository.existsById(entity.getClienteId())) {
      throw new Exception("El cliente no existe");
    }

    entity = clienteRepository.findById(entity.getClienteId()).get();

    if (entity.getCuentas() != null && entity.getCuentas().isEmpty() == false) {
      throw new Exception("El cliente tiene cuentas asociadas y no se puede eliminar");
    }

    clienteRepository.delete(entity);
  }

  @Override
  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void deleteById(Integer id) throws Exception {
    if (id == null) {
      throw new Exception("El id no debe ser nulo");
    }

    delete(clienteRepository.getById(id));
  }

  @Override
  public void validate(Cliente entity) throws Exception {
    if (entity == null) {
      throw new Exception("El cliente es null");
    }
    Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(entity);
    if (constraintViolations.isEmpty() == false) {
      throw new ConstraintViolationException(constraintViolations);
    }
  }

  @Override
  public Long count() {
    return clienteRepository.count();
  }
}
