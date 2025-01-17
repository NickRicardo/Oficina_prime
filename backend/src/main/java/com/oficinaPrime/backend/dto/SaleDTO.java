package com.oficinaPrime.backend.dto;
import java.util.Date;

public class SaleDTO {

    private Integer id;
    private Integer clienteId;
    private Integer produtosId;
    private Double valorTotal;
    private Date dataVenda;
    private String status;
    



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProdutosId() {
        return this.produtosId;
    }

    public void setProdutosId(Integer produtosId) {
        this.produtosId = produtosId;
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
