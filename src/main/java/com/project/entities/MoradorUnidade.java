package com.project.entities;

import com.project.models.MoradorUnidadeModel;
import com.project.models.UnidadeModel;

public class MoradorUnidade {

    private Long id;
    private Integer idMorador;
    private Integer idUnidade;

    public MoradorUnidade() {}

    public MoradorUnidade(Long id, Integer idMorador, Integer idUnidade) {
        this.id = id;
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