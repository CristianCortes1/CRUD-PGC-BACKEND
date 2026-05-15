package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.request.UserRequestDTO;
import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.mapper.UserMapper;
import co.edu.unipiloto.CRUD_PGC.model.Rol;
import co.edu.unipiloto.CRUD_PGC.model.User;
import co.edu.unipiloto.CRUD_PGC.repository.RolRepository;
import co.edu.unipiloto.CRUD_PGC.service.UserService;
import co.edu.unipiloto.CRUD_PGC.dto.response.UserResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository usuarioRepository;
    private final RolRepository rolRepository;

    @Override
    public User crear(UserRequestDTO dto) {
        User usuario = UserMapper.toEntity(dto);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UserResponseDTO> getAllDistribuidores() {
        return usuarioRepository.findByRolId(5L).stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getByUsername(String username) {
         User user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        
        return UserMapper.toDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return usuarioRepository.findByRolId(2L).stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
