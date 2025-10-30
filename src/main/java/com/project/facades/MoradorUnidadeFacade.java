package com.project.facades;

import com.project.applications.MoradorUnidadeApplication;
import com.project.entities.MoradorUnidade;
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

    public List<MoradorUnidade> listarTodos() {
        return application.listarTodos();
    }

    public Optional<MoradorUnidade> buscarPorId(Long id) {
        return application.buscarPorId(id);
    }

    public void deletar(Long id) {
        application.deletarPorId(id);
    }

    public Optional<MoradorUnidade> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return application.buscarPorMoradorIdEUnidadeId(moradorId, unidadeId);
    }

    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return application.deletarPorMoradorIdEUnidadeId(moradorId, unidadeId);
    }
}