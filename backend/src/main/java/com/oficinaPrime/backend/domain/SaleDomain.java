package com.oficinaPrime.backend.domain;

import java.io.Serializable;
import java.util.Date;

public abstract class SaleDomain implements Serializable {

    protected Integer id;
    protected Integer clientId;
    protected Integer productId;
    protected Double valorTotal;
    protected Date dataVenda;
    protected String status;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
