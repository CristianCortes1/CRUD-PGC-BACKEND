/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.SolicitudAbastecimiento;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface SolicitudService {

    void solicitar(Long usuarioId, Long estacionId, double cantidad);

    List<SolicitudAbastecimiento> listar();
}
