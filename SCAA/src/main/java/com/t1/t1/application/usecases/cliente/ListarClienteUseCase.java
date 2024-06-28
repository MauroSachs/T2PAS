package com.t1.t1.application.usecases.cliente;

import com.t1.t1.application.dtos.ClienteDTO;
import com.t1.t1.domain.services.ClienteService;

import java.util.List;

public class ListarClienteUseCase {

    final ClienteService clienteService;

    public ListarClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDTO> call() {
        return clienteService.listClientes().stream()
                .map(ClienteDTO::new)
                .toList();
    }
}
