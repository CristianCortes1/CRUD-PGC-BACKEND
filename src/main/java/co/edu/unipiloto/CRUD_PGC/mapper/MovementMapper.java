/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.MovementResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Movement;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cristian-cortes
 */
public class MovementMapper {

    public static MovementResponseDTO toDTO(Movement movement) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return MovementResponseDTO.builder()
                .id(movement.getId())
                .tipoVehiculo(movement.getTipoVehiculo())
                .combustible(movement.getCombustible())
                .cantidad(movement.getCantidad())
                .total(movement.getTotal())
                .fecha(movement.getFecha().format(formatter))
                .estacion(movement.getEstacion())
                .usuario(movement.getUsuario())
                .tipoMovimiento(movement.getTipoMovimiento())
                .build();
    }
}
