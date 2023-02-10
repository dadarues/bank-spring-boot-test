package co.com.sofka.prueba.pruebajavaspring.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaResponse {

  private Integer idCuenta;

  private Long numeroCuenta;

  private String tipoCuenta;

  private BigDecimal saldoInicial;

  private Boolean estado;

  private Integer idCliente;

  private String nombreCliente;

  private String identificacionCliente;

  private BigDecimal saldoActual;
}
