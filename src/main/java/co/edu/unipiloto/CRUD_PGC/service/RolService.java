/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.response.RolResponseDTO;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface RolService {
    List<RolResponseDTO> getAllRoles(); 
}
