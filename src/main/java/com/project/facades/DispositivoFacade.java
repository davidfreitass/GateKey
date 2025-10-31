package com.project.facades;


import com.project.applications.DispositivoApplication;
import com.project.entities.Dispositivo;
import com.project.models.DispositivoModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DispositivoFacade {
    private final DispositivoApplication application;

    public DispositivoFacade(DispositivoApplication application) {
        this.application = application;
    }

    public DispositivoModel salvar(DispositivoModel dispositivoModel) {
        return application.salvar(dispositivoModel);
    }

    public Optional<DispositivoModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<DispositivoModel> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}


