/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.dto.response;

import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import co.edu.unipiloto.CRUD_PGC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cristian-cortes
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementResponseDTO {
    private Long id;
    private String tipoVehiculo;
    private Fuel combustible;
    private double cantidad;
    private Double total;
    private String fecha;
    private User estacion;
    private User usuario;
    private String tipoMovimiento;
}
