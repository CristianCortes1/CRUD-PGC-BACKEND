/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.EstacionRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.EstacionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.EstacionMapper;
import co.edu.unipiloto.CRUD_PGC.service.DistribuidorService;
import co.edu.unipiloto.CRUD_PGC.service.EstacionService;
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
@RequestMapping("/estaciones")
@RequiredArgsConstructor
public class EstacionController {

    private final EstacionService service;
    private final DistribuidorService distribuidorService;

    @PostMapping
    public EstacionResponseDTO crear(@RequestBody EstacionRequestDTO dto) {
        var distribuidor = distribuidorService.buscarPorId(dto.getDistribuidorId());
        var estacion = EstacionMapper.toEntity(dto, distribuidor);
        return EstacionMapper.toDTO(service.guardar(estacion));
    }

    @GetMapping
    public List<EstacionResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(EstacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EstacionResponseDTO obtener(@PathVariable Long id) {
        return EstacionMapper.toDTO(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public EstacionResponseDTO actualizar(@PathVariable Long id,
            @RequestBody EstacionRequestDTO dto) {
        var distribuidor = distribuidorService.buscarPorId(dto.getDistribuidorId());
        var estacion = EstacionMapper.toEntity(dto, distribuidor);
        estacion.setId(id);
        return EstacionMapper.toDTO(service.actualizar(id, estacion));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}/precio")
    public void asignarPrecio(@PathVariable Long id,
            @RequestParam double margen) {
        service.asignarPrecio(id, margen);
    }
}
