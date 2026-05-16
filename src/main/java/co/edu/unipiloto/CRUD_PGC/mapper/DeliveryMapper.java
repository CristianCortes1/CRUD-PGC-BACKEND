package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.DeliveryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeliveryMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static DeliveryResponseDTO toDTO(Delivery entrega) {
        String fechaFormateada = null;
        if (entrega.getFecha() != null) {
            fechaFormateada = entrega.getFecha().format(FORMATTER);
        }

        String fechaConfirmacion = null;
        if (entrega.getFechaConfirmacion() != null) {
            fechaConfirmacion = entrega.getFechaConfirmacion().format(FORMATTER);
        }

        return DeliveryResponseDTO.builder()
                .id(entrega.getId())
                .placa(entrega.getPlaca())
                .cantidad(entrega.getCantidad())
                .estado(entrega.getEstado() == null ? null : entrega.getEstado())
                .fechaFormateada(fechaFormateada)
                .fechaConfirmacion(fechaConfirmacion)
                .estacionDestinoId(entrega.getEstacion() == null ? null : entrega.getEstacion().getId())
                .estacionUsername(entrega.getEstacion() == null ? null : entrega.getEstacion().getUsername())
                .distribuidorId(entrega.getDistribuidor() == null ? null : entrega.getDistribuidor().getId())
                .distribuidorUsername(entrega.getDistribuidor() == null ? null : entrega.getDistribuidor().getUsername())
                .confirmadoPorId(entrega.getConfirmadoPor() == null ? null : entrega.getConfirmadoPor().getId())
                .combustible(FuelMapper.toDTO(entrega.getCombustible()))
                .build();
    }
}
