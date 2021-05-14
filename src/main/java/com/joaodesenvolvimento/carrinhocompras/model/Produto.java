package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProduto;

    private BigDecimal valorUnitario;

    private Byte foto;

    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "id_item_pedido.produto")
    private Set<ItemPedido> itensPedido = new HashSet<>();

    public Produto(BigDecimal valorUnitario, Byte foto, String descricao) {
        this.valorUnitario = valorUnitario;
        this.foto = foto;
        this.descricao = descricao;
    }

    public Produto() {

    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(Set<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }


}
