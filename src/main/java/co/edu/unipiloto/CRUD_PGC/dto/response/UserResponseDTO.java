package co.edu.unipiloto.CRUD_PGC.dto.response;

import co.edu.unipiloto.CRUD_PGC.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long id;
    private String nombreCompleto;
    private String username;
    private String email;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String fechaNacimiento;
    private String genero;
    private Rol rol;
}
