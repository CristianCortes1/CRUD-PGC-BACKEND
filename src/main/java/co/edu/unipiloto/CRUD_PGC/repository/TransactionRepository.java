package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByEstacionId(Long estacionId);
    List<Transaction> findByUsuarioIdOrderByFechaAsc(Long usuarioId);
    List<Transaction> findByUsuarioIdOrderByFechaDesc(Long usuarioId);

    @Query("SELECT t FROM Transaction t JOIN FETCH t.estacion e WHERE t.usuario.id = :userId ORDER BY e.nombreCompleto DESC")
    List<Transaction> findByUsuarioIdOrderedByStation(@Param("userId") Long usuarioId);
}
