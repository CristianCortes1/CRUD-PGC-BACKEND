package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.model.Price;
import co.edu.unipiloto.CRUD_PGC.service.PriceService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.PriceRepository;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository precioRepository;

    @Override
    public List<Price> buscarCercanos(double latitud, double longitud) {
        return precioRepository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(precio -> distancia(precio, latitud, longitud)))
                .collect(Collectors.toList());
    }

    private double distancia(Price precio, double latitud, double longitud) {
        if (precio.getEstacion() == null
                || precio.getEstacion().getLatitud() == null
                || precio.getEstacion().getLongitud() == null) {
            return Double.MAX_VALUE;
        }
        double dLat = precio.getEstacion().getLatitud() - latitud;
        double dLon = precio.getEstacion().getLongitud() - longitud;
        return Math.sqrt((dLat * dLat) + (dLon * dLon));
    }
}
