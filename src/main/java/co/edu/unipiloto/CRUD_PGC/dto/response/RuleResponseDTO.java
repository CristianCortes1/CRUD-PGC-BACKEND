package co.edu.unipiloto.CRUD_PGC.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RuleResponseDTO {

    private Long id;
    private String tipoVehiculo;
    private double precio;
    private Long adminId;
    private String adminUsername;
    private String fechaFormateada;
}
