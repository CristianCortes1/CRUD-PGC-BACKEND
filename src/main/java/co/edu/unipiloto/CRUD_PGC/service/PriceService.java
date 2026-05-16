package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import java.util.List;

public interface PriceService {

    List<PriceResponseDTO> getAllPricesByOwnerId(Long ownerId);
    PriceResponseDTO getPriceByOwnerAndCombustible(Long ownerId, Long combustibleId);
    PriceResponseDTO updatePrice(Long priceId, Double newPrice);
}
