package com.t1.t1.domain.repositories;


import com.t1.t1.domain.entities.ClienteEntity;

import java.util.List;

public interface ClienteRepository {

    public ClienteEntity createCliente(ClienteEntity cliente);
    public ClienteEntity updateCliente(ClienteEntity cliente);
    public void deleteCliente(Long id);
    public ClienteEntity getCliente(Long id);
    public List<ClienteEntity> getClientes();
}