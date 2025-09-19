package br.com.gatekey.repositories;

import br.com.gatekey.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {

    void salvar(Usuario usuario);
    Usuario buscarPorId(int id);
    List<Usuario> buscarTodos();
    void atualizar(Usuario usuario);
    void remover(int id);

}