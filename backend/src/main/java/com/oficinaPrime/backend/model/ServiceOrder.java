package com.oficinaPrime.backend.model;

import com.oficinaPrime.backend.domain.ServiceOrderDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_order")
public class ServiceOrder extends ServiceOrderDomain{

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

}
