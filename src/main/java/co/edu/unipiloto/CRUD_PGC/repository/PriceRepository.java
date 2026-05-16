package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Price;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByOwnerId(Long ownerId);
    Optional<Price> findByOwnerIdAndCombustibleId(Long ownerId, Long combustibleId);
}
