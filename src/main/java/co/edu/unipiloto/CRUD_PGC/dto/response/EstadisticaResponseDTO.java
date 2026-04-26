/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author cristian-cortes
 */
@Data
@Builder
public class EstadisticaResponseDTO {

    private long totalVentas;
    private double totalIngresos;
    private double promedioVenta;
}
