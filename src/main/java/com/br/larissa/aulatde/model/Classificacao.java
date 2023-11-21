package com.br.larissa.aulatde.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "classificacao")
public class Classificacao implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Classificacao() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
