package co.com.sofka.prueba.pruebajavaspring.dto;

public class CuentaResponse {

  private Integer idCuenta;

  private Long numeroCuenta;

  private String tipoCuenta;

  private Double saldoInicial;

  private Boolean estado;

  private Integer idCliente;

  private String nombreCliente;

  private String identificacionCliente;

  private Double saldoActual;

  public CuentaResponse(Integer idCuenta, Long numeroCuenta, String tipoCuenta, Double saldoInicial,
      Boolean estado, Integer idCliente, String nombreCliente, String identificacionCliente, Double saldoActual) {
    this.idCuenta = idCuenta;
    this.numeroCuenta = numeroCuenta;
    this.tipoCuenta = tipoCuenta;
    this.saldoInicial = saldoInicial;
    this.estado = estado;
    this.idCliente = idCliente;
    this.nombreCliente = nombreCliente;
    this.identificacionCliente = identificacionCliente;
    this.saldoActual = saldoActual;
  }

  public Double getSaldoActual() {
    return saldoActual;
  }

  public void setSaldoActual(Double saldoActual) {
    this.saldoActual = saldoActual;
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

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public String getIdentificacionCliente() {
    return identificacionCliente;
  }

  public void setIdentificacionCliente(String identificacionCliente) {
    this.identificacionCliente = identificacionCliente;
  }

  public CuentaResponse() {
  }

  @Override
  public String toString() {
    return "CuentaResponse{" +
        "idCuenta=" + idCuenta +
        ", numeroCuenta=" + numeroCuenta +
        ", tipoCuenta='" + tipoCuenta + '\'' +
        ", saldoInicial=" + saldoInicial +
        ", estado=" + estado +
        ", idCliente=" + idCliente +
        ", nombreCliente='" + nombreCliente + '\'' +
        ", identificacionCliente='" + identificacionCliente + '\'' +
        ", saldoActual=" + saldoActual +
        '}';
  }
}
