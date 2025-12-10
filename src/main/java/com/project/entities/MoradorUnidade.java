package com.project.entities;

import com.project.models.MoradorModel;
import com.project.models.MoradorUnidadeModel;
import com.project.models.UnidadeModel;

public class MoradorUnidade {

    private Long id;
    private Integer idMorador;
    private Integer idUnidade;
    private Morador morador;
    private Unidade unidade;

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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public MoradorUnidadeModel toModel() {
        return new MoradorUnidadeModel(
                this.id,
                this.idMorador,
                null,
                this.idUnidade,
                null


        );
    }

    public MoradorUnidade fromModel(MoradorUnidadeModel model) {
        MoradorUnidade entity = new MoradorUnidade(
                model.getId(),
                model.getMoradorId(),
                model.getUnidadeId()
        );

        if (model.getMorador() != null) {
            entity.setMorador(new Morador().fromModel(model.getMorador()));
        }

        if (model.getUnidade() != null) {
            entity.setUnidade(new Unidade().fromModel(model.getUnidade()));
        }

        return entity;
    }
}