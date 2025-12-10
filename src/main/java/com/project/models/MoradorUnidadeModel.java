package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "morador_unidade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"morador_id_morador", "unidade_id_unidade"}, name = "uk_morador_unidade")
})
public class MoradorUnidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "morador_id_morador")
    private int moradorId;

    @Column(name = "unidade_id_unidade")
    private int unidadeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "morador_id_morador",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_morador_unidade_morador_id"),
            updatable = false,
            insertable = false
    )
    private MoradorModel morador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "unidade_id_unidade",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_morador_unidade_unidade_id"),
            updatable = false,
            insertable = false
    )
    private UnidadeModel unidade;

    public MoradorUnidadeModel() {}

    public MoradorUnidadeModel(Long id) {
        this.id = id;
    }

    public MoradorUnidadeModel(Long id, int moradorId, MoradorModel morador, int unidadeId, UnidadeModel unidade) {
        this.id = id;
        this.moradorId = moradorId;
        this.morador = morador;
        this.unidadeId = unidadeId;
        this.unidade = unidade;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(int moradorId) {
        this.moradorId = moradorId;
    }

    public int getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(int unidadeId) {
        this.unidadeId = unidadeId;
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
}