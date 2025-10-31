package com.project.applications;

import com.project.entities.Funcionario;
import com.project.models.FuncionarioModel;
import com.project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioApplication {

    private final FuncionarioRepository repository;

    public FuncionarioApplication(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public FuncionarioModel salvar(FuncionarioModel funcionarioModel) {
        return repository.save(funcionarioModel);
    }

    public List<FuncionarioModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<FuncionarioModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}