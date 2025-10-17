package com.project.applications;

import com.project.entities.Usuario;
import com.project.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioApplication {

    private final UsuarioRepository repository;

    public UsuarioApplication(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}