/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;
import co.edu.unipiloto.CRUD_PGC.model.SolicitudAbastecimiento;
import co.edu.unipiloto.CRUD_PGC.model.Usuario;
import co.edu.unipiloto.CRUD_PGC.repository.EstacionServicioRepository;
import co.edu.unipiloto.CRUD_PGC.repository.SolicitudAbastecimientoRepository;
import co.edu.unipiloto.CRUD_PGC.repository.UsuarioRepository;
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
    private final UsuarioRepository usuarioRepo;
    private final EstacionServicioRepository estacionRepo;

    @Override
    public void solicitar(Long usuarioId, Long estacionId, double cantidad) {

        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        EstacionServicio estacion = estacionRepo.findById(estacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));

        SolicitudAbastecimiento solicitud = SolicitudAbastecimiento.builder()
                .usuario(usuario)
                .estacion(estacion)
                .cantidad(cantidad)
                .fecha(LocalDateTime.now())
                .build();

        solicitudRepo.save(solicitud);
    }

    @Override
    public List<SolicitudAbastecimiento> listar() {
        return solicitudRepo.findAll();
    }
}