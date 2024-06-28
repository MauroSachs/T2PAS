package com.t1.t1.application.usecases.assinaturas;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.domain.services.AssinaturaService;

import java.util.List;

public class ListarAssinaturasDoClienteUseCase {

    final AssinaturaService assinaturaService;

    public ListarAssinaturasDoClienteUseCase(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> call(Long idCliente) {
        return assinaturaService.findAllByCliente(idCliente).stream()
                .map(assinaturaEntity -> new AssinaturaDTO(assinaturaEntity, new ClienteDTO(assinaturaEntity.getCliente()), new AplicativoDTO(assinaturaEntity.getAplicativo())))
                .toList();
    }
}
