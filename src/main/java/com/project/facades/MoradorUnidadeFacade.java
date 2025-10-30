package com.project.facades;

import com.project.applications.MoradorUnidadeApplication;
import com.project.entities.MoradorUnidade;
import com.project.entities.MoradorUnidadeId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MoradorUnidadeFacade {

    private final MoradorUnidadeApplication application;

    public MoradorUnidadeFacade(MoradorUnidadeApplication application) {
        this.application = application;
    }

    public MoradorUnidade salvar(MoradorUnidade moradorUnidade) {
        return application.salvar(moradorUnidade);
    }

    public Optional<MoradorUnidade> buscarPorId(MoradorUnidadeId id) {
        return application.buscarPorId(id);
    }

    public List<MoradorUnidade> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(MoradorUnidadeId id) {
        application.deletar(id);
    }
}
