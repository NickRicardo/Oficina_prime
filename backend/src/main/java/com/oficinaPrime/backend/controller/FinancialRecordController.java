package com.oficinaPrime.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficinaPrime.backend.dto.FinanceialRecordDTO;
import com.oficinaPrime.backend.exception.ResourceNotFoundException;
import com.oficinaPrime.backend.service.FinancialRecordService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/financial-records")
@Validated
public class FinancialRecordController {
     @Autowired
    private FinancialRecordService financialRecordService;

    @GetMapping
    public ResponseEntity<List<FinanceialRecordDTO>> getAllRecords() {
        List<FinanceialRecordDTO> records = financialRecordService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @PostMapping
    public ResponseEntity<FinanceialRecordDTO> createRecord(@Valid @RequestBody FinanceialRecordDTO recordDTO) {
        FinanceialRecordDTO createdRecord = financialRecordService.createRecord(recordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinanceialRecordDTO> getRecordById(@PathVariable Integer id) {
        FinanceialRecordDTO recordDTO = financialRecordService.getRecordById(id);
        if (recordDTO == null) {
            throw new ResourceNotFoundException("Financial record not found with id: " + id);
        }
        return ResponseEntity.ok(recordDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinanceialRecordDTO> updateRecord(@PathVariable Integer id, @Valid @RequestBody FinanceialRecordDTO recordDTO) {
        FinanceialRecordDTO updatedRecord = financialRecordService.updateRecord(id, recordDTO);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Integer id) {
        financialRecordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }

}
