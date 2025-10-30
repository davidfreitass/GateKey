package com.project.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Morador_Unidade")
public class MoradorUnidadeModel implements Serializable {

    @EmbeddedId
    private MoradorUnidadeIdModel id;

    @ManyToOne
    @JoinColumn(name = "Morador_idMorador")
    private MoradorModel morador;

    @ManyToOne
    @JoinColumn(name = "Unidade_idUnidade")
    private UnidadeModel unidade;

    public MoradorUnidadeModel() {}

    public MoradorUnidadeModel(MoradorModel morador, UnidadeModel unidade) {
        this.morador = morador;
        this.unidade = unidade;
        this.id = new MoradorUnidadeIdModel(morador.getId(), unidade.getId());
    }

    public MoradorUnidadeIdModel getId() {
        return id;
    }

    public void setId(MoradorUnidadeIdModel id) {
        this.id = id;
    }

    public MoradorModel getMorador() {
        return morador;
    }

    public void setMorador(MoradorModel morador) {
        this.morador = morador;
    }

    public UnidadeModel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidadeModel)) return false;
        MoradorUnidadeModel that = (MoradorUnidadeModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}