package com.bunlysem.lis.controller;

import com.bunlysem.lis.dto.LaboratoryResultRequest;
import com.bunlysem.lis.dto.LaboratoryResultResponse;
import com.bunlysem.lis.service.LaboratoryResultService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laboratory-results")
public class LaboratoryResultController {
    private final LaboratoryResultService service;
    public LaboratoryResultController(LaboratoryResultService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<LaboratoryResultResponse> create(@Valid @RequestBody LaboratoryResultRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(LaboratoryResultResponse.from(service.create(request)));
    }

    @GetMapping
    public List<LaboratoryResultResponse> findAll() { return service.findAll().stream().map(LaboratoryResultResponse::from).toList(); }
}
