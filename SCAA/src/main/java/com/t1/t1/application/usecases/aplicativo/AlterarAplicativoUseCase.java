package com.t1.t1.application.usecases.aplicativo;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.application.dtos.AplicativoRequestDTO;
import com.t1.t1.domain.entities.AplicativoEntity;
import com.t1.t1.domain.services.AplicativoService;

public class AlterarAplicativoUseCase {

    final AplicativoService aplicativoService;

    public AlterarAplicativoUseCase(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public AplicativoDTO call(Long id, AplicativoRequestDTO aplicativo) {
        if (aplicativo.nome() == null && aplicativo.custoMensal() == null) {
            throw new IllegalArgumentException("nome and custoMensal cannot both be null");
        }

        AplicativoEntity aplicativoEntity = aplicativoService.getAplicativo(id);

        if (aplicativo.nome() != null) {
            aplicativoEntity.setNome(aplicativo.nome());
        }

        if (aplicativo.custoMensal() != null) {
            aplicativoEntity.setCustoMensal(aplicativo.custoMensal());
        }

        aplicativoEntity = aplicativoService.saveAplicativo(aplicativoEntity);
        return new AplicativoDTO(aplicativoEntity);
    }
}
