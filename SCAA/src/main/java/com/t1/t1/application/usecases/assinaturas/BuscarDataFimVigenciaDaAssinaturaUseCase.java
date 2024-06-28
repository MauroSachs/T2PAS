package com.t1.t1.application.usecases.assinaturas;

import com.t1.t1.domain.entities.AssinaturaEntity;
import com.t1.t1.domain.services.AssinaturaService;

import java.time.LocalDate;

public class BuscarDataFimVigenciaDaAssinaturaUseCase {

    final AssinaturaService assinaturaService;

    public BuscarDataFimVigenciaDaAssinaturaUseCase(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public LocalDate call(Long idAssinatura) {
        AssinaturaEntity assinatura = assinaturaService.getAssinatura(idAssinatura);

        if (assinatura == null) {
            return null;
        }

        return assinatura.getFimVigencia();
    }

}
