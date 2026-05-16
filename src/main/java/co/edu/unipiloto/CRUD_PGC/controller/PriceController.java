package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.PriceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @GetMapping("/{id}")
    private List<PriceResponseDTO> getAllPricesByEstacionId(@PathVariable Long id){
        return priceService.getAllPricesByEstacionId(id);
    }
}
