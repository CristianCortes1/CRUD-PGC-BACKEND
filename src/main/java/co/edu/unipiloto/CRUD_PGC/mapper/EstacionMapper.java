/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.request.EstacionRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.EstacionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Distribuidor;
import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;

/**
 *
 * @author cristian-cortes
 */
public class EstacionMapper {

    public static EstacionServicio toEntity(EstacionRequestDTO dto, Distribuidor distribuidor) {
        return EstacionServicio.builder()
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .distribuidor(distribuidor)
                .build();
    }

    public static EstacionResponseDTO toDTO(EstacionServicio e) {
        return EstacionResponseDTO.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .direccion(e.getDireccion())
                .stock(e.getStock())
                .margenGanancia(e.getMargenGanancia())
                .precioVenta(e.getPrecioVenta())
                .distribuidorId(e.getDistribuidor() != null ? e.getDistribuidor().getId() : null)
                .distribuidorNombre(e.getDistribuidor() != null ? e.getDistribuidor().getNombre() : null)
                .build();
    }
}