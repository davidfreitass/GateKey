package br.com.gatekey.applications;

import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.entities.Status;
import br.com.gatekey.facades.FuncionarioFacade;

public class FuncionarioApplication {
    public static void main(String[] args) {
        FuncionarioFacade facade = new FuncionarioFacade();

        Funcionario funcionario = new Funcionario(
                1,
                "Jefté",
                "123.456.789-00",
                "(75) 94002-8922",
                "jefte@ba.docente.senai.br",
                null,
                Status.ATIVO
        );

        facade.registrarFuncionario(funcionario);

        Funcionario f = facade.buscarPorCpf("123.456.789-00");
        if (f != null && facade.isAtivo(f)) {
            System.out.println("Funcionário encontrado: " + f.getNome());
        } else {
            System.out.println("Funcionário não encontrado ou inativo!");
        }
    }
}
