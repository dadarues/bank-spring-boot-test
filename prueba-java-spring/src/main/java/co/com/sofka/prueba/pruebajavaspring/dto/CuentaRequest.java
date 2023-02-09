package co.com.sofka.prueba.pruebajavaspring.dto;

public class CuentaRequest {
  private Integer idCuenta;

  private Long numeroCuenta;

  private String tipoCuenta;

  private Double saldoInicial;

  private Boolean estado;

  private Integer idCliente;

  public CuentaRequest(Integer idCuenta, Long numeroCuenta, String tipoCuenta, Double saldoInicial,
      Boolean estado, Integer idCliente) {
    this.idCuenta = idCuenta;
    this.numeroCuenta = numeroCuenta;
    this.tipoCuenta = tipoCuenta;
    this.saldoInicial = saldoInicial;
    this.estado = estado;
    this.idCliente = idCliente;
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

  public String getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public Double getSaldoInicial() {
    return saldoInicial;
  }

  public void setSaldoInicial(Double saldoInicial) {
    this.saldoInicial = saldoInicial;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public CuentaRequest() {
  }

  @Override
  public String toString() {
    return "CuentaRequest{" +
        "idCuenta=" + idCuenta +
        ", numeroCuenta=" + numeroCuenta +
        ", tipoCuenta='" + tipoCuenta + '\'' +
        ", saldoInicial=" + saldoInicial +
        ", estado=" + estado +
        ", idCliente=" + idCliente +
        '}';
  }
}
