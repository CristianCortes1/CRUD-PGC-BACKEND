/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.Distribuidor;
import co.edu.unipiloto.CRUD_PGC.repository.DistribuidorRepository;
import co.edu.unipiloto.CRUD_PGC.service.DistribuidorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class DistribuidorServiceImpl implements DistribuidorService {

    private final DistribuidorRepository repo;

    @Override
    public Distribuidor guardar(Distribuidor distribuidor) {
        return repo.save(distribuidor);
    }

    @Override
    public List<Distribuidor> listar() {
        return repo.findAll();
    }

    @Override
    public Distribuidor buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor no encontrado"));
    }

    @Override
    public Distribuidor actualizar(Long id, Distribuidor distribuidor) {
        Distribuidor existente = buscarPorId(id);

        existente.setNombre(distribuidor.getNombre());
        existente.setUbicacion(distribuidor.getUbicacion());
        existente.setEntidadReguladora(distribuidor.getEntidadReguladora());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}