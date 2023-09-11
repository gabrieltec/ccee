package com.ciee.infra.bd;

import com.ciee.infra.bd.model.AgenteEntity;
import com.ciee.infra.bd.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgentesBD {

    private final AgenteRepository agenteRepository;

    @Autowired
    public AgentesBD(AgenteRepository agenteRepository) {
        this.agenteRepository = agenteRepository;
    }

    public void saveAll(List<AgenteEntity> agentes) {
        this.agenteRepository.saveAll(agentes);
    }

    public AgenteEntity getConsolidatedDataByRegion(String idCountry) {
        return this.agenteRepository.findByCodigo(Integer.parseInt(idCountry));
    }

    public List<AgenteEntity> findAll() {
        return this.agenteRepository.findAll();
    }
}
