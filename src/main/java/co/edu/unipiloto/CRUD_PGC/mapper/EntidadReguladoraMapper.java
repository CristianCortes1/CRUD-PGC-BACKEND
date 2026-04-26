/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.request.EntidadReguladoraRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.EntidadReguladoraResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.EntidadReguladora;

/**
 *
 * @author cristian-cortes
 */
public class EntidadReguladoraMapper {

    public static EntidadReguladora toEntity(EntidadReguladoraRequestDTO dto) {
        return EntidadReguladora.builder()
                .nombre(dto.getNombre())
                .pais(dto.getPais())
                .precioBaseCombustible(dto.getPrecioBaseCombustible())
                .build();
    }

    public static EntidadReguladoraResponseDTO toDTO(EntidadReguladora e) {
        return EntidadReguladoraResponseDTO.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .pais(e.getPais())
                .precioBaseCombustible(e.getPrecioBaseCombustible())
                .build();
    }
}
