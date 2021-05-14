package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEndereco;

    private String logradrouro;

    private String cep;

    private String complemento;

    private String numero;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    public Endereco(String logradrouro, String cep, String complemento, String numero, Entrega entrega, Cidade cidade) {
        this.logradrouro = logradrouro;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.entrega = entrega;
        this.cidade = cidade;
    }

    public Endereco() {

    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradrouro() {
        return logradrouro;
    }

    public void setLogradrouro(String logradrouro) {
        this.logradrouro = logradrouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(idEndereco, endereco.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco);
    }
}
