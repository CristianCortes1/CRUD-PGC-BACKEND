/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.SubsidioRequestDTO;
import co.edu.unipiloto.CRUD_PGC.exception.ResourceNotFoundException;
import co.edu.unipiloto.CRUD_PGC.model.Subsidio;
import co.edu.unipiloto.CRUD_PGC.model.Usuario;
import co.edu.unipiloto.CRUD_PGC.repository.SubsidioRepository;
import co.edu.unipiloto.CRUD_PGC.repository.UsuarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cristian-cortes
 */
@RestController
@RequestMapping("/subsidios")
@RequiredArgsConstructor
public class SubsidioController {

    private final SubsidioRepository repo;
    private final UsuarioRepository usuarioRepo;

    @PostMapping
    public void crear(@RequestBody SubsidioRequestDTO dto) {

        Usuario usuario = usuarioRepo.findById(dto.getUsuarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Subsidio subsidio = Subsidio.builder()
                .porcentaje(dto.getPorcentaje())
                .activo(true)
                .usuario(usuario)
                .build();

        repo.save(subsidio);
    }

    @GetMapping
    public List<Subsidio> listar() {
        return repo.findAll();
    }
}
