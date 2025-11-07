package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "credenciais")
public class CredencialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private byte[] dadosBiometricos;

    public CredencialModel(int id, byte[] dadosBiometricos) {
        this.id = id;
        this.dadosBiometricos = dadosBiometricos;
    }

    @OneToOne
    @JoinColumn(name = "morador_id", referencedColumnName = "id")
    private MoradorModel morador;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private FuncionarioModel funcionario;

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
}
