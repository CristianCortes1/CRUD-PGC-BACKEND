/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.response.EstadisticaResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.VentaCombustible;
import co.edu.unipiloto.CRUD_PGC.repository.VentaCombustibleRepository;
import co.edu.unipiloto.CRUD_PGC.service.EstadisticaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class EstadisticaServiceImpl implements EstadisticaService {
    
    private final VentaCombustibleRepository ventaRepo;

    @Override
    public EstadisticaResponseDTO obtenerEstadisticas() {

        List<VentaCombustible> ventas = ventaRepo.findAll();

        long totalVentas = ventas.size();

        double totalIngresos = ventas.stream()
                .mapToDouble(VentaCombustible::getPrecioTotal)
                .sum();

        double promedio = totalVentas > 0
                ? totalIngresos / totalVentas
                : 0;

        return EstadisticaResponseDTO.builder()
                .totalVentas(totalVentas)
                .totalIngresos(totalIngresos)
                .promedioVenta(promedio)
                .build();
    }
}
