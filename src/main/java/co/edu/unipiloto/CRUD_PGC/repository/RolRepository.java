package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Rol;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
    @Override
    List<Rol> findAll();
}
