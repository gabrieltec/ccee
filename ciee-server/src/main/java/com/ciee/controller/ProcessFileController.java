package com.ciee.controller;

import com.ciee.application.services.ProcessFileService;
import com.ciee.application.util.ProcessXML;
import com.ciee.domain.entities.Agente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/v1/agente")
public class ProcessFileController {

    private final ProcessFileService processFileService;
    private final ProcessXML processXML;

    @Autowired
    public ProcessFileController(ProcessFileService processFileService, ProcessXML processXML) {
        this.processFileService = processFileService;
        this.processXML = processXML;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") @Valid @NotNull MultipartFile file) throws IOException, JAXBException {
        List<Agente> processedData = this.processXML.xmlToDto(file.getBytes());
        processFileService.saveAll(processedData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/consolidated/{region}")
    public ResponseEntity<Agente> getConsolidatedData(@PathVariable String region) {
        return ResponseEntity.ok(processFileService.getConsolidatedDataByRegion(region));
    }

    @GetMapping("")
    public ResponseEntity<List<Agente>> findAll() {
        return ResponseEntity.ok(processFileService.findAll());
    }


}