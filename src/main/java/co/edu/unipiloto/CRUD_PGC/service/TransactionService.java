package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.dto.request.TransactionRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.TransactionResponseDTO;
import java.util.List;

public interface TransactionService {

    void insertarTransaccion(TransactionRequestDTO dto);

    List<TransactionResponseDTO> getAllTransactions(Long estacionId);

    List<TransactionResponseDTO> getAllTransactionsByUser(Long usuarioId);

    List<TransactionResponseDTO> getTransactionsByUserOrderedByStation(Long usuarioId);

    List<TransactionResponseDTO> getTransactionsByUserOrderedByDate(Long usuarioId);

    List<TransactionResponseDTO> getValidatedTransactions();
}
