package com.project.facades;

import com.project.applications.MoradorApplication;
import com.project.entities.Morador;
import com.project.models.MoradorModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MoradorFacade {

    private final MoradorApplication moradorApplication;

    public MoradorFacade(MoradorApplication application) {
        this.moradorApplication = application;
    }

    public Morador salvar(Morador morador) {
        return moradorApplication.salvar(morador);
    }

    public Optional<Morador> buscarPorId(Integer id) {
        return moradorApplication.buscarPorId(id);
    }

    public List<Morador> listarTodos() {
        return moradorApplication.listarTodos();
    }

    public void deletar(Integer id) {
        moradorApplication.deletar(id);
    }
}
