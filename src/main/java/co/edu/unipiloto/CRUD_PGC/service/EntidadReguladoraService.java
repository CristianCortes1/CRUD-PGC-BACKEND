/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.EntidadReguladora;
import java.util.List;

/**
 *
 * @author cristian-cortes
 */
public interface EntidadReguladoraService {

    EntidadReguladora guardar(EntidadReguladora entidad);

    List<EntidadReguladora> listar();

    EntidadReguladora buscarPorId(Long id);

    EntidadReguladora actualizar(Long id, EntidadReguladora entidad);

    void eliminar(Long id);
    
    void aplicarDecreto(Long id, double nuevoPrecio);
}
