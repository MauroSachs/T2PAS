package com.t1.t1.adapter.datasources.impl;

import com.t1.t1.adapter.datasources.AplicativoDatasourcesLocal;
import com.t1.t1.adapter.datasources.JpaAplicativoRepository;
import com.t1.t1.adapter.models.AplicativoModel;

import java.util.List;
import java.util.Optional;

public class AplicativoDatasourcesLocalImpl implements AplicativoDatasourcesLocal {

    final JpaAplicativoRepository jpaAplicativoRepository;

    public AplicativoDatasourcesLocalImpl(JpaAplicativoRepository jpaAplicativoRepository) {

        this.jpaAplicativoRepository = jpaAplicativoRepository;
    }

    @Override
    public AplicativoModel createAplicativo(AplicativoModel aplicativo) {
        return jpaAplicativoRepository.save(aplicativo);
    }

    @Override
    public void deleteAplicativo(Long id) {
        jpaAplicativoRepository.deleteById(id);
    }

    @Override
    public AplicativoModel getAplicativo(Long id) {
        Optional<AplicativoModel> aplicativo = jpaAplicativoRepository.findById(id);
        return aplicativo.orElse(null);
    }

    @Override
    public List<AplicativoModel> getAplicativos() {
        return jpaAplicativoRepository.findAll();
    }

    @Override
    public AplicativoModel updateAplicativo(AplicativoModel aplicativoModel) {
        return jpaAplicativoRepository.save(aplicativoModel);
    }

}