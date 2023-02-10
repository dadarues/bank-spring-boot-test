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
public class CuentaRequest {
  private Integer idCuenta;

  private Long numeroCuenta;

  private String tipoCuenta;

  private BigDecimal saldoInicial;

  private Boolean estado;

  private Integer idCliente;
  
}
