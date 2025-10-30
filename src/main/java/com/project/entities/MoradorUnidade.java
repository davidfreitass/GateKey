package com.project.entities;

import java.io.Serializable;
import java.util.Objects;

public class MoradorUnidade implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidade)) return false;
        MoradorUnidade that = (MoradorUnidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}