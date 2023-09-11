package com.ciee.domain.entities;

import com.ciee.domain.dto.Metadata;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "regiao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Regiao extends Metadata {

    @XmlElementWrapper(name = "geracao")
    @XmlElement(name = "valor")
    private List<Double> geracao;

    @XmlElementWrapper(name = "compra")
    @XmlElement(name = "valor")
    private List<Double> compra;

    @XmlElementWrapper(name = "precoMedio")
    @XmlElement(name = "valor")
    private List<Double> precoMedio;

    @XmlAttribute(name = "sigla")
    private String regiaoSigla;

}
