package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.response.SubsidyResponseDTO;

public interface SubsidyService {
    SubsidyResponseDTO getSubsidyById(int id);
}