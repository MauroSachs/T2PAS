package com.example.AssCache.domain.repositories;

import com.example.AssCache.domain.entities.AssinaturaEntity;

import java.util.Optional;

public interface AssinaturaRepository {
    Optional<AssinaturaEntity> findById(Long id);
    void save(AssinaturaEntity assinatura);
}