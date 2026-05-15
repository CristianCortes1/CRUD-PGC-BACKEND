/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.RolResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.RolService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {
        private final RolService rolService;

        @GetMapping
        public List<RolResponseDTO> getAllRoles(){
            return rolService.getAllRoles();
        }
    
    
}
