package br.com.gatekey.facades;

import br.com.gatekey.applications.CredencialApplication;
import br.com.gatekey.applications.RegistroAcessoApplication;
import br.com.gatekey.entities.Credencial;
import br.com.gatekey.entities.RegistroAcesso;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RegistroAcessoFacade {
    private final RegistroAcessoApplication application;

    public RegistroAcessoFacade(RegistroAcessoApplication application) {
        this.application = application;
    }

    public RegistroAcesso salvar(RegistroAcesso registroAcesso) {
        return application.salvar(registroAcesso);
    }

    public RegistroAcesso buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<RegistroAcesso> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}
