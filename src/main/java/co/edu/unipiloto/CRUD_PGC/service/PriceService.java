package co.edu.unipiloto.CRUD_PGC.service;

import co.edu.unipiloto.CRUD_PGC.model.Price;
import java.util.List;

public interface PriceService {
    List<Price> buscarCercanos(double latitud, double longitud);
}
