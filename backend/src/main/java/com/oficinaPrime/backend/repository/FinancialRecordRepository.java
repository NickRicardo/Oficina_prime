package com.oficinaPrime.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficinaPrime.backend.model.FinancialRecord;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Integer> {
    /**
     * Encontra registros financeiros pelo tipo.
     * 
     * @param type o tipo de registro financeiro
     * @return uma lista de registros financeiros do tipo especificado
     */
    List<FinancialRecord> findByType(String type);

    /**
     * Encontra registros financeiros por data.
     * 
     * @param date a data do registro financeiro
     * @return uma lista de registros financeiros na data especificada
     */
    List<FinancialRecord> findByDate(LocalDate date);

    /**
     * Encontra registros financeiros por intervalo de datas.
     * 
     * @param startDate a data de início do intervalo
     * @param endDate   a data de término do intervalo
     * @return uma lista de registros financeiros no intervalo de datas especificado
     */
    List<FinancialRecord> findByDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Encontra um registro financeiro pelo ID e retorna um Optional.
     * 
     * @param id o ID do registro financeiro
     * @return um Optional contendo o registro financeiro se encontrado, ou vazio se
     *         não encontrado
     */
    Optional<FinancialRecord> findById(Integer id);
}