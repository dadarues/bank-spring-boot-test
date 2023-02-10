package co.com.sofka.prueba.pruebajavaspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class MovimientosRequest {
  private Integer idMovimiento;

  @JsonFormat(pattern="dd/MM/yyyy")
  private LocalDate fecha;
  @NotNull
  @NotBlank
  private String tipoMovimiento;
  @NotNull
  private BigDecimal valor;
  private BigDecimal saldo;
  @NotNull
  private Integer idCuenta;
  
}
