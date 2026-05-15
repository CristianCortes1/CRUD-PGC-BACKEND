package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.request.RuleRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.RuleResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Rule;
import java.util.List;

public interface RuleService {
    List<RuleResponseDTO> getAllRules();

    Rule saveRule(RuleRequestDTO dto);
}
