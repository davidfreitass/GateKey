package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String senha;
    private String nivelAcesso;
    private String status;

    public UsuarioModel(Integer id, String login, String senha, String nivelAcesso, String status) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.status = status;
    }

    @OneToOne()
    @JoinColumn(name = "morador_id", referencedColumnName = "id", nullable = true)
    private MoradorModel morador;

    @OneToOne()
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id", nullable = true)
    private FuncionarioModel funcionario;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public MoradorModel getMorador() { return morador; }
    public void setMorador(MoradorModel morador) { this.morador = morador; }

    public FuncionarioModel getFuncionario() { return funcionario; }
    public void setFuncionario(FuncionarioModel funcionario) { this.funcionario = funcionario; }
}