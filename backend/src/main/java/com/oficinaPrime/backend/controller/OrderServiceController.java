package com.oficinaPrime.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oficinaPrime.backend.dto.ServiceOrderDTO;
import com.oficinaPrime.backend.service.ServiceOrderService;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/service-orders")
public class OrderServiceController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping
    public ResponseEntity<List<ServiceOrderDTO>> getALLServiceOrders() {
        List<ServiceOrderDTO> orders = serviceOrderService.getALLServiceOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> getServiceOrderById(@PathVariable Integer id) {
        ServiceOrderDTO order = serviceOrderService.getServiceOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();

    }

    @GetMapping("/type/{serviceType}")
    public ResponseEntity<List<ServiceOrderDTO>> getServiceOrdersByType(@PathVariable String serviceType) {
        List<ServiceOrderDTO> orders = serviceOrderService.getServiceOrdersByType(serviceType);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/date")
    public ResponseEntity<List<ServiceOrderDTO>> getServiceOrdersByDate(@PathVariable String date) {
        List<ServiceOrderDTO> orders = serviceOrderService.getServiceOrdersByType(date);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<ServiceOrderDTO>> getServiceOrdersByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<ServiceOrderDTO> orders = serviceOrderService.getServiceOrdersByDateRange(startDate, endDate);
        return ResponseEntity.ok(orders);
    }
    @PostMapping
    public ResponseEntity<ServiceOrderDTO> createServiceOrder(@RequestBody ServiceOrderDTO dto) {
        ServiceOrderDTO createdOrder = serviceOrderService.createServiceOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> updateServiceOrder(@PathVariable Integer id, @RequestBody ServiceOrderDTO dto){
        ServiceOrderDTO updatedOrder = serviceOrderService.updateServiceOrder(id, dto);
        return updatedOrder != null ? ResponseEntity.ok(updatedOrder): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceOrder(@PathVariable Integer id) {
        serviceOrderService.deleteServiceOrder(id);
        return ResponseEntity.noContent().build();
        }
}
