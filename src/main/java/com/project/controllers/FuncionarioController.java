package com.project.controllers;

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
    public FuncionarioModel create(@RequestBody FuncionarioModel model) {
        FuncionarioModel saved = funcionarioFacade.salvar(model);
        return saved;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> read(@PathVariable Integer id) {
        return funcionarioFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<FuncionarioModel> listAll() {
        return funcionarioFacade.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> update(@PathVariable Integer id, @RequestBody FuncionarioModel model) {
        Optional<FuncionarioModel> existing = funcionarioFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        FuncionarioModel updated = funcionarioFacade.salvar(model);
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
