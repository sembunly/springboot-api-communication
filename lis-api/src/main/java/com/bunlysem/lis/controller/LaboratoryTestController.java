package com.bunlysem.lis.controller;

import com.bunlysem.lis.dto.LaboratoryTestRequest;
import com.bunlysem.lis.dto.LaboratoryTestResponse;
import com.bunlysem.lis.service.LaboratoryTestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laboratory-tests")
public class LaboratoryTestController {
    private final LaboratoryTestService service;
    public LaboratoryTestController(LaboratoryTestService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<LaboratoryTestResponse> create(@Valid @RequestBody LaboratoryTestRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(LaboratoryTestResponse.from(service.create(request)));
    }

    @GetMapping
    public List<LaboratoryTestResponse> findAll() { return service.findAll().stream().map(LaboratoryTestResponse::from).toList(); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
