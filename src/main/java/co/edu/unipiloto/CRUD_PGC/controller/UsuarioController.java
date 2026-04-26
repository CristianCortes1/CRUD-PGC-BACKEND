package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.UsuarioRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.UsuarioResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.UsuarioMapper;
import co.edu.unipiloto.CRUD_PGC.model.Usuario;
import co.edu.unipiloto.CRUD_PGC.service.UsuarioService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public UsuarioResponseDTO crear(@RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        return UsuarioMapper.toDTO(service.guardar(usuario));
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO obtener(@PathVariable Long id) {
        return UsuarioMapper.toDTO(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO actualizar(@PathVariable Long id,
                                         @RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuario.setId(id);
        return UsuarioMapper.toDTO(service.actualizar(id, usuario));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
