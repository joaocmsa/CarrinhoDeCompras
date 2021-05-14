package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPais;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais() {

    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
