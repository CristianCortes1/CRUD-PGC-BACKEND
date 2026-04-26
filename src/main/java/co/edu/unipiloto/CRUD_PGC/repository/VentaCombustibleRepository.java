/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.repository;

import co.edu.unipiloto.CRUD_PGC.model.VentaCombustible;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cristian-cortes
 */
public interface VentaCombustibleRepository extends JpaRepository<VentaCombustible, Long> {
    
}
