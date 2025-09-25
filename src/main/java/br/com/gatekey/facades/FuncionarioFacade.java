package br.com.gatekey.facades;

import br.com.gatekey.applications.FuncionarioApplication;
import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.repositories.FuncionarioRepository;

import java.util.List;

public class FuncionarioFacade {

    private final FuncionarioApplication application;

    public FuncionarioFacade(FuncionarioApplication application) {
        this.application = application;
    }

    public void cadastrar(Funcionario funcionario) {
        application.cadastrar(funcionario);
    }

    public Funcionario buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public List<Funcionario> listarTodos() {
        return application.listarTodos();
    }

    public void atualizar(Funcionario funcionario) {
        application.atualizar(funcionario);
    }

    public void remover(int id) {
        application.remover(id);
    }
}