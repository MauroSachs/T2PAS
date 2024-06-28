package com.t1.t1.adapter.datasources.impl;

import com.t1.t1.adapter.datasources.ClienteDatasourcesLocal;
import com.t1.t1.adapter.datasources.JpaClienteRepository;
import com.t1.t1.adapter.models.ClienteModel;

import java.util.List;
import java.util.Optional;

public class ClienteDatasourcesLocalImpl implements ClienteDatasourcesLocal {

    final JpaClienteRepository jpaClienteRepository;

    public ClienteDatasourcesLocalImpl(JpaClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }

    @Override
    public ClienteModel createCliente(ClienteModel cliente) {
        return jpaClienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        jpaClienteRepository.deleteById(id);
    }

    @Override
    public ClienteModel getCliente(Long id) {
        Optional<ClienteModel> cliente = jpaClienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public List<ClienteModel> getClientes() {
        return jpaClienteRepository.findAll();
    }

    @Override
    public ClienteModel updateCliente(ClienteModel clienteModel) {
        return jpaClienteRepository.save(clienteModel);
    }

}
