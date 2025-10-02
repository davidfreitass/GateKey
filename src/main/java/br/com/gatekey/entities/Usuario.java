package br.com.gatekey.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String login;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = false, length = 20)
    private String nivelAcesso;

    @Column(nullable = false, length = 20)
    private String status;

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