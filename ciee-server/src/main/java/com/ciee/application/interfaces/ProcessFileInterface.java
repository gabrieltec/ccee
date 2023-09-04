package com.ciee.application.interfaces;

import com.ciee.domain.entities.Agente;

import java.util.List;

public interface ProcessFileInterface {

    void saveAll(List<Agente> agentes);

    Agente getConsolidatedDataByRegion(String region);

    List<Agente> findAll();

}