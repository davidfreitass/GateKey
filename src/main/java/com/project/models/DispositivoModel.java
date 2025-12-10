package com.project.models;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "dispositivos")
    public class DispositivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String localizacao;
    private String tipo;
    private String status;

    public DispositivoModel() { }

    public DispositivoModel(int id, String localizacao, String tipo, String status) {
        this.id = id;
        this.localizacao = localizacao;
        this.tipo = tipo;
        this.status = status;
    }

    @OneToMany(mappedBy = "dispositivoModel")
            private List<RegistroAcessoModel> registroAcessoModels = new ArrayList<>();

            public int getId() { return id; }
            public void setId(int id) { this.id = id; }

            public String getLocalizacao() { return localizacao; }
            public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

            public String getTipo() { return tipo; }
            public void setTipo(String tipo) { this.tipo = tipo; }

            public String getStatus() { return status; }
            public void setStatus(String status) { this.status = status; }
        }



