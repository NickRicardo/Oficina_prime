package com.oficinaPrime.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficinaPrime.backend.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByNome(String name);


}
