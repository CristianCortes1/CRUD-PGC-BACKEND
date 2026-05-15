package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.request.RuleRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.RuleResponseDTO;
import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.mapper.RuleMapper;
import co.edu.unipiloto.CRUD_PGC.model.Rule;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.repository.RuleRepository;
import co.edu.unipiloto.CRUD_PGC.repository.UserRepository;
import co.edu.unipiloto.CRUD_PGC.service.RuleService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;
    private final UserRepository userRepository;

    @Override
    public List<RuleResponseDTO> getAllRules() {
        return ruleRepository.findAllByOrderByIdAsc().stream()
                .map(RuleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Rule saveRule(RuleRequestDTO dto) {

        User admin = userRepository.findById(dto.getAdminId())
                .orElseThrow(() -> new ResourceNotFoundException("admin no encontrado"));

        Rule rule = ruleRepository.findByTipoVehiculo(dto.getTipoVehiculo())
                .orElse(new Rule());

        rule.setTipoVehiculo(dto.getTipoVehiculo());
        rule.setPrecio(dto.getPrecio());
        rule.setAdmin(admin);

        return ruleRepository.save(rule);
    }

}
