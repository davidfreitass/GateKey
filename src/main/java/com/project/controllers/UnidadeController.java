package com.project.controllers;

import com.project.facades.UnidadeFacade;
import com.project.models.UnidadeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeFacade unidadeFacade;

    public UnidadeController(UnidadeFacade unidadeFacade) {
        this.unidadeFacade = unidadeFacade;
    }

    @GetMapping
    public List<UnidadeModel> listAll() {
        return unidadeFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeModel> buscar(@PathVariable Integer id) {
        return unidadeFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UnidadeModel create(@RequestBody UnidadeModel model) {
        UnidadeModel saved = unidadeFacade.salvar(model);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeModel> update(@PathVariable Integer id, @RequestBody UnidadeModel model) {
        Optional<UnidadeModel> existing = unidadeFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        UnidadeModel updated = unidadeFacade.salvar(model);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (unidadeFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        unidadeFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
