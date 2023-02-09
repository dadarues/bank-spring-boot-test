package co.com.sofka.prueba.pruebajavaspring.controller;

import co.com.sofka.prueba.pruebajavaspring.domain.Cliente;
import co.com.sofka.prueba.pruebajavaspring.dto.ClienteDto;
import co.com.sofka.prueba.pruebajavaspring.mapper.ClienteMapper;
import co.com.sofka.prueba.pruebajavaspring.service.ClienteService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
  @Autowired
  ClienteService clienteService;

  @Autowired
  ClienteMapper clienteMapper;

  @GetMapping
  public List<ClienteDto> findAll() {
    List<Cliente> customers = clienteService.findAll();
    return customers.stream().map(clienteMapper::toDto).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public ClienteDto findById(@PathVariable Integer id) throws Exception {
    return clienteMapper.toDto(clienteService.findById(id).orElseThrow(null));
  }

  @PostMapping
  public ClienteDto save(@Valid @RequestBody ClienteDto request) throws Exception {
    Cliente customer = clienteMapper.toEntity(request);
    customer = clienteService.save(customer);
    return clienteMapper.toDto(customer);
  }

  @PutMapping
  public ClienteDto update(@Valid @RequestBody ClienteDto request) throws Exception {
    Cliente customer = clienteMapper.toEntity(request);
    customer = clienteService.update(customer);
    return clienteMapper.toDto(customer);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id)throws Exception{
    clienteService.deleteById(id);
  }
}
