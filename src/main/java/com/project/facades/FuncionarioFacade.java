package com.project.facades;

import com.project.entities.Funcionario;
import com.project.models.FuncionarioModel;
import com.project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioFacade {

    private final FuncionarioRepository repository;

    public FuncionarioFacade(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public FuncionarioModel salvar(FuncionarioModel funcionarioModel) {
        return repository.save(funcionarioModel);
    }

    public Optional<FuncionarioModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public List<FuncionarioModel> listarTodos() {
        return repository.findAll();
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
