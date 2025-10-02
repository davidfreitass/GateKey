package br.com.gatekey.facades;

import br.com.gatekey.applications.MoradorApplication;
import br.com.gatekey.entities.Morador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MoradorFacade {

    private final MoradorApplication application;

    public MoradorFacade(MoradorApplication application) {
        this.application = application;
    }

    public Morador salvar(Morador morador) {
        return application.salvar(morador);
    }

    public Optional<Morador> buscarPorId(Integer id) {
        return application.buscarPorId(id);
    }

    public List<Morador> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(Integer id) {
        application.deletar(id);
    }
}
