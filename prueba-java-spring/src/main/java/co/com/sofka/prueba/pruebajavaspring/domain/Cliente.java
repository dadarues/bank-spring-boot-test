package co.com.sofka.prueba.pruebajavaspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente", schema = "public")
public class Cliente extends Persona implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "cliente_id", nullable = false)
  @GeneratedValue
  private Integer clienteId;

  @Column(name = "contrasena", nullable = false)
  private String contrasena;

  @Column(name = "estado", nullable = false)
  private Boolean estado;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
  @JsonIgnore
  private List<Cuenta> cuentas = new ArrayList<>();

  public Cliente(String nombre, String genero, Integer edad, String identificacion,
      String direccion,
      String telefono, Integer clienteId, String contrasena, Boolean estado, List<Cuenta> cuentas) {
    super(nombre, genero, edad, identificacion, direccion, telefono);
    this.clienteId = clienteId;
    this.contrasena = contrasena;
    this.estado = estado;
    this.cuentas = cuentas;
  }

  public Cliente(Integer clienteId, String contrasena, Boolean estado, List<Cuenta> cuentas) {
    this.clienteId = clienteId;
    this.contrasena = contrasena;
    this.estado = estado;
    this.cuentas = cuentas;
  }

  public List<Cuenta> getCuentas() {
    return cuentas;
  }

  public void setCuentas(List<Cuenta> cuentas) {
    this.cuentas = cuentas;
  }

  public Cliente() {
    super();
  }

  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "clienteId=" + clienteId +
        ", contrasena='" + contrasena + '\'' +
        ", estado=" + estado +
        ", cuentas=" + cuentas +
        '}';
  }
}
