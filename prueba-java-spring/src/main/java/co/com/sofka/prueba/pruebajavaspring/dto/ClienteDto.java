package co.com.sofka.prueba.pruebajavaspring.dto;

public class ClienteDto {

  private Integer clienteId;
  private String contrasena;
  private Boolean estado;
  private String nombre;
  private String genero;
  private Integer edad;
  private String identificacion;
  private String direccion;
  private String telefono;

  public ClienteDto(Integer clienteId, String contrasena, Boolean estado, String nombre,
      String genero, Integer edad, String identificacion, String direccion, String telefono) {
    this.clienteId = clienteId;
    this.contrasena = contrasena;
    this.estado = estado;
    this.nombre = nombre;
    this.genero = genero;
    this.edad = edad;
    this.identificacion = identificacion;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public ClienteDto() {
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

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return "ClienteDto{" +
        "clienteId=" + clienteId +
        ", contrasena='" + contrasena + '\'' +
        ", estado=" + estado +
        ", nombre='" + nombre + '\'' +
        ", genero='" + genero + '\'' +
        ", edad=" + edad +
        ", identificacion='" + identificacion + '\'' +
        ", direccion='" + direccion + '\'' +
        ", telefono='" + telefono + '\'' +
        '}';
  }
}
