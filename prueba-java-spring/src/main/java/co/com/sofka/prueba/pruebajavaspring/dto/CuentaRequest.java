package co.com.sofka.prueba.pruebajavaspring.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
  @NotNull
  private Long numeroCuenta;
  @NotNull
  @NotBlank
  private String tipoCuenta;
  @NotNull
  private BigDecimal saldoInicial;
  @NotNull
  private Boolean estado;
  @NotNull
  private Integer idCliente;
  
}
