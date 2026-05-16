package co.edu.unipiloto.CRUD_PGC.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDTO {
    private Long id;
    private String tipoVehiculo;
    private double cantidad;
    private double total;
    private String fechaFormateada;
    private Long estacionId;
    private String estacionUsername;
    private Long userId;
    private String userUsername;
    private String estado;
    private FuelResponseDTO combustible;
}
