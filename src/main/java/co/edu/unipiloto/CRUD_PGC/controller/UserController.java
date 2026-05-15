package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.UserRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.UserResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.UserMapper;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDTO crear(@RequestBody UserRequestDTO dto) {
        User usuario = userService.crear(dto);
        return UserMapper.toDTO(usuario);
    }

    @GetMapping("/distributors")
    public List<UserResponseDTO> getAllDistribuidores() {
        return userService.getAllDistribuidores();
    }
    
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{username}")
    public UserResponseDTO getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }
}
