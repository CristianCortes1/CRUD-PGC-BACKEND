package co.edu.unipiloto.CRUD_PGC.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponseDTO {
    private Long id;
    private Long ownerId;
    private String ownerUsername;
    private FuelResponseDTO combustible;
    private double cantidadActual;
    private double capacidadMaxima;
    private double nivelMinimo;
}
