package com.project.facades;

import com.project.applications.MoradorUnidadeApplication;
import com.project.entities.MoradorUnidade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorUnidadeFacade {

    private final MoradorUnidadeApplication application;

    public MoradorUnidadeFacade(MoradorUnidadeApplication application) {
        this.application = application;
    }

    public MoradorUnidade salvar(MoradorUnidade moradorUnidade) {
        return application.salvar(moradorUnidade);
    }

    public Optional<MoradorUnidade> buscarPorId(Long id) {
        return application.buscarPorId(id);
    }

    public List<MoradorUnidade> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(Long id) {
        application.deletar(id);
    }

    public Optional<MoradorUnidade> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return application.buscarPorIdsMoradorUnidade(moradorId, unidadeId);
    }

    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return application.deletarPorIdsMoradorUnidade(moradorId, unidadeId);
    }
}
