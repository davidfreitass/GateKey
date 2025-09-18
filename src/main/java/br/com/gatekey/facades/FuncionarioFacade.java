package br.com.gatekey.facades;

import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.entities.Status;
import br.com.gatekey.repositories.FuncionarioRepository;
import java.util.List;

public class FuncionarioFacade {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioFacade() {
        this.funcionarioRepository = new FuncionarioRepository();
    }

    public void registrarFuncionario(Funcionario funcionario) {
        funcionarioRepository.salvar(funcionario);
    }

    public Funcionario buscarPorCpf(String cpf) {
        return funcionarioRepository.buscarPorCpf(cpf);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.listarTodos();
    }

    public boolean isAtivo(Funcionario funcionario) {
        return funcionario.getStatus() == Status.ATIVO;
    }
}