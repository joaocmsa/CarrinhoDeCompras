package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class ItemPedido implements Serializable {

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id_item_pedido = new ItemPedidoPK();

    private Integer quantidade;

    private BigDecimal subTotal;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, BigDecimal subTotal) {
        this.id_item_pedido.setPedido(pedido);
        this.id_item_pedido.setProduto(produto);
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public ItemPedido() {

    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Pedido getPedido() {
        return id_item_pedido.getPedido();
    }

    public void setPedido(Pedido pedido) {
        this.id_item_pedido.setPedido(pedido);
    }

    public Produto getProduto() {
        return id_item_pedido.getProduto();
    }

    public void setProduto(Produto produto) {
        this.id_item_pedido.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
