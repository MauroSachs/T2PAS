package com.example.AssCache.adapter.repositories;

import com.example.AssCache.domain.entities.AssinaturaEntity;
import com.example.AssCache.domain.repositories.AssinaturaRepository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AssinaturaRepositoryImpl implements AssinaturaRepository {

    private final Map<Long, AssinaturaEntity> cache = new HashMap<>();

    @Override
    public void save(AssinaturaEntity assinatura) {
        cache.put(assinatura.getId(), assinatura);
    }

    @Override
    public Optional<AssinaturaEntity> findById(Long id) {
        return Optional.ofNullable(cache.get(id));
    }
}