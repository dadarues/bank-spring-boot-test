package co.com.sofka.prueba.pruebajavaspring.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {

  private String nombre;
  private String genero;
  private Integer edad;
  private String identificacion;
  private String direccion;
  private String telefono;

  public Persona(String nombre, String genero, Integer edad, String identificacion,
      String direccion,
      String telefono) {
    this.nombre = nombre;
    this.genero = genero;
    this.edad = edad;
    this.identificacion = identificacion;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public Persona() {

  }

  public String getNombre() {
    return nombre;
  }

  public String getGenero() {
    return genero;
  }

  public Integer getEdad() {
    return edad;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
