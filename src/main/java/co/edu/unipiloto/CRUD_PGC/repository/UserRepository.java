package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.StationProjection;
import co.edu.unipiloto.CRUD_PGC.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    List<User> findByRolId(Long rolId);
    
    @Query(value = """
        SELECT 
            u.id AS id,
            u.nombre_completo AS nombre,
            u.direccion AS direccion,
            u.latitud AS latitud,
            u.longitud AS longitud,

            MAX(CASE WHEN c.nombre = 'Gasolina Corriente' THEN p.precio END) AS precioCorriente,
            MAX(CASE WHEN c.nombre = 'Gasolina Extra' THEN p.precio END) AS precioExtra,
            MAX(CASE WHEN c.nombre = 'ACPM(Diésel)' THEN p.precio END) AS precioDiesel,
            MAX(CASE WHEN c.nombre = 'Gas Natural Vehicular' THEN p.precio END) AS precioGNV,

            ROUND((6371 * (
                2 * ASIN(
                    SQRT(
                        POWER(SIN((u.latitud - :latUser) * PI() / 180 / 2), 2) +
                        COS(:latUser * PI() / 180) * COS(u.latitud * PI() / 180) *
                        POWER(SIN((u.longitud - :lonUser) * PI() / 180 / 2), 2)
                    )
                )
            ))::numeric, 2) AS distancia

        FROM users u
        JOIN precios p ON u.id = p.owner_id
        JOIN combustibles c ON p.id_combustible = c.id

        WHERE u.rol_id = 1
        GROUP BY u.id, u.nombre_completo, u.direccion, u.latitud, u.longitud
        ORDER BY distancia ASC
        LIMIT 5
    """, nativeQuery = true)
    List<StationProjection> findStationsNearby(
        @Param("latUser") double latUser,
        @Param("lonUser") double lonUser
    );
}
