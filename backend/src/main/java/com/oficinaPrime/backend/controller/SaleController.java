package com.oficinaPrime.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.oficinaPrime.backend.dto.SaleDTO;
import com.oficinaPrime.backend.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<SaleDTO> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Integer id) {
        SaleDTO sale = saleService.getSaleById(id);
        if (sale != null) {
            return ResponseEntity.ok(sale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO createdSale = saleService.createSale(saleDTO);
        return ResponseEntity.ok(createdSale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Integer id, @RequestBody SaleDTO saleDTO) {
        SaleDTO updatedSale = saleService.updateSale(id, saleDTO);
        if (updatedSale != null) {
            return ResponseEntity.ok(updatedSale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id){
        saleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
