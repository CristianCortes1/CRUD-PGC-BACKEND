package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.FuelResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Fuel;

public class FuelMapper {
    public static FuelResponseDTO toDTO(Fuel combustible) {
        if (combustible == null) {
            return null;
        }
        return FuelResponseDTO.builder()
                .id(combustible.getId())
                .nombre(combustible.getNombre())
                .build();
    }
}
