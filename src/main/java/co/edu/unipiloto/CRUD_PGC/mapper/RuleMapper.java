/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.mapper;

import co.edu.unipiloto.CRUD_PGC.dto.request.RuleRequestDTO;
import co.edu.unipiloto.CRUD_PGC.dto.response.RuleResponseDTO;
import co.edu.unipiloto.CRUD_PGC.model.Rule;
import co.edu.unipiloto.CRUD_PGC.model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author cristian-cortes
 */
public class RuleMapper {

    public static RuleResponseDTO toDTO(Rule rule) {
        return RuleResponseDTO.builder()
                .id(rule.getId())
                .tipoVehiculo(rule.getTipoVehiculo())
                .precio(rule.getPrecio())
                .adminId(rule.getAdmin().getId())
                .adminUsername(rule.getAdmin().getUsername())
                .fechaFormateada(rule.getFechaFormateada())
                .build();
    }

    public static Rule toEntity(RuleRequestDTO dto, User admin) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = ahora.format(formatter);
        return Rule.builder()
                .tipoVehiculo(dto.getTipoVehiculo())
                .precio(dto.getPrecio())
                .fecha(ahora)
                .fechaFormateada(fechaFormateada)
                .admin(admin)
                .build();
    }
}
