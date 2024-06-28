package com.t1.t1.domain.services;

import com.t1.t1.domain.entities.ClienteEntity;
import com.t1.t1.domain.repositories.ClienteRepository;

import java.util.List;

public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public  ClienteEntity getCliente(Long id) {
        return clienteRepository.getCliente(id);
    }

    public ClienteEntity createCliente(ClienteEntity cliente) {
        return clienteRepository.createCliente(cliente);
    }

    public List<ClienteEntity> listClientes() {
        return clienteRepository.getClientes();
    }

    public ClienteEntity saveCliente(ClienteEntity cliente) {
        return clienteRepository.updateCliente(cliente);
    }
}
