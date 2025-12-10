package com.project.entities;

import com.project.models.UnidadeModel;

public class Unidade {
    private int id;
    private String numero;
    private String bloco;
    private String tipo;

    public Unidade() {}
    
    public Unidade(int id, String numero, String bloco, String tipo) {
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public UnidadeModel toModel() {
        return new UnidadeModel(
                this.getId(),
                this.getNumero(),
                this.getBloco(),
                this.getTipo()
        );
    }

    public Unidade fromModel(UnidadeModel model) {
        return new Unidade(
                model.getId(),
                model.getNumero(),
                model.getBloco(),
                model.getTipo()
        );
    }

}
