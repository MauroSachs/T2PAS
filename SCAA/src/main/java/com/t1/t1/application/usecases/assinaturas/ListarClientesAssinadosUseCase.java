package com.t1.t1.application.usecases.assinaturas;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.domain.services.AssinaturaService;

import java.util.List;

public class ListarClientesAssinadosUseCase {

    final AssinaturaService assinaturaService;

    public ListarClientesAssinadosUseCase(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> call(Long idAplicativo) {
        return assinaturaService.findAllByAplicativo(idAplicativo).stream()
                .map(assinaturaEntity -> new AssinaturaDTO(assinaturaEntity, new ClienteDTO(assinaturaEntity.getCliente()), new AplicativoDTO(assinaturaEntity.getAplicativo())))
                .toList();
    }
}
