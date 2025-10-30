package com.project.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Morador_Unidade")
public class MoradorUnidade implements Serializable {

    @EmbeddedId
    private MoradorUnidadeId id;

    public MoradorUnidade() {}

    public MoradorUnidade(MoradorUnidadeId id) {
        this.id = id;
    }

    public MoradorUnidadeId getId() {
        return id;
    }

    public void setId(MoradorUnidadeId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidade)) return false;
        MoradorUnidade that = (MoradorUnidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}