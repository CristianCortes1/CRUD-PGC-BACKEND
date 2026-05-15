package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import co.edu.unipiloto.CRUD_PGC.model.EntregaEstado;
import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import co.edu.unipiloto.CRUD_PGC.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unipiloto.CRUD_PGC.repository.DeliveryRepository;
import co.edu.unipiloto.CRUD_PGC.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository entregaRepository;
    private final InventoryRepository inventarioRepository;

    @Override
    @Transactional
    public Delivery confirmar(Long entregaId) {
        Delivery entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery no encontrada"));

        if (entrega.getEstado().equalsIgnoreCase(EntregaEstado.CONFIRMADO.name())) {
            return entrega;
        }

        if (entrega.getEstacion() == null || entrega.getCombustible() == null) {
            throw new ResourceNotFoundException("Delivery sin estacion o combustible");
        }

        Inventory inventario = inventarioRepository
                .findByEstacionIdAndCombustibleId(entrega.getEstacion().getId(), entrega.getCombustible().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Inventory no encontrado"));

        inventario.setCantidadCombustible(inventario.getCantidadCombustible()+ entrega.getCantidad());
        inventarioRepository.save(inventario);

        entrega.setEstado(EntregaEstado.CONFIRMADO.name());
        return entregaRepository.save(entrega);
    }
}
