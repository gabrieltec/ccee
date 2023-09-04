package com.ciee.infra.repositories;

import com.ciee.application.interfaces.ProcessFileInterface;
import com.ciee.domain.entities.Agente;
import com.ciee.infra.bd.AgentesBD;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessFileImpl implements ProcessFileInterface {

    @Autowired
    AgentesBD agentesBD;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveAll(List<Agente> agentes) {
        this.agentesBD.saveAll(this.convertToEntity(agentes));
    }

    @Override
    public Agente getConsolidatedDataByRegion(String region) {
        return null;
    }

    @Override
    public List<Agente> findAll() {
        List<com.ciee.infra.bd.model.Agente> agentesDB = this.agentesBD.findAll();
        return this.convertToDto(agentesDB);
    }

    private List<Agente> convertToDto(List<com.ciee.infra.bd.model.Agente> post) {
        return post.stream().map(entity -> modelMapper.map(entity, Agente.class)).collect(Collectors.toList());
    }

    private List<com.ciee.infra.bd.model.Agente> convertToEntity(List<Agente> post) {
         List<com.ciee.infra.bd.model.Agente> a =  post.stream().map(entity -> modelMapper.map(entity, com.ciee.infra.bd.model.Agente.class)).collect(Collectors.toList());
         a.stream().forEach(b -> b.getRegiao().forEach(c -> c.setAgente(new com.ciee.infra.bd.model.Agente(b.getId(), b.getCodigo(), b.getData(), null))));
        return a;
    }

}
