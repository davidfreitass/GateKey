package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "morador_unidade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"morador_id", "unidade_id"}, name = "uk_morador_unidade")
})
public class MoradorUnidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "morador_id")
    private int moradorId;

    @ManyToOne
    @JoinColumn(
            name = "morador_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_morador_unidade_morador_id"),
            insertable = false, updatable = false)
    private MoradorModel morador;

    @Column(name = "unidade_id")
    private int unidadeId;

    @ManyToOne
    @JoinColumn(
            name = "unidade_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_morador_unidade_unidade_id"),
            insertable = false, updatable = false)
    private UnidadeModel unidade;

    public MoradorUnidadeModel() {}

    public MoradorUnidadeModel(MoradorModel morador, UnidadeModel unidade) {
        this.morador = morador;
        this.unidade = unidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(int moradorId) {
        this.moradorId = moradorId;
    }

    public MoradorModel getMorador() {
        return morador;
    }

    public void setMorador(MoradorModel morador) {
        this.morador = morador;
    }

    public int getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(int unidadeId) {
        this.unidadeId = unidadeId;
    }

    public UnidadeModel getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidade = unidade;
    }
}