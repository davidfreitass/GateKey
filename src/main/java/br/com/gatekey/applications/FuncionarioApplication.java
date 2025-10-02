package br.com.gatekey.applications;

import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.facades.FuncionarioFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionarioApplication {

    private final FuncionarioFacade funcionarioFacade;

    public FuncionarioApplication(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioFacade.salvar(funcionario);
    }

    public Funcionario buscarPorId(int id) {
        return funcionarioFacade.buscarPorId(id);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioFacade.listarTodos();
    }

    public void deletar(int id) {
        funcionarioFacade.deletar(id);
    }
}