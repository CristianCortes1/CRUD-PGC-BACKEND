package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.Transaction;

public interface TransactionService {
    Transaction crearTransaction(Long estacionId, Long clienteId, Long combustibleId, String tipoVehiculo, double cantidad);
}
