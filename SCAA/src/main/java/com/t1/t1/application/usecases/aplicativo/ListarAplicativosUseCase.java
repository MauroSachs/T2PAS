package com.t1.t1.application.usecases.aplicativo;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.domain.services.AplicativoService;

import java.util.List;

public class ListarAplicativosUseCase {

    final AplicativoService aplicativoService;

    public ListarAplicativosUseCase(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public List<AplicativoDTO> call() {
        return aplicativoService.listAplicativos().stream()
                .map(AplicativoDTO::new)
                .toList();
    }


    public AplicativoDTO buscaPorId(Long id) {
        return new AplicativoDTO(aplicativoService.getAplicativo(id));
    }
}
