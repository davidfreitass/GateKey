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

    public MoradorUnidade salvar(MoradorUnidade moradorUnidade) {
        return moradorUnidadeApplication.salvar(moradorUnidade);
    }

    public Optional<MoradorUnidade> buscarPorId(Long id) {
        return moradorUnidadeApplication.buscarPorId(id);
    }

    public List<MoradorUnidade> listarTodos() {
        return moradorUnidadeApplication.listarTodos();
    }

    public void deletar(Long id) {
        moradorUnidadeApplication.deletar(id);
    }
}