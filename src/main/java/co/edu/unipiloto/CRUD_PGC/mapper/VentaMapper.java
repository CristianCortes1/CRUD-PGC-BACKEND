/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.VentaResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.VentaCombustible;

/**
 *
 * @author cristian-cortes
 */
public class VentaMapper {

    public static VentaResponseDTO toDTO(VentaCombustible v) {
        return VentaResponseDTO.builder()
                .id(v.getId())
                .usuarioNombre(v.getUsuario().getNombre())
                .estacionNombre(v.getEstacion().getNombre())
                .cantidad(v.getCantidad())
                .precioTotal(v.getPrecioTotal())
                .fecha(v.getFecha())
                .build();
    }
}