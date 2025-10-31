package com.project.facades;

import com.project.entities.Usuario;
import com.project.models.FuncionarioModel;
import com.project.models.UsuarioModel;
import com.project.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioFacade {

    private final UsuarioRepository repository;

    public UsuarioFacade(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        return repository.save(usuarioModel);
    }

    public Optional<UsuarioModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<UsuarioModel> listarTodos() {
        return repository.findAll();
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }
}