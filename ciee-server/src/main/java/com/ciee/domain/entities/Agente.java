package com.ciee.domain.entities;

import com.ciee.domain.dto.Metadata;
import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Agente extends Metadata {

    @XmlElement(name = "codigo")
    private int codigo;
    @XmlElement(name = "data")
    private String data;
    @XmlElement(name = "regiao")
    private List<Regiao> regiao;

}