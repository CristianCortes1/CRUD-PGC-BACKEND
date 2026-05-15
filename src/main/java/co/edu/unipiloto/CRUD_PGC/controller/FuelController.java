package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.FuelResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.CombustibleMapper;
import co.edu.unipiloto.CRUD_PGC.service.FuelService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fuels")
@RequiredArgsConstructor
public class FuelController {
    private final FuelService combustibleService;

    @GetMapping
    public List<FuelResponseDTO> getAllFuels() {
        return combustibleService.buscarTodos()
                .stream()
                .map(CombustibleMapper::toDTO)
                .collect(Collectors.toList());
    }
}
