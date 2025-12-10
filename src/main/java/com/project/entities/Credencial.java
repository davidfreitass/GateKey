package com.project.entities;

import com.project.models.CredencialModel;


public class Credencial {

    private int id;
    private byte[] dadosBiometricos;
    private Integer moradorId;
    private Integer funcionarioId;

    public Credencial(int id, byte[] dadosBiometricos, Integer moradorId, Integer funcionarioId) {
        this.id = id;
        this.dadosBiometricos = dadosBiometricos;
        this.moradorId = moradorId;
        this.funcionarioId = funcionarioId;
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

    public Integer getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(Integer moradorId) {
        this.moradorId = moradorId;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public CredencialModel toModel() {
        CredencialModel model = new CredencialModel();
        model.setId(this.id);
        model.setDadosBiometricos(this.dadosBiometricos);
        model.setMoradorId(this.moradorId);
        model.setFuncionarioId(this.funcionarioId);
        return model;
    }

    public Credencial fromModel(CredencialModel model) {
        return new Credencial(
                model.getId(),
                model.getDadosBiometricos(),
                model.getMoradorId(),
                model.getFuncionarioId()
        );
    }
}