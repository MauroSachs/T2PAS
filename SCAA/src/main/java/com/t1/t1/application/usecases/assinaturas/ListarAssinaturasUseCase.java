package com.t1.t1.application.usecases.assinaturas;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.dtos.AssinaturaTipoRequestDTO;
import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.domain.entities.AssinaturaEntity;
import com.t1.t1.domain.services.AssinaturaService;

import java.util.List;

public class ListarAssinaturasUseCase {

    final AssinaturaService assinaturaService;

    public ListarAssinaturasUseCase(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> call(AssinaturaTipoRequestDTO tipo) {
        List<AssinaturaEntity> assinaturas;

        if (tipo == AssinaturaTipoRequestDTO.ATIVAS) {
            assinaturas = assinaturaService.listAssinaturasAtivas();
        }
        else if (tipo == AssinaturaTipoRequestDTO.CANCELADAS) {
            assinaturas = assinaturaService.listAssinaturasCanceladas();
        }
        else {
            assinaturas = assinaturaService.listAssinaturas();
        }

        return assinaturas.stream()
                .map(assinaturaEntity -> new AssinaturaDTO(assinaturaEntity, new ClienteDTO(assinaturaEntity.getCliente()), new AplicativoDTO(assinaturaEntity.getAplicativo())))
                .toList();
    }
}
