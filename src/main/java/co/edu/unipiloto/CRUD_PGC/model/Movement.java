package co.edu.unipiloto.CRUD_PGC.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "movimientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Immutable
public class Movement {

    @Id
    private Long id;
    @Column(name = "tipo")
    private String tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "id_combustible")
    private Fuel combustible;

    private double cantidad;

    private Double total;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private User estacion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usuario;

    @jakarta.persistence.Column(name = "tipo_movimiento")
    private String tipoMovimiento;
}
