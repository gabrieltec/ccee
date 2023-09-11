package com.ciee.infra.repositories;

import com.ciee.application.interfaces.ProcessFileInterface;
import com.ciee.application.services.BaseService;
import com.ciee.domain.entities.Agente;
import com.ciee.infra.bd.AgentesBD;
import com.ciee.infra.bd.model.AgenteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessFileImpl extends BaseService<AgenteEntity, Agente> implements ProcessFileInterface {

    private final AgentesBD agentesBD;

    @Autowired
    public ProcessFileImpl(ModelMapper modelMapper, AgentesBD agentesBD) {
        super(modelMapper);
        this.agentesBD = agentesBD;
    }

    @Override
    public void saveAll(List<Agente> agentes) {
        var agenteList = agentes.stream().map(agente -> this.dtoToEntity(agente, AgenteEntity.class))//map
                .collect(Collectors.toList());

        agenteList.stream().forEach(agenteEntity -> agenteEntity.getRegiao().forEach(regiaoEntity -> regiaoEntity.setAgente(agenteEntity)));
        this.agentesBD.saveAll(agenteList);
    }

    @Override
    public Optional<Agente> getConsolidatedDataByRegion(String region) {
        return null;
    }

    @Override
    public List<Agente> findAll() {
        return this.agentesBD.findAll().stream().map(entity -> this.entityToDto(entity, Agente.class)).collect(Collectors.toList());
    }


}
