package co.com.sofka.prueba.pruebajavaspring.repository;

import co.com.sofka.prueba.pruebajavaspring.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

}
