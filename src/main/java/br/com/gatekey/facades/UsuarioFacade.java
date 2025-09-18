package br.com.gatekey.facades;

import br.com.gatekey.entities.Usuario;
import br.com.gatekey.repositories.UsuarioRepository;

public class UsuarioFacade {
    private UsuarioRepository usuarioRepository;

    public UsuarioFacade() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.salvar(usuario);
    }

    public Usuario login(String login, String senha) {
        Usuario usuario = usuarioRepository.buscarPorLogin(login);
        if (usuario != null && usuario.getSenha().equals(senha) && usuario.getStatus().toString().equals("ATIVO")) {
            return usuario;
        }
        return null;
    }
}
