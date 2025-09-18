package br.com.gatekey.facades;

import br.com.gatekey.applications.RegistroAcessoApplication;
import br.com.gatekey.entities.RegistroAcesso;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegistroAcessoFacade {
    private final RegistroAcessoApplication application;

    public RegistroAcessoFacade(RegistroAcessoApplication application) {
        this.application = application;
    }

    public RegistroAcesso registrarAcesso(RegistroAcesso registro) {
        return application.salvar(registro);
    }

    public List<RegistroAcesso> listarAcessos() {
        return application.listar();
    }
}
