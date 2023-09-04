package com.ciee.application.services;

import com.ciee.application.interfaces.ProcessFileInterface;
import com.ciee.domain.entities.Agente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessFileService {

    @Autowired
    ProcessFileInterface processFileInterface;

    public void saveAll(List<Agente> agentes) {
        this.processFileInterface.saveAll(agentes);
    }

    public Agente getConsolidatedDataByRegion(String region) {
        return this.processFileInterface.getConsolidatedDataByRegion(region);
    }

    public List<Agente> findAll() {
        return this.processFileInterface.findAll();
    }
}
