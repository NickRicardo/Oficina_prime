package com.oficinaPrime.backend.domain;

import java.io.Serializable;

public abstract class ProductDomain implements Serializable{
    protected Integer id;
    protected String name;
    protected String description;
    protected Double preco;
    protected Integer quantidade;
    protected String categoria;
    protected String marca;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setCategoria(String catergoria) {
        this.categoria = catergoria;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}
