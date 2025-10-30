package com.project.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MoradorUnidadeId implements Serializable {

    @Column(name = "Morador_idMorador")
    private Integer idMorador;

    @Column(name = "Unidade_idUnidade")
    private Integer idUnidade;

    public MoradorUnidadeId() {}

    public MoradorUnidadeId(Integer idMorador, Integer idUnidade) {
        this.idMorador = idMorador;
        this.idUnidade = idUnidade;
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
        if (!(o instanceof MoradorUnidadeId)) return false;
        MoradorUnidadeId that = (MoradorUnidadeId) o;
        return Objects.equals(idMorador, that.idMorador) &&
                Objects.equals(idUnidade, that.idUnidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMorador, idUnidade);
    }
}
