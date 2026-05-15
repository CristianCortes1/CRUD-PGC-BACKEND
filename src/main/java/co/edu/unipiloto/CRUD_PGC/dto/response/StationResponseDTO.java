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
public class StationResponseDTO {
    private String nombre;
    private String direccion;
    private double latitud;
    private double longitud;
    private double distancia;

    private double precioCorriente;
    private double precioExtra;
    private double precioDiesel;
    private double precioGNV;
}
