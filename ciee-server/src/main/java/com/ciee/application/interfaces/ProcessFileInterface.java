package com.ciee.application.interfaces;

import com.ciee.domain.entities.Agente;

import java.util.List;
import java.util.Optional;

public interface ProcessFileInterface {

    void saveAll(List<Agente> agentes);

    Optional<Agente> getConsolidatedDataByRegion(String region);

    List<Agente> findAll();

}