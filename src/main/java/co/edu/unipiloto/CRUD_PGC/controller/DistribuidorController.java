/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.DistribuidorRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.DistribuidorResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.DistribuidorMapper;
import co.edu.unipiloto.CRUD_PGC.service.DistribuidorService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/distribuidores")
@RequiredArgsConstructor
public class DistribuidorController {

    private final DistribuidorService service;
    private final EntidadReguladoraService entidadService;

    @PostMapping
    public DistribuidorResponseDTO crear(@RequestBody DistribuidorRequestDTO dto) {
        var entidad = entidadService.buscarPorId(dto.getEntidadReguladoraId());
        var distribuidor = DistribuidorMapper.toEntity(dto, entidad);
        return DistribuidorMapper.toDTO(service.guardar(distribuidor));
    }

    @GetMapping
    public List<DistribuidorResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(DistribuidorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DistribuidorResponseDTO obtener(@PathVariable Long id) {
        return DistribuidorMapper.toDTO(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public DistribuidorResponseDTO actualizar(@PathVariable Long id,
                                              @RequestBody DistribuidorRequestDTO dto) {
        var entidad = entidadService.buscarPorId(dto.getEntidadReguladoraId());
        var distribuidor = DistribuidorMapper.toEntity(dto, entidad);
        distribuidor.setId(id);
        return DistribuidorMapper.toDTO(service.actualizar(id, distribuidor));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
