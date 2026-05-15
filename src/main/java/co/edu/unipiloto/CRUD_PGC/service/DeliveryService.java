package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.request.DeliveryRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.DeliveryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import java.util.List;

public interface DeliveryService {
    Delivery confirmar(Long entregaId);

    void insertDelivery(DeliveryRequestDTO dto);

    Delivery markAsDelivered(Long deliveryId, String placa);

    List<DeliveryResponseDTO> getDeliveriesByState(Long userId, String estado);
}
