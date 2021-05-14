package com.joaodesenvolvimento.carrinhocompras.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TipoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTipoPagamento;

    private String descricao;

    public TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public TipoPagamento() {

    }

    public Long getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(Long idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPagamento that = (TipoPagamento) o;
        return Objects.equals(idTipoPagamento, that.idTipoPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoPagamento);
    }
}
