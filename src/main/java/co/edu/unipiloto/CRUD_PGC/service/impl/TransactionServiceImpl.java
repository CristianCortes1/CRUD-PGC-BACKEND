package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.exception.StockInsuficienteException;
import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.model.Transaction;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.service.TransactionService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.unipiloto.CRUD_PGC.repository.FuelRepository;
import co.edu.unipiloto.CRUD_PGC.repository.UserRepository;
import co.edu.unipiloto.CRUD_PGC.repository.InventoryRepository;
import co.edu.unipiloto.CRUD_PGC.repository.PriceRepository;
import co.edu.unipiloto.CRUD_PGC.repository.TransactionRepository;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transaccionRepository;
    private final UserRepository usuarioRepository;
    private final FuelRepository combustibleRepository;
    private final InventoryRepository inventarioRepository;
    private final PriceRepository precioRepository;

    @Override
    @Transactional
    public Transaction crearTransaction(Long estacionId, Long clienteId, Long combustibleId, String tipoVehiculo, double cantidad) {
        User estacion = usuarioRepository.findById(estacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Station no encontrada"));
        User cliente = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        Fuel combustible = combustibleRepository.findById(combustibleId)
                .orElseThrow(() -> new ResourceNotFoundException("Fuel no encontrado"));

        Inventory inventario = inventarioRepository
                .findByEstacionIdAndCombustibleId(estacionId, combustibleId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory no encontrado"));

        if (inventario.getCantidadCombustible()< cantidad) {
            throw new StockInsuficienteException("Stock insuficiente en inventario");
        }

        Price precio = precioRepository.findByEstacionId(estacionId)
                .stream()
                .filter(p -> p.getCombustible() != null && p.getCombustible().getId().equals(combustibleId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Price no encontrado"));

        double total = precio.getPrecio() * cantidad;

        inventario.setCantidadCombustible(inventario.getCantidadCombustible()- cantidad);
        inventarioRepository.save(inventario);

        Transaction transaccion = Transaction.builder()
                .tipoVehiculo(tipoVehiculo)
                .combustible(combustible)
                .cantidad(cantidad)
                .total(total)
                .fecha(LocalDateTime.now())
                .estacion(estacion)
                .cliente(cliente)
                .build();

        return transaccionRepository.save(transaccion);
    }
}
