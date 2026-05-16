package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import java.util.List;

public interface PriceService {

    List<PriceResponseDTO> getAllPricesByEstacionId(Long id);
}
