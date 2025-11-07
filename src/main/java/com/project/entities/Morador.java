package com.project.entities;

import com.project.models.MoradorModel;

public class Morador {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String status;

    public Morador(int id, String nome, String cpf, String telefone, String email, String status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

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

    public MoradorModel toModel() {
        return new MoradorModel(
                this.getId(),
                this.getNome(),
                this.getCpf(),
                this.getTelefone(),
                this.getEmail(),
                this.getStatus()
        );
    }

    public Morador fromModel(MoradorModel model) {
        return new Morador(
                model.getId(),
                model.getNome(),
                model.getCpf(),
                model.getTelefone(),
                model.getEmail(),
                model.getStatus()
        );
    }
}
