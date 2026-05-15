package co.edu.unipiloto.CRUD_PGC.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryResponseDTO {
    private Long id;
    private String placa;
    private double cantidad;
    private String estado;
    private String fechaFormateada;
    private String fechaConfirmacion;
    private Long estacionDestinoId;
    private String estacionUsername;
    private Long distribuidorId;
    private String distribuidorUsername;
    private Long confirmadoPorId;
    private FuelResponseDTO combustible;
}
