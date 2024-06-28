package com.t1.t1.application.usecases.cliente;

import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.application.dtos.ClienteRequestDTO;
import com.t1.t1.domain.entities.ClienteEntity;
import com.t1.t1.domain.services.ClienteService;

public class CadastrarClienteUseCase {

    final ClienteService clienteService;

    public CadastrarClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteDTO call(ClienteRequestDTO cliente) {
        if (cliente.nome() == null || cliente.email() == null) {
            throw new IllegalArgumentException("Nome and Email cannot be null");
        }

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.nome());
        clienteEntity.setEmail(cliente.email());

        clienteEntity = clienteService.createCliente(clienteEntity);
        return new ClienteDTO(clienteEntity);
    }
}
