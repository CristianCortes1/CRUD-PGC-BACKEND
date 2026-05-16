package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.TransactionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Transaction;
import java.time.format.DateTimeFormatter;

public class TransaccionMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static TransactionResponseDTO toDTO(Transaction transaccion) {
        String fechaFormateada = null;
        if (transaccion.getFecha() != null) {
            fechaFormateada = transaccion.getFecha().format(FORMATTER);
        }

        return TransactionResponseDTO.builder()
                .id(transaccion.getId())
                .tipoVehiculo(transaccion.getTipoVehiculo())
                .cantidad(transaccion.getCantidad())
                .total(transaccion.getTotal())
                .fechaFormateada(fechaFormateada)
                .estacionId(transaccion.getEstacion() == null ? null : transaccion.getEstacion().getId())
                .estacionUsername(transaccion.getEstacion() == null ? null : transaccion.getEstacion().getUsername())
                .userId(transaccion.getCliente() == null ? null : transaccion.getCliente().getId())
                .userUsername(transaccion.getCliente() == null ? null : transaccion.getCliente().getUsername())
                .estado(transaccion.getEstado())
                .combustible(CombustibleMapper.toDTO(transaccion.getCombustible()))
                .build();
    }
}
