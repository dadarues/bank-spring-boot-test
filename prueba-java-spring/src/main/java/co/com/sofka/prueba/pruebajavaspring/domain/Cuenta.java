package co.com.sofka.prueba.pruebajavaspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuenta", schema = "public")
public class Cuenta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id_cuenta", nullable = false)
  @GeneratedValue
  private Integer idCuenta;

  @Column(name = "numero_cuenta", nullable = false)
  private Long numeroCuenta;

  @Column(name = "tipo_cuenta", nullable = false)
  private String tipoCuenta;

  @Column(name = "saldo_inicial", nullable = false)
  private Double saldoInicial;

  @Column(name = "saldo_actual", nullable = false)
  private Double saldoActual;

  @Column(name = "estado", nullable = false)
  private Boolean estado;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
  @JsonIgnore
  private List<Movimientos> movimientos = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "clienteId")
  private Cliente cliente;

  public Cuenta(Integer idCuenta, Long numeroCuenta, String tipoCuenta, Double saldoInicial,
      Boolean estado, List<Movimientos> movimientos, Cliente cliente, Double saldoActual) {
    this.idCuenta = idCuenta;
    this.numeroCuenta = numeroCuenta;
    this.tipoCuenta = tipoCuenta;
    this.saldoInicial = saldoInicial;
    this.estado = estado;
    this.movimientos = movimientos;
    this.cliente = cliente;
    this.saldoActual = saldoActual;
  }

  public Cuenta() {

  }

  public Double getSaldoActual() {
    return saldoActual;
  }

  public void setSaldoActual(Double saldoActual) {
    this.saldoActual = saldoActual;
  }

  public List<Movimientos> getMovimientos() {
    return movimientos;
  }

  public void setMovimientos(
      List<Movimientos> movimientos) {
    this.movimientos = movimientos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
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

  @Override
  public String toString() {
    return "Cuenta{" +
        "idCuenta=" + idCuenta +
        ", numeroCuenta=" + numeroCuenta +
        ", tipoCuenta='" + tipoCuenta + '\'' +
        ", saldoInicial=" + saldoInicial +
        ", saldoActual=" + saldoActual +
        ", estado=" + estado +
        ", movimientos=" + movimientos +
        ", cliente=" + cliente +
        '}';
  }
}
