package co.com.sofka.prueba.pruebajavaspring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

  private Integer clienteId;
  @NotNull
  @NotBlank
  private String contrasena;
  @NotNull
  private Boolean estado;
  @NotNull
  @NotBlank
  private String nombre;
  @NotNull
  @NotBlank
  private String genero;
  @NotNull
  private Integer edad;
  @NotNull
  @NotBlank
  private String identificacion;
  @NotNull
  @NotBlank
  private String direccion;
  @NotNull
  @NotBlank
  private String telefono;
}
