package br.com.gatekey.facades;

import br.com.gatekey.applications.UnidadeApplication;
import br.com.gatekey.entities.Unidade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeFacade {

    private final UnidadeApplication application;

    public UnidadeFacade(UnidadeApplication application) {
        this.application = application;
    }

    public Unidade salvar(Unidade unidade) {
        return application.salvar(unidade);
    }

    public Optional<Unidade> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Unidade> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}
