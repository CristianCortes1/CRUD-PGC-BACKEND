/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.SolicitudResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.SolicitudAbastecimiento;

/**
 *
 * @author cristian-cortes
 */
public class SolicitudMapper {

    public static SolicitudResponseDTO toDTO(SolicitudAbastecimiento s) {
        return SolicitudResponseDTO.builder()
                .id(s.getId())
                .distribuidorNombre(s.getDistribuidor().getNombre())
                .estacionNombre(s.getEstacion().getNombre())
                .cantidad(s.getCantidad())
                .fecha(s.getFecha())
                .estado(s.getEstado())
                .build();
    }
}
