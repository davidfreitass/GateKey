package com.project.entities;

import com.project.models.FuncionarioModel;
import com.project.models.MoradorModel;

public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private byte[] fotoPerfil;
    private String status;

    public Funcionario(int id, String nome, String cpf, String telefone, String email, byte[] fotoPerfil, String status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean validarCpf(String cpf) {
        if (cpf == null) return false;

        String apenasDigitos = cpf.replaceAll("\\D", "");

        if (apenasDigitos.length() != 11) return false;

        if (apenasDigitos.matches("^(\\d)\\1{10}$")) return false;

        try {
            int[] nums = new int[11];
            for (int i = 0; i < 11; i++) {
                nums[i] = Integer.parseInt(String.valueOf(apenasDigitos.charAt(i)));
            }

            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += nums[i] * (10 - i);
            }
            int resto = soma % 11;
            int dig1 = (resto < 2) ? 0 : 11 - resto;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += nums[i] * (11 - i);
            }
            resto = soma % 11;
            int dig2 = (resto < 2) ? 0 : 11 - resto;

            return dig1 == nums[9] && dig2 == nums[10];
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public FuncionarioModel toModel() {
        return new FuncionarioModel(
                this.getId(),
                this.getNome(),
                this.getCpf(),
                this.getTelefone(),
                this.getEmail(),
                this.getFotoPerfil(),
                this.getStatus()
        );
    }

    public Funcionario fromModel(FuncionarioModel model) {
        return new Funcionario(
                model.getId(),
                model.getNome(),
                model.getCpf(),
                model.getTelefone(),
                model.getEmail(),
                model.getFotoPerfil(),
                model.getStatus()
        );
    }
}