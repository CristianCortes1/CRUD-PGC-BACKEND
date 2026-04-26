/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.AbastecimientoRequestDTO;
import co.edu.unipiloto.CRUD_PGC.service.AbastecimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/abastecimientos")
@RequiredArgsConstructor
public class AbastecimientoController {

    private final AbastecimientoService service;
    
    @PostMapping
    public void abastecer(@RequestBody AbastecimientoRequestDTO dto) {
        service.abastecer(dto.getDistribuidorId(),
                dto.getEstacionId(),
                dto.getCantidad());
    }
}
