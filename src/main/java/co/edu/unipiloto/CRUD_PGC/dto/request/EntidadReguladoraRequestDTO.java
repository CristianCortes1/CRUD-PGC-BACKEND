/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cristian-cortes
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntidadReguladoraRequestDTO {

    private String nombre;
    private String pais;
    private double precioBaseCombustible;
}