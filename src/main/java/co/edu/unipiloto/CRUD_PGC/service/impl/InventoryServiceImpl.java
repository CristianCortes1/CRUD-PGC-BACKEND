package co.edu.unipiloto.CRUD_PGC.service.impl;

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
    public List<Inventory> buscarPorEstacion(Long estacionId) {
        return inventarioRepository.findByEstacionId(estacionId);
    }
}
