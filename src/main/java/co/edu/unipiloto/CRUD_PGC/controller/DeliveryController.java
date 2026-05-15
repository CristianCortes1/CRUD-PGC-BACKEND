package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.response.DeliveryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.EntregaMapper;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import co.edu.unipiloto.CRUD_PGC.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PutMapping("/{id}/confirm")
    public DeliveryResponseDTO confirmar(@PathVariable Long id) {
        Delivery entrega = deliveryService.confirmar(id);
        return EntregaMapper.toDTO(entrega);
    }
}
