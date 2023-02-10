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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    private BigDecimal saldoInicial;

    @Column(name = "saldo_actual", nullable = false)
    private BigDecimal saldoActual;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
    @JsonIgnore
    private List<Movimientos> movimientos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
  
}
