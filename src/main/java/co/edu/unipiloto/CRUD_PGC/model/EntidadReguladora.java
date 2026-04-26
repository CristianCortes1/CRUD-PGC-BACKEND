package co.edu.unipiloto.CRUD_PGC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cristian-cortes
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntidadReguladora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;
    private double precioBaseCombustible;
}
