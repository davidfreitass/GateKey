package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String senha;
    private String nivelAcesso;
    private String status;

    @OneToOne()
    @JoinColumn(name = "morador_id", referencedColumnName = "id")
    private MoradorModel morador;

    @OneToOne()
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private FuncionarioModel funcionario;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}