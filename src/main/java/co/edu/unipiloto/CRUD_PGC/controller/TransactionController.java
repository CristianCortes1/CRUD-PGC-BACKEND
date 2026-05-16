package co.edu.unipiloto.CRUD_PGC.controller;

import co.edu.unipiloto.CRUD_PGC.dto.request.TransactionRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.TransactionResponseDTO;
import co.edu.unipiloto.CRUD_PGC.service.TransactionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponseDTO> getAllTransactions(@RequestParam Long estacionId) {
        return transactionService.getAllTransactions(estacionId);
    }

    @GetMapping("/by-user")
    public List<TransactionResponseDTO> getAllTransactionsByUser(@RequestParam Long userId) {
        return transactionService.getAllTransactionsByUser(userId);
    }

    @GetMapping("/by-user-by-station")
    public List<TransactionResponseDTO> getTransactionsByUserOrderedByStation(@RequestParam Long userId) {
        return transactionService.getTransactionsByUserOrderedByStation(userId);
    }

    @GetMapping("/by-user-by-date")
    public List<TransactionResponseDTO> getTransactionsByUserOrderedByDate(@RequestParam Long userId) {
        return transactionService.getTransactionsByUserOrderedByDate(userId);
    }

    @GetMapping("/validated")
    public List<TransactionResponseDTO> getValidatedTransactions() {
        return transactionService.getValidatedTransactions();
    }

    @PostMapping("/insert")
    public void insertarTransaccion(@RequestBody TransactionRequestDTO dto) {
        transactionService.insertarTransaccion(dto);
    }
}
