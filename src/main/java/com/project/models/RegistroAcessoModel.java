package com.project.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RegistroAcesso")
public class RegistroAcessoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private LocalDateTime dataHora;

        private String situacao;

        @ManyToOne
        @JoinColumn(name = "dispositivo_id", referencedColumnName = "id")
        private DispositivoModel dispositivoModel;

        @ManyToOne
        @JoinColumn(name = "credencial_id", referencedColumnName = "id")
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


