package com.oficinaPrime.backend.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.dto.ServiceOrderDTO;
import com.oficinaPrime.backend.repository.ServiceOrderRepository;
import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public List<ServiceOrderDTO> getALLServiceOrders(){
        return serviceOrderRepository.findAll().stream().map(this::convertToDTO).collect(Collectotors.toList());
    }

    public


}
