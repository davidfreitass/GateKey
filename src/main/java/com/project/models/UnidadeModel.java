package com.project.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidade")
public class UnidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String bloco;
    private String tipo;

    public UnidadeModel(int id, String numero, String bloco, String tipo) {
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
        this.tipo = tipo;
    }

    @OneToMany(mappedBy = "unidade")
    private List<MoradorUnidadeModel> moradorUnidadeModelList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
