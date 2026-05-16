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
@Table(name = "entregas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private double cantidad;
    private Double total;

    private LocalDateTime fecha;

    @jakarta.persistence.Transient
    private String fechaFormateada;

    @jakarta.persistence.Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_combustible")
    private Fuel combustible;

    @ManyToOne
    @JoinColumn(name = "estacion_destino_id")
    private User estacion;

    @ManyToOne
    @JoinColumn(name = "distribuidor_id")
    private User distribuidor;

    @JoinColumn(name = "confirmado_por")
    @ManyToOne
    private User confirmadoPor;

    @jakarta.persistence.Column(name = "fecha_confirmacion")
    private LocalDateTime fechaConfirmacion;

    public String getFechaFormateada() {
        if (fechaFormateada == null && fecha != null) {
            fechaFormateada = fecha.toString();
        }
        return fechaFormateada;
    }
}
