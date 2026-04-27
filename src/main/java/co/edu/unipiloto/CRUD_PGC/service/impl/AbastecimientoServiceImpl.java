/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.exception.StockInsuficienteException;
import co.edu.unipiloto.CRUD_PGC.model.Abastecimiento;
import co.edu.unipiloto.CRUD_PGC.model.Distribuidor;
import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;
import co.edu.unipiloto.CRUD_PGC.model.SolicitudAbastecimiento;
import co.edu.unipiloto.CRUD_PGC.repository.AbastecimientoRepository;
import co.edu.unipiloto.CRUD_PGC.repository.DistribuidorRepository;
import co.edu.unipiloto.CRUD_PGC.repository.EstacionServicioRepository;
import co.edu.unipiloto.CRUD_PGC.repository.SolicitudAbastecimientoRepository;
import co.edu.unipiloto.CRUD_PGC.service.AbastecimientoService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class AbastecimientoServiceImpl implements AbastecimientoService {

    private final DistribuidorRepository distribuidorRepo;
    private final EstacionServicioRepository estacionRepo;
    private final AbastecimientoRepository abastecimientoRepo;
    private final SolicitudAbastecimientoRepository solicitudRepo;

    @Override
    public void abastecer(Long solicitudId) {

        SolicitudAbastecimiento solicitud = solicitudRepo.findById(solicitudId)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud no encontrada"));

        Distribuidor distribuidor = solicitud.getDistribuidor();
        EstacionServicio estacion = solicitud.getEstacion();
        double cantidad = solicitud.getCantidad();

        if (distribuidor.getStock() < cantidad) {
            throw new StockInsuficienteException("Stock insuficiente en distribuidor");
        }

        if ("COMPLETADO".equals(solicitud.getEstado())) {
            throw new RuntimeException("La solicitud ya ha sido completada");
        }

        solicitud.setEstado("COMPLETADO");

        distribuidor.setStock(distribuidor.getStock() - cantidad);
        estacion.setStock(estacion.getStock() + cantidad);

        distribuidorRepo.save(distribuidor);
        estacionRepo.save(estacion);
        solicitudRepo.save(solicitud);

        Abastecimiento ab = Abastecimiento.builder()
                .cantidad(cantidad)
                .fecha(LocalDateTime.now())
                .distribuidor(distribuidor)
                .estacion(estacion)
                .solicitud(solicitud)
                .build();

        abastecimientoRepo.save(ab);
    }
}
