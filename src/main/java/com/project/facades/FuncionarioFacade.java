package com.project.facades;

import com.project.applications.FuncionarioApplication;
import com.project.entities.Funcionario;
import com.project.models.FuncionarioModel;
import com.project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioFacade {

    private final FuncionarioApplication funcionarioApplication;

    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioApplication.salvar(funcionario);
    }

    public Optional<Funcionario> buscarPorId(Integer id) {
        return funcionarioApplication.buscarPorId(id);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioApplication.listarTodos();
    }

    public void deletar(Integer id) {
        funcionarioApplication.deletar(id);
    }
}
