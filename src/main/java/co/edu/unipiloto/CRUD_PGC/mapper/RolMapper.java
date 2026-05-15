/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.RolResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Rol;

/**
 *
 * @author cristian-cortes
 */
public class RolMapper {

    public static RolResponseDTO toDTO(Rol rol) {
        return RolResponseDTO.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }

}
