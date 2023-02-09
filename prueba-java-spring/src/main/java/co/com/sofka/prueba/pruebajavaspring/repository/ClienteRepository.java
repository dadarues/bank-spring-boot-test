package co.com.sofka.prueba.pruebajavaspring.repository;

import co.com.sofka.prueba.pruebajavaspring.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  boolean existsByIdentificacion(String identificacion);

}
