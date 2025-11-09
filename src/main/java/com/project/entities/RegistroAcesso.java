package com.project.entities;

import com.project.models.RegistroAcessoModel;
import java.time.LocalDateTime;

public class RegistroAcesso {

        private int id;
        private LocalDateTime dataHora;
        private String situacao;

    public RegistroAcesso(int id, LocalDateTime dataHora, String situacao) {
        this.id = id;
        this.dataHora = dataHora;
        this.situacao = situacao;
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

    public RegistroAcessoModel toModel() {
        return new RegistroAcessoModel(
                this.getId(),
                this.getDataHora(),
                this.getSituacao()
        );
    }

    public RegistroAcesso fromModel(RegistroAcessoModel model) {
        return new RegistroAcesso(
                model.getId(),
                model.getDataHora(),
                model.getSituacao()
                );
    }
}




