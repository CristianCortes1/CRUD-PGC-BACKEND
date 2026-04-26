/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.VentaRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.VentaResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.VentaMapper;
import co.edu.unipiloto.CRUD_PGC.service.VentaService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService service;

    @PostMapping
    public void vender(@RequestBody VentaRequestDTO dto) {
        service.vender(
                dto.getUsuarioId(),
                dto.getEstacionId(),
                dto.getCantidad()
        );
    }

    @GetMapping
    public List<VentaResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(VentaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VentaResponseDTO obtener(@PathVariable Long id) {
        return VentaMapper.toDTO(service.buscarPorId(id));
    }
}
