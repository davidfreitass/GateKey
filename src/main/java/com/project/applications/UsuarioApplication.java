package com.project.applications;

import com.project.entities.Usuario;
import com.project.models.UsuarioModel;
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

    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        return repository.save(usuarioModel);
    }

    public List<UsuarioModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}