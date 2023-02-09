package co.com.sofka.prueba.pruebajavaspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class MovimientosRequest {
  private Integer idMovimiento;

  @JsonFormat(pattern="dd/MM/yyyy")
  private LocalDate fecha;

  private String tipoMovimiento;

  private Double valor;

  private Double saldo;

  private Integer idCuenta;

  public MovimientosRequest(Integer idMovimiento, LocalDate fecha, String tipoMovimiento, Double valor,
      Double saldo, Integer idCuenta) {
    this.idMovimiento = idMovimiento;
    this.fecha = fecha;
    this.tipoMovimiento = tipoMovimiento;
    this.valor = valor;
    this.saldo = saldo;
    this.idCuenta = idCuenta;
  }

  public Integer getIdMovimiento() {
    return idMovimiento;
  }

  public void setIdMovimiento(Integer idMovimiento) {
    this.idMovimiento = idMovimiento;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public String getTipoMovimiento() {
    return tipoMovimiento;
  }

  public void setTipoMovimiento(String tipoMovimiento) {
    this.tipoMovimiento = tipoMovimiento;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public Integer getIdCuenta() {
    return idCuenta;
  }

  public void setIdCuenta(Integer idCuenta) {
    this.idCuenta = idCuenta;
  }

  public MovimientosRequest() {
  }

  @Override
  public String toString() {
    return "MovimientosRequest{" +
        "idMovimiento=" + idMovimiento +
        ", fecha=" + fecha +
        ", tipoMovimiento='" + tipoMovimiento + '\'' +
        ", valor=" + valor +
        ", saldo=" + saldo +
        ", idCuenta=" + idCuenta +
        '}';
  }
}
