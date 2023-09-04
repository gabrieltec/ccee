package com.ciee.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "agentes")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agentes {

    @XmlAttribute
    private String versao;

    @XmlElement(name = "agente")
    private List<Agente> agente;

}
