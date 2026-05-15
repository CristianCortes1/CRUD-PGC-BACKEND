package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.response.SubsidyResponseDTO;
import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.mapper.SubsidyMapper;
import co.edu.unipiloto.CRUD_PGC.model.Subsidy;
import co.edu.unipiloto.CRUD_PGC.repository.SubsidyRepository;
import co.edu.unipiloto.CRUD_PGC.service.SubsidyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubsidyServiceImpl implements SubsidyService {

    private final SubsidyRepository subsidyRepository;

    @Override
    public SubsidyResponseDTO getSubsidyById(int id) {
        Subsidy subsidy = subsidyRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("Subsidy not found with id: " + id));
        return SubsidyMapper.toDTO(subsidy);
    }
}