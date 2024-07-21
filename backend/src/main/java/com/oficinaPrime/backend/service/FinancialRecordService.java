package com.oficinaPrime.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.dto.FinanceialRecordDTO;
import com.oficinaPrime.backend.exception.ResourceNotFoundException;
import com.oficinaPrime.backend.model.FinancialRecord;
import com.oficinaPrime.backend.repository.FinancialRecordRepository;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository financialRecordRepository;

    public List<FinanceialRecordDTO> getAllRecords() {
        return financialRecordRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public FinanceialRecordDTO createRecord(FinanceialRecordDTO recordDTO) {
        FinancialRecord record = convertToEntity(recordDTO);
        record = financialRecordRepository.save(record);
        return convertToDTO(record);
    }

    public FinanceialRecordDTO getRecordById(Integer id) {
        FinancialRecord record = financialRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro financeiro não encontrado com id: " + id));
        return convertToDTO(record);
    }

    public FinanceialRecordDTO updateRecord(Integer id, FinanceialRecordDTO recordDTO) {
        FinancialRecord record = financialRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro financeiro não encontrado com id: " + id));
        
        record.setDate(recordDTO.getDate());
        record.setAmount(recordDTO.getAmount());
        record.setType(recordDTO.getType());
        record.setDescription(recordDTO.getDescription());
        
        record = financialRecordRepository.save(record);
        return convertToDTO(record);
    }

    public void deleteRecord(Integer id) {
        FinancialRecord record = financialRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro financeiro não encontrado com id: " + id));
        financialRecordRepository.delete(record);
    }

    private FinanceialRecordDTO convertToDTO(FinancialRecord record) {
        FinanceialRecordDTO dto = new FinanceialRecordDTO();
        dto.setId(record.getId());
        dto.setDate(record.getDate());
        dto.setAmount(record.getAmount());
        dto.setType(record.getType());
        dto.setDescription(record.getDescription());
        return dto;
    }

    private FinancialRecord convertToEntity(FinanceialRecordDTO dto) {
        FinancialRecord record = new FinancialRecord();
        record.setId(dto.getId());
        record.setDate(dto.getDate());
        record.setAmount(dto.getAmount());
        record.setType(dto.getType());
        record.setDescription(dto.getDescription());
        return record;
    }
}