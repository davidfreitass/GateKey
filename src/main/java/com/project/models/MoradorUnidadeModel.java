package com.project.models;

import jakarta.persistence.*;


@Entity
@Table(name = "Morador_Unidade")
public class MoradorUnidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Morador_idMorador")
    private int idMorador;

    @Column(name = "Unidade_idUnidade")
    private int idUnidade;;

    @ManyToOne
    @JoinColumn(
            name = "Morador_idMorador",
            referencedColumnName = "id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_MoradorUnidade_Morador_ID")
    )
    private MoradorModel moradorModel;

    @ManyToOne
    @JoinColumn(
            name = "Unidade_idUnidade",
            referencedColumnName = "id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "FK_MoradorUnidade_Unidade_ID")
    )
    private UnidadeModel unidadeModel;

    public MoradorUnidadeModel() {}

    public MoradorUnidadeModel(Integer idMorador, Integer idUnidade) {
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

    public MoradorModel getMorador() {
        return moradorModel;
    }

    public void setMorador(MoradorModel morador) {
        this.moradorModel = morador;
    }

    public UnidadeModel getUnidade() {
        return unidadeModel;
    }

    public void setUnidade(UnidadeModel unidade) {
        this.unidadeModel = unidade;
    }
}
