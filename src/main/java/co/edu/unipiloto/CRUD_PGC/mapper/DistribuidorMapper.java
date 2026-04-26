/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.request.DistribuidorRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.DistribuidorResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Distribuidor;
import co.edu.unipiloto.CRUD_PGC.model.EntidadReguladora;

/**
 *
 * @author cristian-cortes
 */
public class DistribuidorMapper {

    public static Distribuidor toEntity(DistribuidorRequestDTO dto, EntidadReguladora entidad) {
        return Distribuidor.builder()
                .nombre(dto.getNombre())
                .ubicacion(dto.getUbicacion())
                .stock(dto.getStock())
                .entidadReguladora(entidad)
                .build();
    }

    public static DistribuidorResponseDTO toDTO(Distribuidor d) {
        return DistribuidorResponseDTO.builder()
                .id(d.getId())
                .nombre(d.getNombre())
                .ubicacion(d.getUbicacion())
                .stock(d.getStock())
                .build();
    }
}
