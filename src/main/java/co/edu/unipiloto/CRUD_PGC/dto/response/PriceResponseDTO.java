package co.edu.unipiloto.CRUD_PGC.dto.response;

import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponseDTO {
    private Long id;
    private double precio;
    private Long estacionId;
    private String estacionUsername;
    private Fuel combustible;
}
