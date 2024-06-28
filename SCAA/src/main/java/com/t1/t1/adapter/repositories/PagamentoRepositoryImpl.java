package com.t1.t1.adapter.repositories;

import com.t1.t1.adapter.datasources.AssinaturaDatasourcesLocal;
import com.t1.t1.adapter.datasources.PagamentoDatasourcesLocal;
import com.t1.t1.adapter.models.PagamentoModel;
import com.t1.t1.domain.entities.PagamentoEntity;
import com.t1.t1.domain.repositories.PagamentoRepository;

public class PagamentoRepositoryImpl implements PagamentoRepository {

    final PagamentoDatasourcesLocal datasourcesPagamentoLocal;
    final AssinaturaDatasourcesLocal assinaturaDatasourcesLocal;

    public PagamentoRepositoryImpl(PagamentoDatasourcesLocal datasourcesPagamentoLocal, AssinaturaDatasourcesLocal assinaturaDatasourcesLocal) {
        this.datasourcesPagamentoLocal = datasourcesPagamentoLocal;
        this.assinaturaDatasourcesLocal = assinaturaDatasourcesLocal;
    }

    @Override
    public PagamentoEntity save(PagamentoEntity pagamentoEntity) {
        PagamentoModel pagamentoModel = new PagamentoModel(pagamentoEntity);
        pagamentoModel.setAssinatura(assinaturaDatasourcesLocal.getAssinatura(pagamentoEntity.getAssinatura().getId()));
        return datasourcesPagamentoLocal.save(pagamentoModel).toEntity();
    }

    @Override
    public PagamentoEntity findById(Long id) {
        return datasourcesPagamentoLocal.findById(id).toEntity();
    }
    
}
