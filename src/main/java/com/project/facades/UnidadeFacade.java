package com.project.facades;

import com.project.applications.UnidadeApplication;
import com.project.entities.Unidade;
import com.project.models.UnidadeModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeFacade {

    private final UnidadeApplication application;

    public UnidadeFacade(UnidadeApplication application) {
        this.application = application;
    }

    public UnidadeModel salvar(UnidadeModel unidadeModel) {
        return application.salvar(unidadeModel);
    }

    public Optional<UnidadeModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<UnidadeModel> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}
