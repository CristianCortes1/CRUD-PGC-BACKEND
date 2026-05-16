package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.UpdatePriceRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.PriceResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.PriceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @GetMapping("/owner/{id}")
    private List<PriceResponseDTO> getAllPricesByOwnerId(@PathVariable Long id){
        return priceService.getAllPricesByOwnerId(id);
    }

    @PutMapping("/{id}")
    private PriceResponseDTO updatePrice(@PathVariable Long id, @RequestBody UpdatePriceRequestDTO request){
        return priceService.updatePrice(id, request.getPrecio());
    }
}
