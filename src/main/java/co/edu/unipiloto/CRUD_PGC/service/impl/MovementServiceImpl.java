/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.response.MovementResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.MovementMapper;
import co.edu.unipiloto.CRUD_PGC.repository.MovementRepository;
import co.edu.unipiloto.CRUD_PGC.service.MovementService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;

    @Override
    public List<MovementResponseDTO> getAllMovements(Long id) {
        return movementRepository.findByEstacionId(id).stream()
                .map(MovementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovementResponseDTO> getMovementsOrderByType(Long id) {
        return movementRepository.findByEstacionIdOrderByTipoMovimientoAsc(id).stream()
                .map(MovementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovementResponseDTO> getMovementsByDate(Long id) {
        return movementRepository.findByEstacionIdOrderByFechaAsc(id).stream()
                .map(MovementMapper::toDTO)
                .collect(Collectors.toList());
    }
}
