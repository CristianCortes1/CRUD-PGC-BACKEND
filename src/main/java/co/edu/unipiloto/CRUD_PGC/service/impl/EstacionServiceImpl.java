/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.MargenInvalidoException;
import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;
import co.edu.unipiloto.CRUD_PGC.repository.EstacionServicioRepository;
import co.edu.unipiloto.CRUD_PGC.service.EstacionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class EstacionServiceImpl implements EstacionService {

    private final EstacionServicioRepository repo;

    @Override
    public EstacionServicio guardar(EstacionServicio estacion) {
        return repo.save(estacion);
    }

    @Override
    public List<EstacionServicio> listar() {
        return repo.findAll();
    }

    @Override
    public EstacionServicio buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));
    }

    @Override
    public EstacionServicio actualizar(Long id, EstacionServicio estacion) {

        EstacionServicio existente = buscarPorId(id);

        existente.setNombre(estacion.getNombre());
        existente.setDireccion(estacion.getDireccion());
        existente.setDistribuidor(estacion.getDistribuidor());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void asignarPrecio(Long estacionId, double margen) {

        EstacionServicio estacion = repo.findById(estacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));

        if (margen < 0) {
            throw new MargenInvalidoException("El margen no puede ser negativo");
        }
        
        double precioBase = estacion.getDistribuidor()
                .getEntidadReguladora()
                .getPrecioBaseCombustible();

        double precioVenta = precioBase + margen;

        estacion.setMargenGanancia(margen);
        estacion.setPrecioVenta(precioVenta);

        repo.save(estacion);
    }
    
}
