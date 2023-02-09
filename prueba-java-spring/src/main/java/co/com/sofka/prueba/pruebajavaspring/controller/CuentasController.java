package co.com.sofka.prueba.pruebajavaspring.controller;

import co.com.sofka.prueba.pruebajavaspring.domain.Cuenta;
import co.com.sofka.prueba.pruebajavaspring.dto.CuentaRequest;
import co.com.sofka.prueba.pruebajavaspring.dto.CuentaResponse;
import co.com.sofka.prueba.pruebajavaspring.mapper.CuentaMapper;
import co.com.sofka.prueba.pruebajavaspring.service.CuentaService;
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
@RequestMapping("/api/v1/cuentas")
public class CuentasController {

  @Autowired
  CuentaService cuentaService;

  @Autowired
  CuentaMapper cuentaMapper;

  @GetMapping
  public List<CuentaResponse> findAll() {
    List<Cuenta> cuentas = cuentaService.findAll();
    return cuentas.stream().map(cuentaMapper::toDto).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public CuentaResponse findById(@PathVariable Integer id) throws Exception {
    return cuentaMapper.toDto(cuentaService.findById(id).orElseThrow(null));
  }

  @PostMapping
  public CuentaResponse save(@Valid @RequestBody CuentaRequest request) throws Exception {
    Cuenta cuenta = cuentaMapper.toEntity(request);
    cuenta = cuentaService.save(cuenta);
    return cuentaMapper.toDto(cuenta);
  }

  @PutMapping
  public CuentaResponse update(@Valid @RequestBody CuentaRequest request) throws Exception {
    Cuenta cuenta = cuentaMapper.toEntity(request);
    cuenta = cuentaService.update(cuenta);
    return cuentaMapper.toDto(cuenta);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id) throws Exception {
    cuentaService.deleteById(id);
  }
}
