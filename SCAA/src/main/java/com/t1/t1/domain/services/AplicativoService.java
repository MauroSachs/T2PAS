package com.t1.t1.domain.services;

import com.t1.t1.domain.entities.AplicativoEntity;
import com.t1.t1.domain.repositories.AplicativoRepository;

import java.util.List;

public class AplicativoService {

    final AplicativoRepository aplicativoRepository;

    public AplicativoService(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public  AplicativoEntity getAplicativo(Long id) {
        return aplicativoRepository.getAplicativo(id);
    }

    public AplicativoEntity createAplicativo(AplicativoEntity aplicativo) {
        return aplicativoRepository.createAplicativo(aplicativo);
    }

    public List<AplicativoEntity> listAplicativos() {
        return aplicativoRepository.getAplicativos();
    }

    public AplicativoEntity saveAplicativo(AplicativoEntity aplicativo) {
        return aplicativoRepository.updateAplicativo(aplicativo);
    }
}
