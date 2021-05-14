package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPagamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy HH:mm:ss",locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_pagamento")
    private TipoPagamento tipoPagamento;

    public Pagamento(Date data, String status, TipoPagamento tipoPagamento) {
        this.data = data;
        this.status = status;
        this.tipoPagamento = tipoPagamento;
    }

    public Pagamento() {

    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(idPagamento, pagamento.idPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPagamento);
    }
}
