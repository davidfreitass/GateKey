package com.project.controllers;

import com.project.entities.Funcionario;
import com.project.facades.FuncionarioFacade;
import com.project.models.FuncionarioModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioFacade funcionarioFacade;

    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario funcionario) {
        Funcionario saved = funcionarioFacade.salvar(funcionario);
        return saved;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> read(@PathVariable Integer id) {
        return funcionarioFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Funcionario> listAll() {
        return funcionarioFacade.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        Optional<Funcionario> existing = funcionarioFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        funcionario.setId(id);
        Funcionario updated = funcionarioFacade.salvar(funcionario);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (funcionarioFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        funcionarioFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
