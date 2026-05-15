package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.request.UserRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.UserResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.User;

import java.util.List;

public interface UserService {
    User crear(UserRequestDTO dto);
    List<UserResponseDTO> getAllDistribuidores();
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getByUsername(String username);
}
