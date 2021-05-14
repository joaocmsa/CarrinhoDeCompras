package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy HH:mm:ss",locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;

}
