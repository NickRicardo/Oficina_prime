package com.oficinaPrime.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficinaPrime.backend.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    // Encontra vendas por cliente
    List<Sale> findByClientId(Integer clientId);

    // Encontra vendas por produto
    List<Sale> findByProductId(Integer productId);

    // Encontra vendas por data
    List<Sale> findBySaleDateBetween(Date startDate, Date endDate);

    // Encontra vendas por quantidade
    List<Sale> findByQuantityGreaterThan(Integer quantity);

    // Encontra vendas por valor total
    List<Sale> findByTotalPriceGreaterThan(Double totalPrice);
}
