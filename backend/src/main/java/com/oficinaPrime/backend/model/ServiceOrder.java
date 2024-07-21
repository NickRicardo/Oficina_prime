package com.oficinaPrime.backend.model;

import com.oficinaPrime.backend.domain.enums.ServiceOrderStatus;
import com.oficinaPrime.backend.domain.enums.ServiceType;

public class ServiceOrder {
    private Integer id;
    private Client cliente;
    private ServiceType tipoServico;
    private ServiceOrderStatus status;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getCliente() {
        return this.cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public ServiceType getTipoServico() {
        return this.tipoServico;
    }

    public void setTipoServico(ServiceType tipoServico) {
        this.tipoServico = tipoServico;
    }

    public ServiceOrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }


}
