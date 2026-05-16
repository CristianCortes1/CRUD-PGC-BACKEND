/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.MovementResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.MovementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("api/movements")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @GetMapping("/{id}")
    public List<MovementResponseDTO> getAllMovements(@PathVariable Long id) {
        return movementService.getAllMovements(id);
    }

    @GetMapping("type/{id}")
    public List<MovementResponseDTO> getMovementsOrderByType(@PathVariable Long id) {
        return movementService.getMovementsOrderByType(id);
    }

    @GetMapping("date/{id}")
    public List<MovementResponseDTO> getMovementsByDate(@PathVariable Long id) {
        return movementService.getMovementsByDate(id);
    }

}
