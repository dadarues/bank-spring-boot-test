package co.com.sofka.prueba.pruebajavaspring.controller;

import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientoResponse;
import co.com.sofka.prueba.pruebajavaspring.mapper.MovimientosMapper;
import co.com.sofka.prueba.pruebajavaspring.service.MovimientosService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReportesController {

  @Autowired
  MovimientosService movimientosService;

  @Autowired
  MovimientosMapper movimientosMapper;

  @GetMapping
  public List<MovimientoResponse> generateReport(@RequestParam(required = false) Integer clienteId,
      @RequestParam(required = false)  @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaInicio,
      @RequestParam(required = false)  @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fechaFin) {
    List<Movimientos> movimientos = movimientosService.generarReportePorFechaYCliente(clienteId,
        fechaInicio, fechaFin);
    return movimientos.stream().map(movimientosMapper::toDto).collect(Collectors.toList());
  }

}
