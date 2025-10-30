package com.project.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Morador_Unidade")
public class MoradorUnidadeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "Morador_idMorador",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_MoradorUnidade_Morador_ID"),
            insertable = false,
            updatable = false
    )

    private MoradorModel moradorModel;

    @ManyToOne
    @JoinColumn(
            name = "Unidade_idUnidade",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_MoradorUnidade_Unidade_ID"),
            insertable = false,
            updatable = false
    )
    private UnidadeModel unidade;

    public MoradorUnidadeModel() {}

    public MoradorUnidadeModel(MoradorModel morador, UnidadeModel unidade) {
        this.moradorModel = morador;
        this.unidade = unidade;
    }

    public MoradorModel getMorador() {
        return moradorModel;
    }

    public void setMorador(MoradorModel morador) {
        this.moradorModel = morador;
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
        return Objects.equals(moradorModel, that.moradorModel) &&
                Objects.equals(unidade, that.unidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moradorModel, unidade);
    }
}