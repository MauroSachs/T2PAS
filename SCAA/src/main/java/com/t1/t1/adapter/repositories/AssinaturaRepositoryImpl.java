package com.t1.t1.adapter.repositories;

import com.t1.t1.adapter.datasources.AssinaturaDatasourcesLocal;
import com.t1.t1.adapter.datasources.PagamentoDatasourcesLocal;
import com.t1.t1.adapter.models.AssinaturaModel;
import com.t1.t1.adapter.models.PagamentoModel;
import com.t1.t1.domain.entities.AssinaturaEntity;
import com.t1.t1.domain.repositories.AssinaturaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssinaturaRepositoryImpl implements AssinaturaRepository {

    final AssinaturaDatasourcesLocal datasourcesAssinaturaLocal;
    final PagamentoDatasourcesLocal pagamentoDatasourcesLocal;

    public AssinaturaRepositoryImpl(AssinaturaDatasourcesLocal datasourcesAssinaturaLocal, PagamentoDatasourcesLocal pagamentoDatasourcesLocal) {
        this.datasourcesAssinaturaLocal = datasourcesAssinaturaLocal;
        this.pagamentoDatasourcesLocal = pagamentoDatasourcesLocal;
    }

    @Override
    public AssinaturaEntity createAssinatura(AssinaturaEntity assinatura) {
        AssinaturaModel assinaturaModel = new AssinaturaModel(assinatura);
        return datasourcesAssinaturaLocal.createAssinatura(assinaturaModel).toEntity();
    }

    @Override
    public AssinaturaEntity save(AssinaturaEntity assinatura) {
        AssinaturaModel  assinaturaModel = new AssinaturaModel(assinatura);

        assinatura.getPagamentos().forEach(pagamento -> {
            PagamentoModel pagamentoModel = pagamentoDatasourcesLocal.findById(pagamento.getId());
            if (pagamentoModel != null) {
                assinaturaModel.getPagamentos().add(pagamentoModel);
                pagamentoModel.setAssinatura(assinaturaModel);
            }
        });
        return datasourcesAssinaturaLocal.save(assinaturaModel).toEntity();
    }

    @Override
    public void deleteAssinatura(Long id) {
        datasourcesAssinaturaLocal.deleteAssinatura(id);
    }

    @Override
    public AssinaturaEntity getAssinatura(Long id) {
        AssinaturaModel assinaturaModel = datasourcesAssinaturaLocal.getAssinatura(id);
        AssinaturaEntity assinatura = assinaturaModel.toEntity();
        assinatura.setPagamentos(assinaturaModel.getPagamentos().stream().map(PagamentoModel::toEntity).collect(Collectors.toList()));
        return assinatura;
    }

    @Override
    public List<AssinaturaEntity> getAssinaturas() {
        return datasourcesAssinaturaLocal.getAssinaturas().stream().map(AssinaturaModel::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaEntity> findAllByCliente(Long clienteId) {
        return datasourcesAssinaturaLocal.findAllByAplicativo(clienteId).stream().map(AssinaturaModel::toEntity).collect(Collectors.toList());
    }

    @Override
    public AssinaturaEntity findByClienteAndAplicativo(Long clienteId, Long aplicativoId) {
        Optional<AssinaturaModel> assinaturaModel = datasourcesAssinaturaLocal.findByClienteAndAplicativo(clienteId, aplicativoId);
        return assinaturaModel.map(AssinaturaModel::toEntity).orElse(null);
    }

    @Override
    public List<AssinaturaEntity> findAllByAplicativo(Long aplicativoId) {
        return datasourcesAssinaturaLocal.findAllByAplicativo(aplicativoId).stream().map(AssinaturaModel::toEntity).collect(Collectors.toList());
    }

}