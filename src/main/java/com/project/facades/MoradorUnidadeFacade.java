package com.project.facades;

import com.project.applications.MoradorUnidadeApplication;
import com.project.entities.MoradorUnidade;
import com.project.models.MoradorUnidadeModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorUnidadeFacade {

    private final MoradorUnidadeApplication moradorUnidadeApplication;

    public MoradorUnidadeFacade(MoradorUnidadeApplication application) {
        this.moradorUnidadeApplication = application;
    }

    public MoradorUnidadeModel salvar(MoradorUnidadeModel moradorUnidadeModel) {
        return moradorUnidadeApplication.salvar(moradorUnidadeModel);
    }

    public Optional<MoradorUnidadeModel> buscarPorId(int id) {
        return moradorUnidadeApplication.buscarPorId(id);
    }

    public List<MoradorUnidadeModel> listarTodos() {
        return moradorUnidadeApplication.listarTodos();
    }

    public void deletar(int id) {
        moradorUnidadeApplication.deletar(id);
    }

    public Optional<MoradorUnidadeModel> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return moradorUnidadeApplication.buscarPorIdsMoradorUnidade(moradorId, unidadeId);
    }

    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return moradorUnidadeApplication.deletarPorIdsMoradorUnidade(moradorId, unidadeId);
    }
}
