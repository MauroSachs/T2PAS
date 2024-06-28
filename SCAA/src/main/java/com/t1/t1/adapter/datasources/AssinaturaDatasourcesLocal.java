package com.t1.t1.adapter.datasources;

import com.t1.t1.adapter.models.AssinaturaModel;

import java.util.List;
import java.util.Optional;

public interface AssinaturaDatasourcesLocal {

    AssinaturaModel createAssinatura(AssinaturaModel assinatura);
    void deleteAssinatura(Long id);
    AssinaturaModel getAssinatura(Long id);
    AssinaturaModel save(AssinaturaModel assinatura);
    List<AssinaturaModel> getAssinaturas();
    List<AssinaturaModel> findAllByCliente(Long clienteId);
    List<AssinaturaModel> findAllByAplicativo(Long aplicativoId);
    Optional<AssinaturaModel> findByClienteAndAplicativo(Long clienteId, Long aplicativoId);
}
