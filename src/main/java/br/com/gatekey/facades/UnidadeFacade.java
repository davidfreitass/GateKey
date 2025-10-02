package br.com.gatekey.facades;

import br.com.gatekey.application.UnidadeApplication;
import br.com.gatekey.entities.Unidade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeFacade {

    private final UnidadeApplication application;

    public UnidadeFacade(UnidadeApplication application) {
        this.application = application;
    }

    public Unidade salvar(Unidade unidade) {
        return application.salvar(unidade);
    }

    public Unidade buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Unidade> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}
