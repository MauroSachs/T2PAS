package com.t1.t1.domain.repositories;


import com.t1.t1.domain.entities.AplicativoEntity;

import java.util.List;

public interface AplicativoRepository {

    public AplicativoEntity createAplicativo(AplicativoEntity aplicativo);
    public AplicativoEntity updateAplicativo(AplicativoEntity aplicativo);
    public void deleteAplicativo(Long id);
    public AplicativoEntity getAplicativo(Long id);
    public List<AplicativoEntity> getAplicativos();
}