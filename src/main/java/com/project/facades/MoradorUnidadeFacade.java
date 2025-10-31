package com.project.facades;

import com.project.applications.MoradorUnidadeApplication;
import com.project.entities.MoradorUnidade;
import com.project.models.MoradorUnidadeModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorUnidadeFacade {

    private final MoradorUnidadeApplication application;

    public MoradorUnidadeFacade(MoradorUnidadeApplication application) {
        this.application = application;
    }

    public MoradorUnidadeModel salvar(MoradorUnidadeModel moradorUnidadeModel) {
        return application.salvar(moradorUnidadeModel);
    }

    public Optional<MoradorUnidadeModel> buscarPorId(Long id) {
        return application.buscarPorId(id);
    }

    public List<MoradorUnidadeModel> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(Long id) {
        application.deletar(id);
    }

    public Optional<MoradorUnidadeModel> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return application.buscarPorIdsMoradorUnidade(moradorId, unidadeId);
    }

    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return application.deletarPorIdsMoradorUnidade(moradorId, unidadeId);
    }
}
