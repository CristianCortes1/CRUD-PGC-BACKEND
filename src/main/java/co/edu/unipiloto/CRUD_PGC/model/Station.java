package co.edu.unipiloto.CRUD_PGC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {
    private Long id;

    private String nombre;
    private String direccion;
    private double latitud;
    private double longitud;
    private double distancia;

    private double precioCorriente;
    private double precioExtra;
    private double precioDiesel;
    private double precioGNV;
}
