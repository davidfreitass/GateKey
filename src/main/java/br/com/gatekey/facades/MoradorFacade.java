package br.com.gatekey.facades;

import br.com.gatekey.applications.MoradorApplication;
import br.com.gatekey.entities.Morador;
import br.com.gatekey.repositories.MoradorRepository;

import java.util.List;

public class MoradorFacade {

    private final MoradorApplication application;

    public MoradorFacade(MoradorApplication application) {
        this.application = application;
    }

    public void cadastrar(Morador morador) {
        application.cadastrar(morador);
    }

    public Morador buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Morador> listarTodos() {
        return application.listarTodos();
    }

    public void atualizar(Morador morador) {
        application.atualizar(morador);
    }

    public void remover(int id) {
        application.remover(id);
    }
}
