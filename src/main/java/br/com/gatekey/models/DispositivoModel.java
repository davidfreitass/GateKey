package br.com.gatekey.models;

import jakarta.persistence.*;

    @Entity
    @Table(name = "Dispositivo")
    public class DispositivoModel {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;

            private String localizacao;

            private String tipo;

            private String status;

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }

            public String getLocalizacao() { return localizacao; }
            public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

            public String getTipo() { return tipo; }
            public void setTipo(String tipo) { this.tipo = tipo; }

            public String getStatus() { return status; }
            public void setStatus(String status) { this.status = status; }
        }



