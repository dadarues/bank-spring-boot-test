package co.com.sofka.prueba.pruebajavaspring.controller;

import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientoResponse;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientosRequest;
import co.com.sofka.prueba.pruebajavaspring.mapper.MovimientosMapper;
import co.com.sofka.prueba.pruebajavaspring.service.MovimientosService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
@RequestMapping("/api/v1/movimientos")
public class MovimientosController {

  @Autowired
  MovimientosService movimientosService;

  @Autowired
  MovimientosMapper movimientosMapper;

  @GetMapping
  public List<MovimientoResponse> findAll() {
    List<Movimientos> movimientos = movimientosService.findAll();
    return movimientos.stream().map(movimientosMapper::toDto).collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public MovimientoResponse findById(@PathVariable Integer id) throws Exception {
    return movimientosMapper.toDto(movimientosService.findById(id).orElseThrow(null));
  }

  @PostMapping
  public MovimientoResponse save(@Valid @RequestBody MovimientosRequest request) throws Exception {
    Movimientos movimiento = movimientosMapper.toEntity(request);
    movimiento = movimientosService.save(movimiento);
    return movimientosMapper.toDto(movimiento);
  }

  @PutMapping
  public MovimientoResponse update(@Valid @RequestBody MovimientosRequest request)
      throws Exception {
    Movimientos movimiento = movimientosMapper.toEntity(request);
    movimiento = movimientosService.update(movimiento);
    return movimientosMapper.toDto(movimiento);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Integer id) throws Exception {
    movimientosService.deleteById(id);
  }
}
