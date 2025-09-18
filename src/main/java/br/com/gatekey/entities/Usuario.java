package br.com.gatekey.entities;

public class Usuario {
    private int idUsuario;
    private String login;
    private String senha;
    private NivelAcesso nivelAcesso;
    private Status status;
    private int idFuncionario;
    private int idMorador;

    public Usuario(int idUsuario, String login, String senha, NivelAcesso nivelAcesso, Status status, int idFuncionario, int idMorador) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.status = status;
        this.idFuncionario = idFuncionario;
        this.idMorador = idMorador;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public NivelAcesso getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(NivelAcesso nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public int getIdMorador() { return idMorador; }
    public void setIdMorador(int idMorador) { this.idMorador = idMorador; }
}
