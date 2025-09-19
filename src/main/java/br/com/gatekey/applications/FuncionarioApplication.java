package br.com.gatekey.applications;

import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.repositories.FuncionarioRepository;

import java.util.List;

public class FuncionarioApplication {
    private final FuncionarioRepository repository;

    public FuncionarioApplication(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Funcionario funcionario) {
        repository.salvar(funcionario);
    }

    public Funcionario buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Funcionario> listarTodos() {
        return repository.buscarTodos();
    }

    public void atualizar(Funcionario funcionario) {
        repository.atualizar(funcionario);
    }

    public void remover(int id) {
        repository.remover(id);
    }
}