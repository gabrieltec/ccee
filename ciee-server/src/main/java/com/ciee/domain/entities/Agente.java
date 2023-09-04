package com.ciee.domain.entities;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Agente {

    @XmlElement(name = "codigo")
    private int codigo;
    @XmlElement(name = "data")
    private String data;
    @XmlElement(name = "regiao")
    private List<Regiao> regiao;

}