package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.SubsidyResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Subsidy;

public class SubsidyMapper {
    public static SubsidyResponseDTO toDTO(Subsidy subsidy) {
        if (subsidy == null) {
            return null;
        }
        return SubsidyResponseDTO.builder()
                .id(subsidy.getId().intValue())
                .subsidio(subsidy.isSubsidio() ? 1 : 0)
                .porcentaje(subsidy.getPorcentaje())
                .usuario(subsidy.getUsuario())
                .build();
    }
}