package br.com.gatekey.facades;

import br.com.gatekey.applications.MoradorApplication;
import br.com.gatekey.applications.UsuarioApplication;
import br.com.gatekey.entities.Morador;
import br.com.gatekey.entities.Usuario;
import br.com.gatekey.repositories.MoradorRepository;

import java.util.List;

public class UsuarioFacade {

    private final UsuarioApplication application;

    public UsuarioFacade(UsuarioApplication application) {
        this.application = application;
    }

    public void cadastrar(Usuario usuario) {
        application.cadastrar(usuario);
    }

    public Usuario buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return application.listarTodos();
    }

    public void atualizar(Usuario usuario) {
        application.atualizar(usuario);
    }

    public void remover(int id) {
        application.remover(id);
    }
}