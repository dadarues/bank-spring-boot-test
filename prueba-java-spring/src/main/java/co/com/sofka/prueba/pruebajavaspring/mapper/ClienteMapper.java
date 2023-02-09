package co.com.sofka.prueba.pruebajavaspring.mapper;

import co.com.sofka.prueba.pruebajavaspring.domain.Cliente;
import co.com.sofka.prueba.pruebajavaspring.dto.ClienteDto;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {

  public ClienteDto toDto(Cliente cliente);

  public Cliente toEntity(ClienteDto clienteDto);
}
