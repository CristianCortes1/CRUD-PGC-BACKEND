package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.model.User;

public class PriceMapper {
    public static PriceResponseDTO toDTO(Price precio) {
        User estacion = precio.getEstacion();
        return PriceResponseDTO.builder()
                .id(precio.getId())
                .precio(precio.getPrecio())
                .estacionId(estacion.getId())
                .estacionUsername(estacion.getNombreCompleto())
                .combustible(precio.getCombustible())
                .build();
    }
}
