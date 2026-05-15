/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.response.RolResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.RolMapper;
import co.edu.unipiloto.CRUD_PGC.repository.RolRepository;
import co.edu.unipiloto.CRUD_PGC.service.RolService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public List<RolResponseDTO> getAllRoles() {
        return rolRepository.findAll().stream()
                .map(RolMapper::toDTO)
                .collect(Collectors.toList());
    }

}
