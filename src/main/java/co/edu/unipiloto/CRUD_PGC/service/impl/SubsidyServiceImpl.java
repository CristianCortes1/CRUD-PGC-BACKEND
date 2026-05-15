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
    public SubsidyResponseDTO getSubsidyByUserId(int userId) {
        Subsidy subsidy = subsidyRepository.findByUsuario_Id((long) userId)
                .orElseThrow(() -> new ResourceNotFoundException("Subsidy not found for user id: " + userId));
        return SubsidyMapper.toDTO(subsidy);
    }
}