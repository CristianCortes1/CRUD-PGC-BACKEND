/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.dto.response;

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
public class DistribuidorResponseDTO {

    private Long id;
    private String nombre;
    private String ubicacion;
    private double stock;
    private Long entidadReguladoraId;
    private String entidadReguladoraNombre;
}