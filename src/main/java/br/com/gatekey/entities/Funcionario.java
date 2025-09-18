package br.com.gatekey.entities;

public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private byte[] fotoPerfil;
    private Status status;

    public Funcionario(int idFuncionario, String nome, String cpf, String telefone, String email, byte[] fotoPerfil, Status status) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.status = status;
    }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public byte[] getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(byte[] fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
