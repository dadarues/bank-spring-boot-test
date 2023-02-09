package co.com.sofka.prueba.pruebajavaspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class MovimientoResponse {

  private Integer idMovimiento;

  @JsonFormat(pattern="dd/MM/yyyy")
  private LocalDate fecha;

  private String tipoMovimiento;

  private Double valor;

  private Double saldo;

  private Integer idCuenta;

  private Long numeroCuenta;

  private String tipoCuenta;

  private Integer clienteId;

  private String nombreCliente;

  public MovimientoResponse(Integer idMovimiento, LocalDate fecha, String tipoMovimiento,
      Double valor, Double saldo, Integer idCuenta, Long numeroCuenta, Integer clienteId,
      String nombreCliente, String tipoCuenta) {
    this.idMovimiento = idMovimiento;
    this.fecha = fecha;
    this.tipoMovimiento = tipoMovimiento;
    this.valor = valor;
    this.saldo = saldo;
    this.idCuenta = idCuenta;
    this.numeroCuenta = numeroCuenta;
    this.clienteId = clienteId;
    this.nombreCliente = nombreCliente;
    this.tipoCuenta = tipoCuenta;
  }

  public String getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
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

  public Long getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(Long numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public MovimientoResponse() {
  }

  @Override
  public String toString() {
    return "MovimientoResponse{" +
        "idMovimiento=" + idMovimiento +
        ", fecha=" + fecha +
        ", tipoMovimiento='" + tipoMovimiento + '\'' +
        ", valor=" + valor +
        ", saldo=" + saldo +
        ", idCuenta=" + idCuenta +
        ", numeroCuenta=" + numeroCuenta +
        ", tipoCuenta='" + tipoCuenta + '\'' +
        ", clienteId=" + clienteId +
        ", nombreCliente='" + nombreCliente + '\'' +
        '}';
  }
}
