package com.oficinaPrime.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficinaPrime.backend.model.FinancialRecord;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Integer>{

    

}
