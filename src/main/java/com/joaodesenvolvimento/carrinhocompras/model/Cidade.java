package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCidade;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade")
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public Cidade(Long idCidade, String nome, Estado estado) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade() {

    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(idCidade, cidade.idCidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade);
    }


}
