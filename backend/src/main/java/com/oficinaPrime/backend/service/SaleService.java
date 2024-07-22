package com.oficinaPrime.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.dto.SaleDTO;
import com.oficinaPrime.backend.model.Sale;
import com.oficinaPrime.backend.repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SaleDTO getSaleById(Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.map(this::convertToDTO).orElse(null);
    }

    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = convertToEntity(saleDTO);
        sale = saleRepository.save(sale);
        return convertToDTO(sale);
    }

    public SaleDTO updateSale(Integer id, SaleDTO saleDTO) {
        if (!saleRepository.existsById(id)) {
            return null;
        }
        Sale sale = convertToEntity(saleDTO);
        sale.setId(id);
        sale = saleRepository.save(sale);
        return convertToDTO(sale);
    }

    public void deleteSale(Integer id) {
        saleRepository.deleteById(id);
    }

    private SaleDTO convertToDTO(Sale sale) {
        SaleDTO dto = new SaleDTO();
        dto.setId(sale.getId());
        dto.setClienteId(sale.getClientId());
        dto.setProdutosId(sale.getProductId());
        dto.setValorTotal(sale.getValorTotal());
        dto.setDataVenda(sale.getDataVenda());
        return dto;
    }

    private Sale convertToEntity(SaleDTO dto) {
        Sale sale = new Sale();
        sale.setId(dto.getId());
        sale.setClientId(dto.getClienteId());
        sale.setProductId(dto.getProdutosId());
        sale.setValorTotal(dto.getValorTotal());
        sale.setDataVenda(dto.getDataVenda());
        return sale;
    }
}