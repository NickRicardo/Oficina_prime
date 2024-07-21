package com.oficinaPrime.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficinaPrime.backend.dto.ProductDTO;
import com.oficinaPrime.backend.exception.ResourceNotFoundException;
import com.oficinaPrime.backend.model.Product;
import com.oficinaPrime.backend.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        product = productRepository.save(product);
        return convertToDTO(product);
    }

    public ProductDTO getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return convertToDTO(product);
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        
        product.setName(productDTO.getNome());
        product.setDescription(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setQuantidade(productDTO.getQuantidade());
        product.setCategoria(productDTO.getCategoria());
        product.setMarca(productDTO.getMarca());
        
        product = productRepository.save(product);
        return convertToDTO(product);
    }

    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setNome(product.getName());
        dto.setDescricao(product.getDescription());
        dto.setPreco(product.getPreco());
        dto.setQuantidade(product.getQuantidade());
        dto.setCategoria(product.getCategoria());
        dto.setMarca(product.getMarca());
        return dto;
    }

    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getNome());
        product.setDescription(dto.getDescricao());
        product.setPreco(dto.getPreco());
        product.setQuantidade(dto.getQuantidade());
        product.setCategoria(dto.getCategoria());
        product.setMarca(dto.getMarca());
        return product;
    }
}
