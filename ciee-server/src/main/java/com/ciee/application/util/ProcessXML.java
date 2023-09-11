package com.ciee.application.util;

import com.ciee.domain.entities.Agente;
import com.ciee.domain.entities.Agentes;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ProcessXML {

    public List<Agente> xmlToDto(byte[] xmlData) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Agentes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            String xmlString = new String(xmlData, StandardCharsets.UTF_8);

            StringReader reader = new StringReader(xmlString);
            Agentes agentes = (Agentes) unmarshaller.unmarshal(reader);

            List<Agente> agenteList = agentes.getAgente();

            return agenteList;

        } catch (Exception e) {
            e.printStackTrace();
            throw new JAXBException("Erro ao processar o XML: " + e.getMessage());
        }
    }
}
