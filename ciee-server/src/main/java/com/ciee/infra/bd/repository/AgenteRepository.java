package com.ciee.infra.bd.repository;

import com.ciee.infra.bd.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {

    Agente findByCodigo(Integer codigo);
}
