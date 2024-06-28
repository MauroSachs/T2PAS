package com.t1.t1.adapter.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.t1.t1.adapter.datasources.AplicativoDatasourcesLocal;

import com.t1.t1.adapter.models.AplicativoModel;
import com.t1.t1.domain.entities.AplicativoEntity;
import com.t1.t1.domain.repositories.AplicativoRepository;

public class AplicativoRepositoryImpl implements AplicativoRepository {

    final AplicativoDatasourcesLocal datasourcesAlbumLocal;

    public AplicativoRepositoryImpl(AplicativoDatasourcesLocal datasourcesAlbumLocal) {

        this.datasourcesAlbumLocal = datasourcesAlbumLocal;
    }

    @Override
    public AplicativoEntity createAplicativo(AplicativoEntity aplicativo) {
        AplicativoModel aplicativoModel = new AplicativoModel(aplicativo);
        return datasourcesAlbumLocal.createAplicativo(aplicativoModel).toEntity();
    }

    @Override
    public AplicativoEntity updateAplicativo(AplicativoEntity aplicativo) {
        AplicativoModel aplicativoModel = new AplicativoModel(aplicativo);
        return datasourcesAlbumLocal.updateAplicativo(aplicativoModel).toEntity();
    }

    @Override
    public void deleteAplicativo(Long id) {
        datasourcesAlbumLocal.deleteAplicativo(id);
    }

    @Override
    public AplicativoEntity getAplicativo(Long id) {
        return datasourcesAlbumLocal.getAplicativo(id).toEntity();
    }

    @Override
    public List<AplicativoEntity> getAplicativos() {
        return datasourcesAlbumLocal.getAplicativos().stream().map(AplicativoModel::toEntity).collect(Collectors.toList());
    }
}