/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.dto.response.StationResponseDTO;
import co.edu.unipiloto.CRUD_PGC.mapper.StationMapper;
import co.edu.unipiloto.CRUD_PGC.model.StationProjection;
import co.edu.unipiloto.CRUD_PGC.repository.UserRepository;
import co.edu.unipiloto.CRUD_PGC.service.OpenRouteService;
import co.edu.unipiloto.CRUD_PGC.service.StationService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService{
    private final UserRepository userRepository;
    private final OpenRouteService openRouteService;

    @Override
    public List<StationResponseDTO> getNearbyStations(double lat, double lon) {
        List<StationProjection> stations = userRepository.findStationsNearby(lat, lon);

        return stations.stream()
                .map(station -> {
                    double distancia = openRouteService.getDrivingDistance(
                            lon, lat,
                            station.getLongitud(), station.getLatitud()
                    );
                    return StationMapper.toDTO(station, distancia);
                })
                .collect(Collectors.toList());
    }
}
