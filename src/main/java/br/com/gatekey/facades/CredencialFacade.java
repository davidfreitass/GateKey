package br.com.gatekey.facades;

import br.com.gatekey.applications.CredencialApplication;
import br.com.gatekey.entities.Credencial;

import java.util.List;

public class CredencialFacade {

    private final CredencialApplication application;

    public CredencialFacade(CredencialApplication application) {
        this.application = application;
    }

    public Credencial salvar(Credencial credencial) {
        return application.salvar(credencial);
    }

    public Credencial buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Credencial> listarTodos() {
        return application.listarTodos();
    }

    public void deletar(int id) {
        application.deletar(id);
    }
}
