package co.com.sofka.prueba.pruebajavaspring.mapper;

import co.com.sofka.prueba.pruebajavaspring.domain.Movimientos;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientoResponse;
import co.com.sofka.prueba.pruebajavaspring.dto.MovimientosRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface MovimientosMapper {

  @Mappings({
      @Mapping(target = "idCuenta", source = "cuenta.idCuenta"),
      @Mapping(target = "numeroCuenta", source = "cuenta.numeroCuenta"),
      @Mapping(target = "saldo", source = "cuenta.saldoActual"),
      @Mapping(target = "tipoCuenta", source = "cuenta.tipoCuenta"),
      @Mapping(target = "clienteId", source = "cuenta.cliente.clienteId"),
      @Mapping(target = "nombreCliente", source = "cuenta.cliente.nombre")
  })
  public MovimientoResponse toDto(Movimientos movimientos);

  @Mapping(target = "cuenta.idCuenta", source = "idCuenta")
  public Movimientos toEntity(MovimientosRequest request);

}
