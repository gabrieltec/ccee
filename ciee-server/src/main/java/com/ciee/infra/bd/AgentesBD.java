package com.ciee.infra.bd;

import com.ciee.infra.bd.model.Agente;
import com.ciee.infra.bd.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgentesBD {

    @Autowired
    AgenteRepository agenteRepository;

    public void saveAll(List<Agente> agentes) {
        this.agenteRepository.saveAll(agentes);
    }

    public Agente getConsolidatedDataByRegion(String idCountry) {
        return this.agenteRepository.findByCodigo(Integer.parseInt(idCountry));
    }

    public List<Agente> findAll() {
        return this.agenteRepository.findAll();
    }
}
