package com.project.facades;

import com.project.applications.MoradorApplication;
import com.project.entities.Morador;
import com.project.models.MoradorModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MoradorFacade {

    private final MoradorApplication application;

    public MoradorFacade(MoradorApplication application) {
        this.application = application;
    }

    public MoradorModel salvar(MoradorModel moradorModel) {
        return application.salvar(moradorModel);
    }

    public Optional<MoradorModel> buscarPorId(Integer id) {
        return application.buscarPorId(id);
    }

    public List<MoradorModel> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(Integer id) {
        application.deletar(id);
    }
}
