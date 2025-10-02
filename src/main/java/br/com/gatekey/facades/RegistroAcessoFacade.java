package br.com.gatekey.facades;

import br.com.gatekey.applications.RegistroAcessoApplication;
import br.com.gatekey.entities.RegistroAcesso;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroAcessoFacade {
    private final RegistroAcessoApplication application;

    public RegistroAcessoFacade(RegistroAcessoApplication application) {
        this.application = application;
    }

    public RegistroAcesso salvar(RegistroAcesso registroAcesso) {
        return application.salvar(registroAcesso);
    }

    public Optional<RegistroAcesso> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<RegistroAcesso> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }

}
