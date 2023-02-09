package co.com.sofka.prueba.pruebajavaspring.service;

import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import java.time.LocalDate;
import java.util.List;

public interface MovimientosService extends GenericService<Movimientos, Integer> {

  List<Movimientos> generarReportePorFechaYCliente(Integer clienteId, LocalDate fecha1, LocalDate fecha2);

}
