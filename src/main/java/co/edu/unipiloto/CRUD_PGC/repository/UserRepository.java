package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    List<User> findByRolId(Long rolId);
    
    @Query(value = """
SELECT 
    u.id,
    u.nombre_completo,
    u.direccion,
    u.latitud,
    u.longitud,
    MAX(CASE WHEN c.nombre = 'Gasolina Corriente' THEN p.precio END) AS corriente,
    MAX(CASE WHEN c.nombre = 'Gasolina Extra' THEN p.precio END) AS extra,
    MAX(CASE WHEN c.nombre = 'ACPM(Diésel)' THEN p.precio END) AS diesel,
    MAX(CASE WHEN c.nombre = 'Gas Natural Vehicular' THEN p.precio END) AS gnv
FROM users u
JOIN precios p ON u.id = p.id_estacion
JOIN combustibles c ON p.id_combustible = c.id
WHERE u.rol_id = 1
GROUP BY u.id
LIMIT 5
""", nativeQuery = true)
    List<Object[]> getNearestStations();
}
