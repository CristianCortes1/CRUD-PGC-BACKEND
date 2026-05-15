package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.PrecioMapper;
import co.edu.unipiloto.CRUD_PGC.service.PriceService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @GetMapping("/nearby")
    public List<PriceResponseDTO> listarCercanos(@RequestParam("lat") double latitud,
                                                  @RequestParam("long") double longitud) {
        return priceService.buscarCercanos(latitud, longitud)
                .stream()
                .map(PrecioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
