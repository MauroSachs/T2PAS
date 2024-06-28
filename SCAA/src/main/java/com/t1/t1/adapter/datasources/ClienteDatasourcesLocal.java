package com.t1.t1.adapter.datasources;

import com.t1.t1.adapter.models.ClienteModel;

import java.util.List;

public interface ClienteDatasourcesLocal {

    ClienteModel createCliente(ClienteModel cliente);

    void deleteCliente(Long id);

    ClienteModel getCliente(Long id);

    List<ClienteModel> getClientes();

    ClienteModel updateCliente(ClienteModel clienteModel);
}
