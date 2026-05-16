package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.exception.StockInsuficienteException;
import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.dto.request.TransactionRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.TransactionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.TransaccionMapper;
import co.edu.unipiloto.CRUD_PGC.model.Transaction;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
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
    public List<TransactionResponseDTO> getAllTransactions(Long estacionId) {
        return transaccionRepository.findByEstacionId(estacionId)
                .stream()
                .map(TransaccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactionsByUser(Long usuarioId) {
        return transaccionRepository.findByUsuarioIdOrderByFechaAsc(usuarioId)
                .stream()
                .map(TransaccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByUserOrderedByStation(Long usuarioId) {
        return transaccionRepository.findByUsuarioIdOrderedByStation(usuarioId)
                .stream()
                .map(TransaccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<TransactionResponseDTO> getTransactionsByUserOrderedByDate(Long usuarioId) {
        return transaccionRepository.findByUsuarioIdOrderByFechaDesc(usuarioId)
                .stream()
                .map(TransaccionMapper::toDTO)
                .toList();
    }

    @Override
    public List<TransactionResponseDTO> getValidatedTransactions() {
        List<Transaction> transacciones = transaccionRepository.findAll();

        for (Transaction t : transacciones) {
            if (t.getEstacion() != null && t.getCombustible() != null) {
                Long estacionId = t.getEstacion().getId();
                Long combustibleId = t.getCombustible().getId();

                precioRepository.findByOwnerIdOrderByIdAsc(estacionId)
                        .stream()
                        .filter(p -> p.getCombustible() != null && p.getCombustible().getId().equals(combustibleId))
                        .findFirst()
                        .ifPresent(precio -> {
                            double precioCalculado = precio.getPrecio() * t.getCantidad();
                            String estado = Math.abs(t.getTotal() - precioCalculado) < 0.01 ? "CUMPLE" : "NO CUMPLE";
                            t.setEstado(estado);
                        });
            }
        }

        return transacciones.stream()
                .map(TransaccionMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public void insertarTransaccion(TransactionRequestDTO dto) {
        User estacion = usuarioRepository.findById(dto.getEstacionId())
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));

        User cliente = null;
        if (dto.getUserId() != null) {
            cliente = usuarioRepository.findById(dto.getUserId()).orElse(null);
        }

        LocalDateTime fecha = null;
        if (dto.getFecha() != null && !dto.getFecha().isEmpty()) {
            fecha = LocalDateTime.parse(dto.getFecha());
        } else {
            fecha = LocalDateTime.now();
        }

        Transaction transaccion = Transaction.builder()
                .tipoVehiculo(dto.getTipoVehiculo())
                .cantidad(dto.getCantidad())
                .total(dto.getTotal())
                .fecha(fecha)
                .estacion(estacion)
                .combustible(dto.getCombustible())
                .build();

        if (cliente != null) {
            transaccion.setCliente(cliente);
        }

        transaccionRepository.save(transaccion);
    }
}
