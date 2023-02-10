package co.com.sofka.prueba.pruebajavaspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoResponse {

  private Integer idMovimiento;

  @JsonFormat(pattern="dd/MM/yyyy")
  private LocalDate fecha;

  private String tipoMovimiento;

  private BigDecimal valor;

  private BigDecimal saldo;

  private Integer idCuenta;

  private Long numeroCuenta;

  private String tipoCuenta;

  private Integer clienteId;

  private String nombreCliente;
  
}
