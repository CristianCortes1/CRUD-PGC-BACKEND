package co.edu.unipiloto.CRUD_PGC.dto.request;

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
    private Long clienteId;
    private Long combustibleId;
    private String tipoVehiculo;
    private double cantidad;
}
