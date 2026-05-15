package co.edu.unipiloto.CRUD_PGC.model;

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

    private Double latitud;
    private Double longitud;
    private Double distancia;

    private Double precioCorriente;
    private Double precioExtra;
    private Double precioDiesel;
    private Double precioGNV;
}
