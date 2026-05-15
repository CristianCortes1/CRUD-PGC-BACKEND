package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.request.UserRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.UserResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Rol;
import co.edu.unipiloto.CRUD_PGC.model.User;
import java.time.LocalDate;

public class UserMapper {
    public static User toEntity(UserRequestDTO dto) {
        return User.builder()
                .nombreCompleto(dto.getNombreCompleto())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .direccion(dto.getDireccion())
                .latitud(dto.getLatitud())
                .longitud(dto.getLongitud())
                .fechaNacimiento(dto.getFechaNacimiento())
                .genero(dto.getGenero())
                .rol(dto.getRol())
                .build();
    }

    public static UserResponseDTO toDTO(User usuario) {
        return UserResponseDTO.builder()
                .id(usuario.getId())
                .nombreCompleto(usuario.getNombreCompleto())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .direccion(usuario.getDireccion())
                .latitud(usuario.getLatitud())
                .longitud(usuario.getLongitud())
                .fechaNacimiento(usuario.getFechaNacimiento() == null ? null : usuario.getFechaNacimiento().toString())
                .genero(usuario.getGenero())
                .rol(usuario.getRol())
                .build();
    }

    private static LocalDate parseFecha(String fecha) {
        if (fecha == null || fecha.isBlank()) {
            return null;
        }
        return LocalDate.parse(fecha);
    }
}
