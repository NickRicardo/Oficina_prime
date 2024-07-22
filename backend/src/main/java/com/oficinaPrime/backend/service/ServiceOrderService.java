package com.oficinaPrime.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.dto.ServiceOrderDTO;
import com.oficinaPrime.backend.model.ServiceOrder;
import com.oficinaPrime.backend.repository.ServiceOrderRepository;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public List<ServiceOrderDTO> getALLServiceOrders() {
        return serviceOrderRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ServiceOrderDTO getServiceOrderById(Integer id) {
        Optional<ServiceOrder> serviceOrder = serviceOrderRepository.findById(id);
        return serviceOrder.map(this::convertToDTO).orElse(null);
    }

    public List<ServiceOrderDTO> getServiceOrdersByType(String serviceType) {
        return serviceOrderRepository.findByServiceType(serviceType).stream().map(this::convertToDTO)
                .collect(Collectors.toList());

    }

    public List<ServiceOrderDTO> getServiceOrdersByDate(LocalDate serviceDate) {
        return serviceOrderRepository.findByServiceDate(serviceDate).stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public List<ServiceOrderDTO> getServiceOrdersByDateRange(LocalDate startDate, LocalDate endDate){
        return serviceOrderRepository.findByServiceDateBetween(startDate, endDate).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ServiceOrderDTO createServiceOrder(ServiceOrderDTO dto) {
        ServiceOrder serviceOrder = new ServiceOrder();
        copyProperties(dto, serviceOrder);
        serviceOrder = serviceOrderRepository.save(serviceOrder);
        return convertToDTO(serviceOrder);
    }

    public ServiceOrderDTO updateServiceOrder(Integer id, ServiceOrderDTO dto) {
        Optional<ServiceOrder> existingOrder = serviceOrderRepository.findById(id);
        if (existingOrder.isPresent()) {
            ServiceOrder serviceOrder = existingOrder.get();
            copyProperties(dto, serviceOrder);
            serviceOrder = serviceOrderRepository.save(serviceOrder);
            return convertToDTO(serviceOrder);
        }
        return null;
    }

    public void deleteServiceOrder(Integer id){
        serviceOrderRepository.deleteById(id);
    }

    private ServiceOrderDTO convertToDTO(ServiceOrder serviceOrder){
        ServiceOrderDTO dto = new ServiceOrderDTO();
        dto.setId(serviceOrder.getId());
        dto.setClientName(serviceOrder.getClientName());
        dto.setServiceType(serviceOrder.getServiceType());
        dto.setServiceDate(serviceOrder.getServiceDate());
        dto.setStatus(serviceOrder.getStatus());
        dto.setNotes(serviceOrder.getNotes());
        return dto;

    }

    private void copyProperties(ServiceOrderDTO dto, ServiceOrder serviceOrder){
        serviceOrder.setClientName(dto.getClientName());
        serviceOrder.setServiceType(dto.getServiceType());
        serviceOrder.setServiceDate(dto.getServiceDate());
        serviceOrder.setStatus(dto.getStatus());
        serviceOrder.setNotes(dto.getNotes());
    }

}
