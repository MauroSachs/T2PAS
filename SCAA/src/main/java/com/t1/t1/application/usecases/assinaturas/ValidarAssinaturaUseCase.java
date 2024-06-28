package com.t1.t1.application.usecases.assinaturas;

import com.t1.t1.domain.services.AssinaturaService;

public class ValidarAssinaturaUseCase {

    final AssinaturaService assinaturaService;

    public ValidarAssinaturaUseCase(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public Boolean call(Long idAssinatura) {
        return assinaturaService.isValid(idAssinatura);
    }
}
