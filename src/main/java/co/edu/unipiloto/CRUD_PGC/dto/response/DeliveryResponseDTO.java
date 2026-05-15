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
    private String fecha;
    private String fechaConfirmacion;
    private Long estacionDestinoId;
    private Long distribuidorId;
    private Long confirmadoPorId;
    private FuelResponseDTO combustible;
}
