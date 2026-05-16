package co.edu.unipiloto.CRUD_PGC.dto.request;

import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequestDTO {
    private Long estacionId;
    private Long userId;
    private Fuel combustible;
    private String tipoVehiculo;
    private double cantidad;
    private double total;
    private String fecha;
}
