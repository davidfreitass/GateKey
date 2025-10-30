package com.project.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MoradorUnidadeIdModel implements Serializable {

    private int idMorador;
    private int idUnidade;

    public MoradorUnidadeIdModel() {}

    public MoradorUnidadeIdModel(int idMorador, int idUnidade) {
        this.idMorador = idMorador;
        this.idUnidade = idUnidade;
    }

    public int getIdMorador() { return idMorador; }
    public void setIdMorador(int idMorador) { this.idMorador = idMorador; }
    public int getIdUnidade() { return idUnidade; }
    public void setIdUnidade(int idUnidade) { this.idUnidade = idUnidade; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidadeIdModel)) return false;
        MoradorUnidadeIdModel that = (MoradorUnidadeIdModel) o;
        return Objects.equals(idMorador, that.idMorador) &&
                Objects.equals(idUnidade, that.idUnidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMorador, idUnidade);
    }
}