package br.com.gatekey.repositories;

import br.com.gatekey.entities.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public void salvar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarPorLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equalsIgnoreCase(login)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }
}