/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.EntidadReguladoraRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.EntidadReguladoraResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.EntidadReguladoraMapper;
import co.edu.unipiloto.CRUD_PGC.service.EntidadReguladoraService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/entidades")
@RequiredArgsConstructor
public class EntidadReguladoraController {

    private final EntidadReguladoraService service;

    @PostMapping
    public EntidadReguladoraResponseDTO crear(@RequestBody EntidadReguladoraRequestDTO dto) {
        var entidad = EntidadReguladoraMapper.toEntity(dto);
        return EntidadReguladoraMapper.toDTO(service.guardar(entidad));
    }

    @GetMapping
    public List<EntidadReguladoraResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(EntidadReguladoraMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntidadReguladoraResponseDTO obtener(@PathVariable Long id) {
        return EntidadReguladoraMapper.toDTO(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public EntidadReguladoraResponseDTO actualizar(@PathVariable Long id,
            @RequestBody EntidadReguladoraRequestDTO dto) {
        var entidad = EntidadReguladoraMapper.toEntity(dto);
        entidad.setId(id);
        return EntidadReguladoraMapper.toDTO(service.actualizar(id, entidad));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}/decreto")
    public void aplicarDecreto(@PathVariable Long id,
            @RequestParam double precio) {

        service.aplicarDecreto(id, precio);
    }
}
