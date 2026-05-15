package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.DeliveryRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.DeliveryResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.DeliveryMapper;
import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import co.edu.unipiloto.CRUD_PGC.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PutMapping("/{id}/confirm")
    public DeliveryResponseDTO confirmar(@PathVariable Long id) {
        Delivery entrega = deliveryService.confirmar(id);
        return DeliveryMapper.toDTO(entrega);
    }
    
    @PostMapping()
    public void insertDelivery(@RequestBody DeliveryRequestDTO dto){
        deliveryService.insertDelivery(dto);
    }

    @PutMapping("/{id}/delivered")
    public DeliveryResponseDTO markAsDelivered(@PathVariable Long id, @RequestParam String placa) {
        Delivery entrega = deliveryService.markAsDelivered(id, placa);
        return DeliveryMapper.toDTO(entrega);
    }

    @GetMapping("/by-state")
    public List<DeliveryResponseDTO> getDeliveriesByState(
            @RequestParam Long userId,
            @RequestParam String estado) {
        return deliveryService.getDeliveriesByState(userId, estado);
    }
}
