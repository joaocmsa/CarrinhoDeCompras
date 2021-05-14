package com.joaodesenvolvimento.carrinhocompras.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEntrega;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy HH:mm:ss",locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy HH:mm:ss",locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrega;

    private String codigoRastreio;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_transportadora")
    private Transportadora transportadora;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

}