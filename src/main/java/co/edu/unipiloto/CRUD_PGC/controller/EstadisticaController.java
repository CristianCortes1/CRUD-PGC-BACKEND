/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.EstadisticaResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.EstadisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/estadisticas")
@RequiredArgsConstructor
public class EstadisticaController {

    private final EstadisticaService service;

    @GetMapping
    public EstadisticaResponseDTO obtener() {
        return service.obtenerEstadisticas();
    }
}
