package co.edu.unipiloto.CRUD_PGC.dto.response;

import java.time.LocalDateTime;
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
    private LocalDateTime fecha;
    private Long estacionId;
    private Long clienteId;
    private FuelResponseDTO combustible;
}
