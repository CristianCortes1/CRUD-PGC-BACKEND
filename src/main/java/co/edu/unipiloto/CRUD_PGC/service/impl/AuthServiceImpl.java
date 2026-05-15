package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.UnauthorizedException;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository usuarioRepository;

    @Override
    public User login(String username, String password) {
        User usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("Credenciales invalidas"));

        if (usuario.getPassword() == null || !usuario.getPassword().equals(password)) {
            throw new UnauthorizedException("Credenciales invalidas");
        }

        return usuario;
    }

    @Override
    public Boolean verifyUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
}
