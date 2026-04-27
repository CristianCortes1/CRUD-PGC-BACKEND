/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.SolicitudRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.SolicitudResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.SolicitudMapper;
import co.edu.unipiloto.CRUD_PGC.service.SolicitudService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;

    @PostMapping
    public void solicitar(@RequestBody SolicitudRequestDTO dto) {
        service.solicitar(dto.getEstacionId(), dto.getDistribuidorId(), dto.getCantidad());
    }

    @GetMapping
    public List<SolicitudResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(SolicitudMapper::toDTO)
                .collect(Collectors.toList());
    }
}
