/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.Usuario;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface UsuarioService {

    Usuario guardar(Usuario usuario);

    List<Usuario> listar();

    Usuario buscarPorId(Long id);

    Usuario actualizar(Long id, Usuario usuario);

    void eliminar(Long id);
}
