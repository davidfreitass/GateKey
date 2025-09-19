package br.com.gatekey.applications;

import br.com.gatekey.entities.Usuario;
import br.com.gatekey.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioApplication {
    private final UsuarioRepository repository;

    public UsuarioApplication(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Usuario usuario) {
        repository.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return repository.buscarTodos();
    }

    public void atualizar(Usuario usuario) {
        repository.atualizar(usuario);
    }

    public void remover(int id) {
        repository.remover(id);
    }
}