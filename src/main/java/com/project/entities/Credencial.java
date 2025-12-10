package com.project.entities;

import com.project.models.CredencialModel;


public class Credencial {

    private int id;
    private byte[] dadosBiometricos;

    public Credencial() {}

    public Credencial(int id, byte[] dadosBiometricos) {
        this.id = id;
        this.dadosBiometricos = dadosBiometricos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getDadosBiometricos() {
        return dadosBiometricos;
    }

    public void setDadosBiometricos(byte[] dadosBiometricos) {
        this.dadosBiometricos = dadosBiometricos;
    }

    public CredencialModel toModel() {
        return new CredencialModel(
                this.getId(),
                this.getDadosBiometricos()
        );
    }

    public Credencial fromModel(CredencialModel model) {
        return new Credencial(
                model.getId(),
                model.getDadosBiometricos()
        );
    }
}
