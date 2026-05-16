package co.edu.unipiloto.CRUD_PGC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transacciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoVehiculo;
    private double cantidad;
    private double total;
    private LocalDateTime fecha;

    @jakarta.persistence.Transient
    private String fechaFormateada;

    @jakarta.persistence.Transient
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_combustible")
    private Fuel combustible;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private User estacion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usuario;

    @jakarta.persistence.Transient
    private User cliente;

    public User getUsuario() {
        return usuario != null ? usuario : cliente;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
        this.cliente = usuario;
    }

    public User getCliente() {
        return cliente != null ? cliente : usuario;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
        this.usuario = cliente;
    }

    public String getFechaFormateada() {
        if (fechaFormateada == null && fecha != null) {
            fechaFormateada = fecha.toString();
        }
        return fechaFormateada;
    }
}
