/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.exception.SolicitudCompletadaException;
import co.edu.unipiloto.CRUD_PGC.model.Distribuidor;
import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;
import co.edu.unipiloto.CRUD_PGC.model.SolicitudAbastecimiento;
import co.edu.unipiloto.CRUD_PGC.repository.DistribuidorRepository;
import co.edu.unipiloto.CRUD_PGC.repository.EstacionServicioRepository;
import co.edu.unipiloto.CRUD_PGC.repository.SolicitudAbastecimientoRepository;
import co.edu.unipiloto.CRUD_PGC.service.SolicitudService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudAbastecimientoRepository solicitudRepo;
    private final DistribuidorRepository distribuidorRepo;
    private final EstacionServicioRepository estacionRepo;

    @Override
    public void solicitar(Long estacionId, Long distribuidorId, double cantidad) {

        EstacionServicio estacion = estacionRepo.findById(estacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));

        Distribuidor distribuidor = distribuidorRepo.findById(distribuidorId)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor no encontrado"));

        SolicitudAbastecimiento solicitud = SolicitudAbastecimiento.builder()
                .distribuidor(distribuidor)
                .estacion(estacion)
                .cantidad(cantidad)
                .fecha(LocalDateTime.now())
                .estado("ACTIVO")
                .build();

        solicitudRepo.save(solicitud);
    }

    @Override
    public List<SolicitudAbastecimiento> listar() {
        return solicitudRepo.findAll();
    }

    @Override
    public SolicitudAbastecimiento buscarPorId(Long id) {
        return solicitudRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud no encontrada"));
    }

    @Override
    public SolicitudAbastecimiento actualizar(Long id, Long estacionId, Long distribuidorId, double cantidad) {
        SolicitudAbastecimiento existente = buscarPorId(id);

        if ("COMPLETADO".equals(existente.getEstado())) {
            throw new SolicitudCompletadaException("La solicitud ya ha sido completada y no se puede actualizar");
        }

        EstacionServicio estacion = estacionRepo.findById(estacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));

        Distribuidor distribuidor = distribuidorRepo.findById(distribuidorId)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor no encontrado"));

        existente.setDistribuidor(distribuidor);
        existente.setEstacion(estacion);
        existente.setCantidad(cantidad);
        return solicitudRepo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        SolicitudAbastecimiento existente = buscarPorId(id);

        if ("COMPLETADO".equals(existente.getEstado())) {
            throw new SolicitudCompletadaException("La solicitud ya ha sido completada y no se puede eliminar");
        }

        solicitudRepo.delete(existente);
    }
}