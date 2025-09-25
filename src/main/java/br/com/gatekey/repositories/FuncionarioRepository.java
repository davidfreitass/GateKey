package br.com.gatekey.repositories;

import br.com.gatekey.entities.Funcionario;

import java.util.List;

public interface FuncionarioRepository {

    void salvar(Funcionario funcionario);
    Funcionario buscarPorId(int id);
    List<Funcionario> buscarTodos();
    void atualizar(Funcionario funcionario);
    void remover(int id);

}