package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Pedido  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPedido;

    private BigDecimal total;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy HH:mm:ss",locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "id_item_pedido.pedido")
    private Set<ItemPedido> itensPedido = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;

    @OneToOne(mappedBy = "pedido")
    private Entrega entrega;

    public Pedido(BigDecimal total, Date dataRegistro, Cliente cliente, Pagamento pagamento,Entrega entrega) {
        this.total = total;
        this.dataRegistro = dataRegistro;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public Pedido() {

    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    //metodo responsavel por mostrar os produtos do pedido
    public List<Produto> getProdutos(){
        List<Produto> listaProdutos = new ArrayList<>();
        for (ItemPedido item: itensPedido) {
            listaProdutos.add(item.getProduto());
        }
        return listaProdutos;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Set<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(Set<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idPedido, pedido.idPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido);
    }
}
