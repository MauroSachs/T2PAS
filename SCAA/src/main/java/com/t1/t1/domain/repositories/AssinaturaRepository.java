package com.t1.t1.domain.repositories;

import com.t1.t1.domain.entities.AssinaturaEntity;

import java.util.List;

public interface AssinaturaRepository {

     AssinaturaEntity createAssinatura(AssinaturaEntity assinatura);
     AssinaturaEntity save(AssinaturaEntity assinatura);
     void deleteAssinatura(Long id);
     AssinaturaEntity getAssinatura(Long id);
     AssinaturaEntity findByClienteAndAplicativo(Long clienteId, Long aplicativoId);
     List<AssinaturaEntity> getAssinaturas();
     List<AssinaturaEntity> findAllByCliente(Long clienteId);
     List<AssinaturaEntity> findAllByAplicativo(Long aplicativoId);

}