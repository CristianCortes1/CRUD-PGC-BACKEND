/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.Usuario;
import co.edu.unipiloto.CRUD_PGC.repository.UsuarioRepository;
import co.edu.unipiloto.CRUD_PGC.service.UsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;

    @Override
    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = buscarPorId(id);

        existente.setNombre(usuario.getNombre());
        existente.setEmail(usuario.getEmail());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
