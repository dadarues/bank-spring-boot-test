package co.com.sofka.prueba.pruebajavaspring.mapper;

import co.com.sofka.prueba.pruebajavaspring.domain.Cuenta;
import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import co.com.sofka.prueba.pruebajavaspring.dto.CuentaRequest;
import co.com.sofka.prueba.pruebajavaspring.dto.CuentaResponse;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientoResponse;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientosRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CuentaMapper {

  @Mappings({
      @Mapping(target = "identificacionCliente", source = "cliente.identificacion"),
      @Mapping(target = "idCliente", source = "cliente.clienteId"),
      @Mapping(target = "nombreCliente", source = "cliente.nombre")
  })
  public CuentaResponse toDto(Cuenta cuenta);

  @Mapping(target = "cliente.clienteId", source = "idCliente")
  public Cuenta toEntity(CuentaRequest request);
}
