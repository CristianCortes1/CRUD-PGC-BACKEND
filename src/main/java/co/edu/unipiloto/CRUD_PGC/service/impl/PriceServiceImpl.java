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
    public List<PriceResponseDTO> getAllPricesByEstacionId(Long id) {
        return precioRepository.findByEstacionId(id).stream()
                .map(PriceMapper::toDTO)
                .collect(Collectors.toList());
    }

}
