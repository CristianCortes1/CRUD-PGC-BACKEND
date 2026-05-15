package co.edu.unipiloto.CRUD_PGC.dto.response;

import co.edu.unipiloto.CRUD_PGC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubsidyResponseDTO {
    private int id;
    private int subsidio;
    private Double porcentaje;
    private User usuario;
}