package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Inventory;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByEstacionId(Long estacionId);
    Optional<Inventory> findByEstacionIdAndCombustibleId(Long estacionId, Long combustibleId);
}
