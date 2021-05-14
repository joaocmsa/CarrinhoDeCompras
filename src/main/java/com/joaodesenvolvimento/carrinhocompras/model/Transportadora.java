package com.joaodesenvolvimento.carrinhocompras.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transportadora implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTransportadora;

    private String nome;

    private BigDecimal valorFrete;

    @OneToMany(mappedBy = "transportadora")
    private List<Entrega> entrega  = new ArrayList<>();

    public Transportadora(String nome, BigDecimal valorFrete) {
        this.nome = nome;
        this.valorFrete = valorFrete;
    }

    public Transportadora() {

    }

    public Long getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(Long idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public List<Entrega> getEntrega() {
        return entrega;
    }

    public void setEntrega(List<Entrega> entrega) {
        this.entrega = entrega;
    }
}
