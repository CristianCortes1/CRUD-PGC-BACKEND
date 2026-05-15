/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.response.StationResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.StationProjection;

/**
 *
 * @author cristian-cortes
 */
public class StationMapper {

    public static StationResponseDTO toDTO(StationProjection station, double distanciaCarretera) {
        if (station == null) {
            return null;
        }
        return StationResponseDTO.builder()
                .nombre(station.getNombre())
                .direccion(station.getDireccion())
                .latitud(station.getLatitud())
                .longitud(station.getLongitud())
                .distancia(Math.round(distanciaCarretera * 100.0) / 100.0)
                .precioCorriente(station.getPrecioCorriente())
                .precioDiesel(station.getPrecioDiesel())
                .precioExtra(station.getPrecioExtra())
                .precioGNV(station.getPrecioGNV())
                .build();
    }
}
