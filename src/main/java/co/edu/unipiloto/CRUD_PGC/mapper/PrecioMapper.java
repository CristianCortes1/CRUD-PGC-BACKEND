package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.model.User;

public class PrecioMapper {
    public static PriceResponseDTO toDTO(Price precio) {
        User estacion = precio.getEstacion();
        return PriceResponseDTO.builder()
                .id(precio.getId())
                .precio(precio.getPrecio())
                .estacionId(estacion == null ? null : estacion.getId())
                .estacionNombre(estacion == null ? null : estacion.getNombreCompleto())
                .estacionLatitud(estacion == null ? null : estacion.getLatitud())
                .estacionLongitud(estacion == null ? null : estacion.getLongitud())
                .combustible(CombustibleMapper.toDTO(precio.getCombustible()))
                .build();
    }
}
