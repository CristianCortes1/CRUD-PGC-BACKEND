package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Delivery;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByEstacionIdAndEstado(Long estacionId, String estado);
    List<Delivery> findByDistribuidorIdAndEstado(Long distribuidorId, String estado);
}
