/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.Subsidio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cristian-cortes
 */
public interface SubsidioRepository extends JpaRepository<Subsidio, Long> {

    Optional<Subsidio> findByUsuarioIdAndActivoTrue(Long usuarioId);

}
