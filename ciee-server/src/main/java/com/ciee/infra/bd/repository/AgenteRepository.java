package com.ciee.infra.bd.repository;

import com.ciee.infra.bd.model.AgenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenteRepository extends JpaRepository<AgenteEntity, Long> {

    AgenteEntity findByCodigo(Integer codigo);
}
