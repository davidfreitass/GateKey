package br.com.gatekey.applications;

import br.com.gatekey.entities.Credencial;
import br.com.gatekey.facades.CredencialFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialApplication {

    private final CredencialFacade facade;

    public CredencialApplication(CredencialFacade facade) {
        this.facade = facade;
    }

    public Credencial salvar(Credencial credencial) {
        return facade.salvar(credencial);
    }

    public Credencial buscarPorId(int id) {
        return facade.buscarPorId(id);
    }

    public List<Credencial> listarTodos() {
        return facade.listarTodos();
    }

    public void deletar(int id) {
        facade.deletar(id);
    }
}
