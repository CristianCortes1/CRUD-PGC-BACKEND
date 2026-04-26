/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.EntidadReguladora;
import co.edu.unipiloto.CRUD_PGC.repository.EntidadReguladoraRepository;
import co.edu.unipiloto.CRUD_PGC.service.EntidadReguladoraService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class EntidadReguladoraServiceImpl implements EntidadReguladoraService {

    private final EntidadReguladoraRepository repo;

    @Override
    public EntidadReguladora guardar(EntidadReguladora entidad) {
        return repo.save(entidad);
    }

    @Override
    public List<EntidadReguladora> listar() {
        return repo.findAll();
    }

    @Override
    public EntidadReguladora buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entidad no encontrada"));
    }

    @Override
    public EntidadReguladora actualizar(Long id, EntidadReguladora entidad) {
        EntidadReguladora existente = buscarPorId(id);

        existente.setNombre(entidad.getNombre());
        existente.setPais(entidad.getPais());
        existente.setPrecioBaseCombustible(entidad.getPrecioBaseCombustible());
        
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void aplicarDecreto(Long id, double nuevoPrecio) {

        EntidadReguladora entidad = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entidad no encontrada"));

        entidad.setPrecioBaseCombustible(nuevoPrecio);

        repo.save(entidad);
    }
}
