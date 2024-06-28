package com.t1.t1.domain.repositories;

import com.t1.t1.domain.entities.PagamentoEntity;

public interface PagamentoRepository {

    PagamentoEntity save(PagamentoEntity pagamentoEntity);
    PagamentoEntity findById(Long id);
    
}
