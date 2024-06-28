package com.t1.t1.adapter.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.t1.t1.adapter.datasources.ClienteDatasourcesLocal;

import com.t1.t1.adapter.models.ClienteModel;
import com.t1.t1.domain.entities.ClienteEntity;
import com.t1.t1.domain.repositories.ClienteRepository;

public class ClienteRepositoryImpl implements ClienteRepository {

    final ClienteDatasourcesLocal datasourcesClienteLocal;

    public ClienteRepositoryImpl(ClienteDatasourcesLocal datasourcesClienteLocal) {

        this.datasourcesClienteLocal = datasourcesClienteLocal;
    }

    @Override
    public ClienteEntity createCliente(ClienteEntity cliente) {
        ClienteModel clienteModel = new ClienteModel(cliente);
        return datasourcesClienteLocal.createCliente(clienteModel).toEntity();
    }

    @Override
    public ClienteEntity updateCliente(ClienteEntity cliente) {
        ClienteModel clienteModel = new ClienteModel(cliente);
        return datasourcesClienteLocal.updateCliente(clienteModel).toEntity();
    }

    @Override
    public void deleteCliente(Long id) {
        datasourcesClienteLocal.deleteCliente(id);
    }

    @Override
    public ClienteEntity getCliente(Long id) {
        return datasourcesClienteLocal.getCliente(id).toEntity();
    }

    @Override
    public List<ClienteEntity> getClientes() {
        return datasourcesClienteLocal.getClientes().stream().map(ClienteModel::toEntity).collect(Collectors.toList());
    }
}