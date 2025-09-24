package br.com.gatekey.controllers;

import br.com.gatekey.entities.Funcionario;
import br.com.gatekey.facades.FuncionarioFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioFacade facade;

    public FuncionarioController(FuncionarioFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public void cadastrar(@RequestBody Funcionario funcionario) {
        facade.cadastrar(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return facade.listarTodos();
    }

    @PostMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Funcionario funcionario) {
        funcionario.setId(id);
        facade.atualizar(funcionario);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        facade.remover(id);
    }


}
