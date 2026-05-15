package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.model.Fuel;
import co.edu.unipiloto.CRUD_PGC.service.FuelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.unipiloto.CRUD_PGC.repository.FuelRepository;

@Service
@RequiredArgsConstructor
public class FuelServiceImpl implements FuelService {
    private final FuelRepository combustibleRepository;

    @Override
    public List<Fuel> buscarTodos() {
        return combustibleRepository.findAll();
    }
}
