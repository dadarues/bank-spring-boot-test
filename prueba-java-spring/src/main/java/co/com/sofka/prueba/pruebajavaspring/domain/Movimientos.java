package co.com.sofka.prueba.pruebajavaspring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.time.LocalDate;

@Entity
@Table(name = "movimientos", schema = "public")
public class Movimientos implements Serializable {

  @Id
  @Column(name = "id_movimiento", nullable = false)
  @GeneratedValue
  private Integer idMovimiento;

  @Column(name = "fecha", nullable = false)
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate fecha;

  @Column(name = "tipo_movimiento", nullable = false)
  private String tipoMovimiento;

  @Column(name = "valor", nullable = false)
  private Double valor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idCuenta")
  private Cuenta cuenta;

  public Movimientos(Integer idMovimiento, LocalDate fecha, String tipoMovimiento, Double valor, Cuenta cuenta) {
    this.idMovimiento = idMovimiento;
    this.fecha = fecha;
    this.tipoMovimiento = tipoMovimiento;
    this.valor = valor;
    this.cuenta = cuenta;
  }

  public Movimientos() {

  }

  public Integer getIdMovimiento() {
    return idMovimiento;
  }

  public void setIdMovimiento(Integer idMovimiento) {
    this.idMovimiento = idMovimiento;
  }

  public Cuenta getCuenta() {
    return cuenta;
  }

  public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
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

  @Override
  public String toString() {
    return "Movimientos{" +
        "idMovimiento=" + idMovimiento +
        ", fecha=" + fecha +
        ", tipoMovimiento='" + tipoMovimiento + '\'' +
        ", valor=" + valor +
        ", cuenta=" + cuenta +
        '}';
  }
}
