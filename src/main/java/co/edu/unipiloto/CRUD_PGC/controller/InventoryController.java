package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.InventoryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.InventarioMapper;
import co.edu.unipiloto.CRUD_PGC.service.InventoryService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/station/{id}")
    public List<InventoryResponseDTO> listarPorEstacion(@PathVariable Long id) {
        return inventoryService.buscarPorEstacion(id)
                .stream()
                .map(InventarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
