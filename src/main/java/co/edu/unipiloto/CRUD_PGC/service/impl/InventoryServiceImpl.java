package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import co.edu.unipiloto.CRUD_PGC.service.InventoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventarioRepository;

    @Override
    public List<Inventory> buscarPorOwner(Long ownerId) {
        return inventarioRepository.findByOwnerId(ownerId);
    }

    @Override
    public Inventory actualizarCantidad(Long inventoryId, double nuevaCantidad) {
        Inventory inventory = inventarioRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: " + inventoryId));
        inventory.setCantidadCombustible(nuevaCantidad);
        return inventarioRepository.save(inventory);
    }
}
