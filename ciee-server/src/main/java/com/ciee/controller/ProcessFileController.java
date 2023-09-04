package com.ciee.controller;

import com.ciee.application.services.ProcessFileService;
import com.ciee.domain.entities.Agente;
import com.ciee.domain.entities.Agentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/agente")
public class ProcessFileController {

    @Autowired
    ProcessFileService processFileService;


    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            try {
                List<Agente> processedData = processXML(file.getBytes());
                processFileService.saveAll(processedData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/consolidated/{region}")
    public Agente getConsolidatedData(@PathVariable String region) {
        return processFileService.getConsolidatedDataByRegion(region);
    }

    @GetMapping("")
    public List<Agente> findAll() {
        return processFileService.findAll();
    }

    private List<Agente> processXML(byte[] xmlData) throws JAXBException {
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