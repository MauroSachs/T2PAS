package com.t1.t1.adapter.datasources;

import com.t1.t1.adapter.models.PagamentoModel;

public interface PagamentoDatasourcesLocal {
    PagamentoModel save(PagamentoModel pagamentoModel);
    PagamentoModel findById(Long id);
}
