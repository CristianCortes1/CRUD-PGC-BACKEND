package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.DeliveryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;

public class EntregaMapper {
    public static DeliveryResponseDTO toDTO(Delivery entrega) {
        return DeliveryResponseDTO.builder()
                .id(entrega.getId())
                .placa(entrega.getPlaca())
                .cantidad(entrega.getCantidad())
                .estado(entrega.getEstado() == null ? null : entrega.getEstado())
                .fecha(entrega.getFecha() == null ? null : entrega.getFecha().toString())
                .fechaConfirmacion(entrega.getFechaConfirmacion() == null ? null : entrega.getFechaConfirmacion().toString())
                .estacionDestinoId(entrega.getEstacion() == null ? null : entrega.getEstacion().getId())
                .distribuidorId(entrega.getDistribuidor() == null ? null : entrega.getDistribuidor().getId())
                .confirmadoPorId(entrega.getConfirmadoPor() == null ? null : entrega.getConfirmadoPor().getId())
                .combustible(CombustibleMapper.toDTO(entrega.getCombustible()))
                .build();
    }
}
