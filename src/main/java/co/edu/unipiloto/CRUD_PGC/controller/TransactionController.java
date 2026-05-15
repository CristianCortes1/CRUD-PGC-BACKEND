package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.TransactionRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.TransactionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.TransaccionMapper;
import co.edu.unipiloto.CRUD_PGC.model.Transaction;
import co.edu.unipiloto.CRUD_PGC.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponseDTO crear(@RequestBody TransactionRequestDTO dto) {
        Transaction transaccion = transactionService.crearTransaction(
                dto.getEstacionId(),
                dto.getClienteId(),
                dto.getCombustibleId(),
                dto.getTipoVehiculo(),
                dto.getCantidad()
        );

        return TransaccionMapper.toDTO(transaccion);
    }
}
