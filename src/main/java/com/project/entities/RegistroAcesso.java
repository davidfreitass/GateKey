package com.project.entities;

import com.project.models.RegistroAcessoModel;
import java.time.LocalDateTime;

public class RegistroAcesso {

    private int id;
    private LocalDateTime dataHora;
    private String situacao;
    private int credencialId;
    private int dispositivoId;

    public RegistroAcesso() {
        
    }

    public RegistroAcesso(int id, LocalDateTime dataHora, String situacao,
                          int credencialId, int dispositivoId) {
        this.id = id;
        this.dataHora = dataHora;
        this.situacao = situacao;
        this.credencialId = credencialId;
        this.dispositivoId = dispositivoId;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCredencialId() {
        return credencialId;
    }

    public void setCredencialId(int credencialId) {
        this.credencialId = credencialId;
    }

    public int getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(int dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    
    public RegistroAcessoModel toModel() {
        RegistroAcessoModel model = new RegistroAcessoModel();
        model.setId(this.id);
        model.setDataHora(this.dataHora);
        model.setSituacao(this.situacao);
        model.setCredencialId(this.credencialId);
        model.setDispositivoId(this.dispositivoId);
        return model;
    }

   
    public static RegistroAcesso fromModel(RegistroAcessoModel model) {
        return new RegistroAcesso(
                model.getId(),
                model.getDataHora(),
                model.getSituacao(),
                model.getCredencialId(),
                model.getDispositivoId()
        );
    }
}
