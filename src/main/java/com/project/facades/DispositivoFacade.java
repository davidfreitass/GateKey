package com.project.facades;


import com.project.applications.DispositivoApplication;
import com.project.entities.Dispositivo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DispositivoFacade {
    private final DispositivoApplication application;

    public DispositivoFacade(DispositivoApplication application) {
        this.application = application;
    }

    public Dispositivo salvar(Dispositivo dispositivo) {
        return application.salvar(dispositivo);
    }

    public Optional<Dispositivo> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Dispositivo> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}


