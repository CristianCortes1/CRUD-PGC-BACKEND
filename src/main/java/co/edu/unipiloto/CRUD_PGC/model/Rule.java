package co.edu.unipiloto.CRUD_PGC.model;

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
@Table(name = "reglas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoVehiculo;
    private double precio;
    private LocalDateTime fecha;

    @jakarta.persistence.Transient
    private String fechaFormateada;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    public String getFechaFormateada() {
        if (fechaFormateada == null && fecha != null) {
            fechaFormateada = fecha.toString();
        }
        return fechaFormateada;
    }
}
