package com.t1.t1.application.usecases.aplicativo;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.domain.entities.AplicativoEntity;
import com.t1.t1.domain.services.AplicativoService;

public class AtualizarCustoUseCase {
    final AplicativoService aplicativoService;

    public AtualizarCustoUseCase(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }


    public AplicativoDTO call(Long id, Double novoCusto) {
        if (novoCusto == null) {
            throw new IllegalArgumentException("custoMensal cannot be null");
        }

        AplicativoEntity aplicativoEntity = aplicativoService.getAplicativo(id);
        aplicativoEntity.setCustoMensal(novoCusto);
        aplicativoEntity = aplicativoService.saveAplicativo(aplicativoEntity);
        return new AplicativoDTO(aplicativoEntity);
    }
}
