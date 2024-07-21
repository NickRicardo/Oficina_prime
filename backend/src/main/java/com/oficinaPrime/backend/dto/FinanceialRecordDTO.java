package com.oficinaPrime.backend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FinanceialRecordDTO implements Serializable {

    private Integer id;

    @NotNull(message = "A data não pode estar vazia")
    private LocalDate date;

    @NotNull(message = "O valor não pode estar vazio")
    @Positive(message = "O valor deve ser positivo")
    private Double amount;

    @NotNull(message = "O tipo não pode estar vazio")
    private String type;

    private String description;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
