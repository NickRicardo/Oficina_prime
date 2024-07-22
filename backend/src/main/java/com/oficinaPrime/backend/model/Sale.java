package com.oficinaPrime.backend.model;

import com.oficinaPrime.backend.domain.SaleDomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

import java.util.List;

@Entity
@Table(name = "sale")
public class Sale extends SaleDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(name = "sale_product", joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> produtos;

    @Column(nullable = false)
    private Double valorTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataVenda;

    @Column
    private String status;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Product> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return this.dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
