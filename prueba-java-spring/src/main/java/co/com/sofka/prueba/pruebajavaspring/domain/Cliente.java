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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

}
