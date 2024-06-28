package com.t1.t1.adapter.datasources;

import com.t1.t1.adapter.models.PagamentoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPagamentoRepository extends JpaRepository<PagamentoModel, Long> {

}