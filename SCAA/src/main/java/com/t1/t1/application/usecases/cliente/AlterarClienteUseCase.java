package com.t1.t1.application.usecases.cliente;

import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.application.dtos.ClienteRequestDTO;
import com.t1.t1.domain.entities.ClienteEntity;
import com.t1.t1.domain.services.ClienteService;

public class AlterarClienteUseCase {

    final ClienteService clienteService;

    public AlterarClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteDTO call(Long id, ClienteRequestDTO cliente) {
        if (cliente.nome() == null && cliente.email() == null) {
            throw new IllegalArgumentException("Nome and Email cannot both be null");
        }

        ClienteEntity clienteEntity = clienteService.getCliente(id);

        if (cliente.nome() != null) {
            clienteEntity.setNome(cliente.nome());
        }

        if (cliente.email() != null) {
            clienteEntity.setEmail(cliente.email());
        }

        clienteEntity = clienteService.saveCliente(clienteEntity);
        return new ClienteDTO(clienteEntity);
    }
}
