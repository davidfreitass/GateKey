package com.project.facades;


import com.project.applications.DispositivoApplication;
import com.project.entities.Dispositivo;
import com.project.models.DispositivoModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DispositivoFacade {
    private final DispositivoApplication dispositivoApplication;

    public DispositivoFacade(DispositivoApplication dispositivoApplication) {
        this.dispositivoApplication = dispositivoApplication;
    }

    public Dispositivo salvar(Dispositivo dispositivo) {
        return dispositivoApplication.salvar(dispositivo);
    }

    public Optional<Dispositivo> buscarPorId(int id) {
        return dispositivoApplication.buscarPorId(id);
    }

    public List<Dispositivo> listarTodos() {
        return dispositivoApplication.listarTodos();
    }

    public void deletar(int id) {
        dispositivoApplication.deletar(id);
    }
}


