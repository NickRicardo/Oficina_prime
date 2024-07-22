package com.oficinaPrime.backend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficinaPrime.backend.model.ServiceOrder;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

    List<ServiceOrder> findByServiceType(String serviceType);

    List<ServiceOrder> findByServiceDate(LocalDate serviceDate);

    List<ServiceOrder> findByServiceDateBetween(LocalDate startDate, LocalDate endDate);

  
    Optional<ServiceOrder> findById(Integer id);

}
 