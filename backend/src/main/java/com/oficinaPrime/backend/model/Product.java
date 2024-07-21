package com.oficinaPrime.backend.model;

import com.oficinaPrime.backend.domain.ProductDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "product")
public class Product extends ProductDomain{


    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
