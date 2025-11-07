package com.project.entities;

import com.project.models.MoradorModel;
import com.project.models.UnidadeModel;
import com.project.models.UsuarioModel;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String nivelAcesso;
    private String status;

    public Usuario(int id, String login, String senha, String nivelAcesso, String status) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.status = status;
    }

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

    public UsuarioModel toModel() {
        return new UsuarioModel(
                this.getId(),
                this.getLogin(),
                this.getSenha(),
                this.getNivelAcesso(),
                this.getStatus()
        );
    }

    public Usuario fromModel(UsuarioModel model) {
        return new Usuario(
                model.getId(),
                model.getLogin(),
                model.getSenha(),
                model.getNivelAcesso(),
                model.getStatus()
        );
    }
}