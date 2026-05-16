package co.edu.unipiloto.CRUD_PGC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "id_combustible")
    private Fuel combustible;

    @jakarta.persistence.Column(name = "cantidad_combustible")
    private double cantidadCombustible;

    @jakarta.persistence.Column(name = "capacidad_maxima")
    private double capacidadMaxima;

    @jakarta.persistence.Column(name = "nivel_minimo")
    private double nivelMinimo;
}
