package co.com.sofka.prueba.pruebajavaspring.repository;

import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {

  List<Movimientos> findAllByCuentaClienteClienteIdAndFechaBetween(Integer clienteId, LocalDate fecha1, LocalDate fecha2);
}
