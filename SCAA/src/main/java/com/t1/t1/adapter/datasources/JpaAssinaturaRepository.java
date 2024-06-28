package com.t1.t1.adapter.datasources;

import com.t1.t1.adapter.models.AssinaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaAssinaturaRepository extends JpaRepository<AssinaturaModel, Long> {

    List<AssinaturaModel> findAllByCliente_Id(Long clienteId);
    List<AssinaturaModel> findAllByAplicativo_Id(Long aplicativoId);
    Optional<AssinaturaModel> findByCliente_IdAndAplicativo_Id(Long clienteId, Long aplicativoId);
}