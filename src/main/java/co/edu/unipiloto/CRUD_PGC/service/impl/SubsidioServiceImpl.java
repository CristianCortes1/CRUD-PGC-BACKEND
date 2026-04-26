/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.CRUD_PGC.service.impl;

import co.edu.unipiloto.CRUD_PGC.model.Subsidio;
import co.edu.unipiloto.CRUD_PGC.repository.SubsidioRepository;
import co.edu.unipiloto.CRUD_PGC.service.SubsidioService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian-cortes
 */
@Service
@RequiredArgsConstructor
public class SubsidioServiceImpl implements SubsidioService {

    private final SubsidioRepository subsidioRepo;
    
    @Override
    public double aplicarSubsidio(Long usuarioId, double precioTotal) {

        Optional<Subsidio> subsidioOpt
                = subsidioRepo.findByUsuarioIdAndActivoTrue(usuarioId);

        if (subsidioOpt.isEmpty()) {
            return precioTotal; 
        }

        Subsidio subsidio = subsidioOpt.get();

        double descuento = precioTotal * subsidio.getPorcentaje();

        return precioTotal - descuento;
    }
}
