package com.t1.t1.adapter.datasources;


import com.t1.t1.adapter.models.AplicativoModel;

import java.util.List;

public interface AplicativoDatasourcesLocal {

    AplicativoModel createAplicativo(AplicativoModel aplicativo);

    void deleteAplicativo(Long id);

    AplicativoModel getAplicativo(Long id);

    List<AplicativoModel> getAplicativos();

    AplicativoModel updateAplicativo(AplicativoModel aplicativoModel);
}
