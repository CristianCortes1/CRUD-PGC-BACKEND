package co.edu.unipiloto.CRUD_PGC.dto.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private String nombreCompleto;
    private String username;
    private String email;
    private String password;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private LocalDate fechaNacimiento;
    private String genero;
    private String rol;
}
