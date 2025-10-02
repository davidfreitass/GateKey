package br.com.gatekey.applications;

import br.com.gatekey.entities.Usuario;
import br.com.gatekey.facades.UsuarioFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioApplication {

    private final UsuarioFacade usuarioFacade;

    public UsuarioApplication(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioFacade.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarioFacade.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioFacade.listarTodos();
    }

    public void deletar(int id) {
        usuarioFacade.deletar(id);
    }
}