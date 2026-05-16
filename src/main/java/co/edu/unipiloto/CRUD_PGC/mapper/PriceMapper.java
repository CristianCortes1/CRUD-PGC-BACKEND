package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.model.User;

public class PriceMapper {
    public static PriceResponseDTO toDTO(Price precio) {
        User owner = precio.getOwner();
        return PriceResponseDTO.builder()
                .id(precio.getId())
                .precio(precio.getPrecio())
                .ownerId(owner.getId())
                .ownerUsername(owner.getNombreCompleto())
                .combustible(precio.getCombustible())      
                .build();
    }
}
