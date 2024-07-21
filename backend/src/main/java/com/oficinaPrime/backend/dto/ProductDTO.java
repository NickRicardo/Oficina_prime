package com.oficinaPrime.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDTO {

    private Integer id;

    @NotEmpty(message = "O nome do produto não pode estar vazio")
    private String nome;

    @NotEmpty(message = "A descrição do produto não pode estar vazia")
    private String descricao;

    @NotNull(message = "O preço do produto não pode estar vazio")
    @Positive(message = "O preço do produto deve ser positivo")
    private Double preco;

    @NotNull(message = "A quantidade do produto não pode estar vazia")
    @Positive(message = "A quantidade do produto deve ser positiva")
    private Integer quantidade;

    @NotEmpty(message = "A categoria do produto não pode estar vazia")
    private String categoria;

    @NotEmpty(message = "A marca do produto não pode estar vazia")
    private String marca;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    

}
