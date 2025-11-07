package com.project.entities;

import com.project.models.CredencialModel;
import com.project.models.DispositivoModel;

public class Dispositivo {

    private int id;
    private String localizacao;
    private String tipo;
    private String status;

    public Dispositivo(int id, String localizacao, String tipo, String status) {
        this.id = id;
        this.localizacao = localizacao;
        this.tipo = tipo;
        this.status = status;
    }

    public int getId() {
        return id; }

    public void setId(int id) {
        this.id = id; }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status; }

    public DispositivoModel toModel() {
        return new DispositivoModel(
                this.getId(),
                this.getLocalizacao(),
                this.getTipo(),
                this.getStatus()
        );
    }

    public Dispositivo fromModel(DispositivoModel model) {
        return new Dispositivo(
                model.getId(),
                model.getLocalizacao(),
                model.getTipo(),
                model.getStatus()

        );
    }

}
