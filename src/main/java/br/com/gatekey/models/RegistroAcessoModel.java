package br.com.gatekey.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RegistroAcesso")
public class RegistroAcessoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "data_hora", nullable = false)
        private LocalDateTime dataHora;

        private String situacao;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public LocalDateTime getDataHora() { return dataHora; }
        public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

        public String getSituacao() { return situacao; }
        public void setSituacao(String situacao) { this.situacao = situacao; }
    }


