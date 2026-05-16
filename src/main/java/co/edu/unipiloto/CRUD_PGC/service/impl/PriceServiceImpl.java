package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.PriceMapper;
import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.service.PriceService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.PriceRepository;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository precioRepository;

    @Override
    public List<PriceResponseDTO> getAllPricesByOwnerId(Long ownerId) {
        return precioRepository.findByOwnerId(ownerId).stream()
                .map(PriceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PriceResponseDTO getPriceByOwnerAndCombustible(Long ownerId, Long combustibleId) {
        Price price = precioRepository.findByOwnerIdAndCombustibleId(ownerId, combustibleId)
                .orElseThrow(() -> new RuntimeException("Price not found"));
        return PriceMapper.toDTO(price);
    }

}
