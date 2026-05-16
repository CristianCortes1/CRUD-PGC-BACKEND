package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.InventoryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Inventory;

public class InventarioMapper {
    public static InventoryResponseDTO toDTO(Inventory inventario) {
        return InventoryResponseDTO.builder()
                .id(inventario.getId())
                .ownerId(inventario.getOwner() == null ? null : inventario.getOwner().getId())
                .ownerUsername(inventario.getOwner() == null ? null : inventario.getOwner().getUsername())
                .combustible(FuelMapper.toDTO(inventario.getCombustible()))
                .cantidadActual(inventario.getCantidadCombustible())
                .capacidadMaxima(inventario.getCapacidadMaxima())
                .nivelMinimo(inventario.getNivelMinimo())
                .build();
    }
    
    
}
