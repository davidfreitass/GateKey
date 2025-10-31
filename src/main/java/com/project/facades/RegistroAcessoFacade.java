package com.project.facades;

import com.project.applications.RegistroAcessoApplication;
import com.project.entities.RegistroAcesso;
import com.project.models.RegistroAcessoModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroAcessoFacade {
    private final RegistroAcessoApplication application;

    public RegistroAcessoFacade(RegistroAcessoApplication application) {
        this.application = application;
    }

    public RegistroAcessoModel salvar(RegistroAcessoModel registroAcessoModel) {
        return application.salvar(registroAcessoModel);
    }

    public Optional<RegistroAcessoModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<RegistroAcessoModel> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }

}
