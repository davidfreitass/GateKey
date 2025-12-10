package com.project.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_acesso")
public class RegistroAcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dataHora;

    private String situacao;

    public RegistroAcessoModel() {}

    public RegistroAcessoModel(int id, LocalDateTime dataHora, String situacao) {
        this.id = id;
        this.dataHora = dataHora;
        this.situacao = situacao;
    }

    @Column(name = "dispositivo_id")
    private int dispositivoId;

    @ManyToOne
    @JoinColumn(
            name = "dispositivo_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_registro_dispositivo_dispositivo_id"),
            insertable = false, updatable = false)
    private DispositivoModel dispositivoModel;

    @Column(name = "credencial_id")
    private int credencialId;

    @ManyToOne
    @JoinColumn(
            name = "credencial_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_registro_credencial_credencial_id"),
            insertable = false, updatable = false)
    private CredencialModel credencialModel;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }

    public DispositivoModel getDispositivoModel() {
        return dispositivoModel;
    }

    public void setDispositivoModel(DispositivoModel dispositivoModel) {
        this.dispositivoModel = dispositivoModel;
    }

    public CredencialModel getCredencialModel() {
        return credencialModel;
    }

    public void setCredencialModel(CredencialModel credencialModel) {
        this.credencialModel = credencialModel;
    }
}