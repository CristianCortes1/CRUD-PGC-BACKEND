/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.EstacionServicio;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface EstacionService {

    EstacionServicio guardar(EstacionServicio estacion);

    List<EstacionServicio> listar();

    EstacionServicio buscarPorId(Long id);

    EstacionServicio actualizar(Long id, EstacionServicio estacion);

    void eliminar(Long id);

    void asignarPrecio(Long estacionId, double margen);
}
