/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.request.UsuarioRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.UsuarioResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Usuario;

/**
 *
 * @author cristian-cortes
 */
public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        return Usuario.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .build();
    }

    public static UsuarioResponseDTO toDTO(Usuario u) {
        return UsuarioResponseDTO.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .build();
    }
}
