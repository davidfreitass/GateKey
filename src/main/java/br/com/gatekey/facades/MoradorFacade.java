package br.com.gatekey.facades;

import br.com.gatekey.applications.MoradorApplication;
import br.com.gatekey.entities.Morador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoradorFacade {

    private final MoradorApplication application;

    public MoradorFacade(MoradorApplication application) {
        this.application = application;
    }

    public Morador cadastrar(Morador morador) {
        application.cadastrar(morador);
        return morador;
    }

    public Morador buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Morador> listarTodos() {
        return application.listarTodos();
    }

    public Morador atualizar(Morador morador) {
        application.atualizar(morador);
        return morador;
    }

    public void remover(int id) {
        application.remover(id);
    }
}
