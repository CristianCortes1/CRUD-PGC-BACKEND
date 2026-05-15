package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.TransactionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Transaction;

public class TransaccionMapper {
    public static TransactionResponseDTO toDTO(Transaction transaccion) {
        return TransactionResponseDTO.builder()
                .id(transaccion.getId())
                .tipoVehiculo(transaccion.getTipoVehiculo())
                .cantidad(transaccion.getCantidad())
                .total(transaccion.getTotal())
                .fecha(transaccion.getFecha())
                .estacionId(transaccion.getEstacion() == null ? null : transaccion.getEstacion().getId())
                .clienteId(transaccion.getCliente() == null ? null : transaccion.getCliente().getId())
                .combustible(CombustibleMapper.toDTO(transaccion.getCombustible()))
                .build();
    }
}
