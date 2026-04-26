/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.VentaCombustible;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface VentaService {

    void vender(Long usuarioId, Long estacionId, double cantidad);

    List<VentaCombustible> listar();

    VentaCombustible buscarPorId(Long id);
}
