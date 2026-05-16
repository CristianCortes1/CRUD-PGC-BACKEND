package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.request.DeliveryRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.DeliveryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.mapper.DeliveryMapper;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import co.edu.unipiloto.CRUD_PGC.model.EntregaEstado;
import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unipiloto.CRUD_PGC.repository.DeliveryRepository;
import co.edu.unipiloto.CRUD_PGC.repository.FuelRepository;
import co.edu.unipiloto.CRUD_PGC.repository.InventoryRepository;
import co.edu.unipiloto.CRUD_PGC.repository.PriceRepository;
import co.edu.unipiloto.CRUD_PGC.repository.UserRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository entregaRepository;
    private final InventoryRepository inventarioRepository;
    private final UserRepository userRepository;
    private final FuelRepository fuelRepository;
    private final PriceRepository priceRepository;

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

        Inventory inventarioEstacion = inventarioRepository
                .findByOwnerIdAndCombustibleId(entrega.getEstacion().getId(), entrega.getCombustible().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Inventory de estación no encontrado"));

        inventarioEstacion.setCantidadCombustible(inventarioEstacion.getCantidadCombustible() + entrega.getCantidad());
        inventarioRepository.save(inventarioEstacion);

        if (entrega.getDistribuidor() != null) {
            Inventory inventarioDistribuidor = inventarioRepository
                    .findByOwnerIdAndCombustibleId(entrega.getDistribuidor().getId(), entrega.getCombustible().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Inventory de distribuidor no encontrado"));

            inventarioDistribuidor.setCantidadCombustible(inventarioDistribuidor.getCantidadCombustible() - entrega.getCantidad());
            inventarioRepository.save(inventarioDistribuidor);
        }

        entrega.setEstado(EntregaEstado.CONFIRMADO.name());
        return entregaRepository.save(entrega);
    }

    @Override
    @Transactional
    public void insertDelivery(DeliveryRequestDTO dto) {
        User estacion = userRepository.findById((long) dto.getEstacionId())
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada con ID: " + dto.getEstacionId()));

        User distribuidor = userRepository.findById((long) dto.getDistribuidorId())
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor no encontrado con ID: " + dto.getDistribuidorId()));

        Fuel combustible = fuelRepository.findById(dto.getCombustible().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Combustible no encontrado"));

        double total = 0;
        var precio = priceRepository.findByOwnerIdAndCombustibleId(distribuidor.getId(), combustible.getId());
        if (precio.isPresent()) {
            total = dto.getCantidad() * precio.get().getPrecio();
        }

        Delivery entrega = Delivery.builder()
                .placa(dto.getPlaca())
                .cantidad(dto.getCantidad())
                .total(total)
                .combustible(combustible)
                .estacion(estacion)
                .distribuidor(distribuidor)
                .estado(dto.getEstado() != null ? dto.getEstado() : "PENDIENTE")
                .fecha(java.time.LocalDateTime.now())
                .build();

        entregaRepository.save(entrega);
    }

    @Override
    @Transactional
    public Delivery markAsDelivered(Long deliveryId, String placa) {
        Delivery entrega = entregaRepository.findById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery no encontrado"));

        entrega.setPlaca(placa);
        entrega.setEstado("ENTREGADO");
        return entregaRepository.save(entrega);
    }

    @Override
    public List<DeliveryResponseDTO> getDeliveriesByState(Long userId, String estado) {
        if (estado == null || (!estado.equals("PENDIENTE") && !estado.equals("ENTREGADO") && !estado.equals("CONFIRMADO"))) {
            throw new IllegalArgumentException("Estado inválido. Debe ser PENDIENTE, ENTREGADO o CONFIRMADO");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + userId));

        if (user.getRol() == null) {
            throw new IllegalArgumentException("El usuario no tiene un rol asignado");
        }

        Long rolId = user.getRol().getId();
        if (rolId == 5) {
            return entregaRepository.findByDistribuidorIdAndEstado(userId, estado)
                    .stream()
                    .map(DeliveryMapper::toDTO)
                    .toList();
        } else {
            return entregaRepository.findByEstacionIdAndEstado(userId, estado)
                    .stream()
                    .map(DeliveryMapper::toDTO)
                    .toList();
        }
    }
}
