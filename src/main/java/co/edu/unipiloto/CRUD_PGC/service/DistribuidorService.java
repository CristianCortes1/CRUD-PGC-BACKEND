/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.Distribuidor;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface DistribuidorService {

    Distribuidor guardar(Distribuidor distribuidor);

    List<Distribuidor> listar();

    Distribuidor buscarPorId(Long id);

    Distribuidor actualizar(Long id, Distribuidor distribuidor);

    void eliminar(Long id);
}
