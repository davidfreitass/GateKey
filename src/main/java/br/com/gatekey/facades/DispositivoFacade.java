package br.com.gatekey.facades;

import br.com.gatekey.applications.DispositivoApplication;
import br.com.gatekey.entities.Dispositivo;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DispositivoFacade {
    private final DispositivoApplication application;

    public DispositivoFacade(DispositivoApplication application) {
        this.application = application;
    }

    public Dispositivo cadastrarDispositivo(Dispositivo dispositivo) {
        return application.salvar(dispositivo);
    }

    public List<Dispositivo> listarDispositivos() {
        return application.listar();
    }
}
