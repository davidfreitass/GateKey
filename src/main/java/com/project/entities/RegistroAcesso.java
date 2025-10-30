package com.project.entities;

import java.time.LocalDateTime;

public class RegistroAcesso {
        private int id;

        private LocalDateTime dataHora;

        private String situacao;

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
}



