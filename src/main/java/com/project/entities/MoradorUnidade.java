package com.project.entities;

public class MoradorUnidade {

    private Long id;

    private Integer idMorador;

    private Integer idUnidade;

    public MoradorUnidade() {}

    public MoradorUnidade(Integer idMorador, Integer idUnidade) {
        this.idMorador = idMorador;
        this.idUnidade = idUnidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Integer idMorador) {
        this.idMorador = idMorador;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

}