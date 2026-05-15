package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Subsidy;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidyRepository extends JpaRepository<Subsidy, Long> {
    Optional<Subsidy> findByUsuario_Id(Long id);
}