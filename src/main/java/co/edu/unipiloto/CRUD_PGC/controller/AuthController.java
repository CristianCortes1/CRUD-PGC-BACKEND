package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.LoginRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.LoginResponseDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.UserResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.UserMapper;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        User usuario = authService.login(dto.getUsername(), dto.getPassword());
        return UserMapper.toLoginDTO(usuario);
    }
    
    @GetMapping("/verificarUsername/{username}")
    public Boolean getByUsername(@PathVariable String username) {
        return authService.verifyUsername(username);
    }
}
