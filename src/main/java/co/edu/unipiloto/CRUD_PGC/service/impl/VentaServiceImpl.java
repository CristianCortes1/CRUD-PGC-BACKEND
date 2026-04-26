/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;
import co.edu.unipiloto.CRUD_PGC.model.Usuario;
import co.edu.unipiloto.CRUD_PGC.model.VentaCombustible;
import co.edu.unipiloto.CRUD_PGC.service.VentaService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.VentaCombustibleRepository;
import co.edu.unipiloto.CRUD_PGC.repository.UsuarioRepository;
import co.edu.unipiloto.CRUD_PGC.repository.EstacionServicioRepository;
import co.edu.unipiloto.CRUD_PGC.service.SubsidioService;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final VentaCombustibleRepository ventaRepo;
    private final UsuarioRepository usuarioRepo;
    private final EstacionServicioRepository estacionRepo;
    //private final SubsidioRepository subsidioRepo;
    private final SubsidioService subsidioService;

    @Override
    public void vender(Long usuarioId, Long estacionId, double cantidad) {

        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        EstacionServicio estacion = estacionRepo.findById(estacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada"));

        if (estacion.getStock() < cantidad) {
            throw new RuntimeException("No hay suficiente combustible en la estación");
        }

        if (estacion.getPrecioVenta() <= 0) {
            throw new RuntimeException("La estación no tiene precio de venta definido");
        }

        double precioUnitario = estacion.getPrecioVenta();
        double total = precioUnitario * cantidad;
        total = subsidioService.aplicarSubsidio(usuarioId, total);

        estacion.setStock(estacion.getStock() - cantidad);
        estacionRepo.save(estacion);

        VentaCombustible venta = VentaCombustible.builder()
                .usuario(usuario)
                .estacion(estacion)
                .cantidad(cantidad)
                .precioUnitario(precioUnitario)
                .precioTotal(total)
                .fecha(LocalDateTime.now())
                .build();

        ventaRepo.save(venta);
    }

    @Override
    public List<VentaCombustible> listar() {
        return ventaRepo.findAll();
    }

    @Override
    public VentaCombustible buscarPorId(Long id) {
        return ventaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venta no encontrada"));
    }
}
