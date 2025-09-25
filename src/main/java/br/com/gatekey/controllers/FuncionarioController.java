package br.com.gatekey.controllers;

import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.facades.FuncionarioFacade;
import br.com.gatekey.applications.FuncionarioApplication;
import br.com.gatekey.repositories.FuncionarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioFacade funcionarioFacade;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        FuncionarioApplication funcionarioApplication = new FuncionarioApplication(funcionarioRepository);
        this.funcionarioFacade = new FuncionarioFacade(funcionarioApplication);
    }

    @PostMapping
    public String cadastrar(@RequestBody Funcionario funcionario) {
        funcionarioFacade.cadastrar(funcionario);
        return "Funcionário cadastrado com sucesso!";
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable int id) {
        return funcionarioFacade.buscarPorId(id);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioFacade.listarTodos();
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody Funcionario funcionario) {
        funcionario.setId(id);
        funcionarioFacade.atualizar(funcionario);
        return "Funcionário atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id) {
        funcionarioFacade.remover(id);
        return "Funcionário removido com sucesso!";
    }
}