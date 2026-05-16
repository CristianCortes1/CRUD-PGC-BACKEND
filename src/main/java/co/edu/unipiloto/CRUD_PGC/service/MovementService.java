/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.response.MovementResponseDTO;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface MovementService {

    public List<MovementResponseDTO> getAllMovements(Long id);

    public List<MovementResponseDTO> getMovementsOrderByType(Long id);

    public List<MovementResponseDTO> getMovementsByDate(Long id);
    
}
