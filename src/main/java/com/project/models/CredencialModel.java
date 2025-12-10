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

    @Column(name = "morador_id")
    private Integer moradorId;

    @OneToOne
    @JoinColumn(name = "morador_id", insertable = false, updatable = false)
    private MoradorModel morador;

    @Column(name = "funcionario_id")
    private Integer funcionarioId;

    @OneToOne
    @JoinColumn(name = "funcionario_id", insertable = false, updatable = false)
    private FuncionarioModel funcionario;

    public CredencialModel() {}

    public CredencialModel(int id, byte[] dadosBiometricos) {
        this.id = id;
        this.dadosBiometricos = dadosBiometricos;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public byte[] getDadosBiometricos() { return dadosBiometricos; }

    public void setDadosBiometricos(byte[] dadosBiometricos) {
        this.dadosBiometricos = dadosBiometricos;
    }

    public Integer getMoradorId() { return moradorId; }
    public void setMoradorId(Integer moradorId) { this.moradorId = moradorId; }

    public Integer getFuncionarioId() { return funcionarioId; }
    public void setFuncionarioId(Integer funcionarioId) { this.funcionarioId = funcionarioId; }

    public MoradorModel getMorador() { return morador; }
    public FuncionarioModel getFuncionario() { return funcionario; }

}