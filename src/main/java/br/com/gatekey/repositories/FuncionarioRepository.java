package br.com.gatekey.repositories;

import br.com.gatekey.entities.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void salvar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equalsIgnoreCase(cpf)) {
                return f;
            }
        }
        return null;
    }

    public List<Funcionario> listarTodos() {
        return funcionarios;
    }
}
