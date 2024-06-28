package com.t1.t1.application.usecases.aplicativo;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.dtos.AssinaturaRequestDTO;
import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.domain.entities.AssinaturaEntity;
import com.t1.t1.domain.services.AplicativoService;
import com.t1.t1.domain.services.AssinaturaService;
import com.t1.t1.domain.services.ClienteService;

public class AssinarAplicativoUseCase {

    final AssinaturaService assinaturaService;
    final AplicativoService aplicativoService;
    final ClienteService clienteService;

    public AssinarAplicativoUseCase(AssinaturaService assinaturaService, AplicativoService aplicativoService, ClienteService clienteService) {
        this.assinaturaService = assinaturaService;
        this.aplicativoService = aplicativoService;
        this.clienteService = clienteService;
    }

    public AssinaturaDTO call(AssinaturaRequestDTO request) {
        if (request.idCliente() == null || request.idAplicativo() == null) {
            throw new IllegalArgumentException("Cliente and Aplicativo cannot be null");
        }

        AssinaturaEntity assinaturaExistente = assinaturaService.findByClienteAndAplicativo(request.idCliente(), request.idAplicativo());
        if (assinaturaExistente != null) {
            throw new IllegalArgumentException("Cliente already has this Aplicativo");
        }

        var cliente = clienteService.getCliente(request.idCliente());
        var aplicativo = aplicativoService.getAplicativo(request.idAplicativo());

        if (cliente == null || aplicativo == null) {
            throw new IllegalArgumentException("Cliente or Aplicativo not found");
        }

        var assinatura = assinaturaService.createAssinatura(cliente, aplicativo);
        return new AssinaturaDTO(assinatura, new ClienteDTO(cliente), new AplicativoDTO(aplicativo));

    }
}
