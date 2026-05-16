package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import java.util.List;

public interface InventoryService {
    List<Inventory> buscarPorOwner(Long ownerId);
    Inventory actualizarCantidad(Long inventoryId, double nuevaCantidad);
}
