package com.project.controllers;

import com.project.entities.Unidade;
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
    public List<Unidade> listAll() {
        return unidadeFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscar(@PathVariable Integer id) {
        return unidadeFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Unidade create(@RequestBody Unidade unidade) {
        Unidade saved = unidadeFacade.salvar(unidade);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> update(@PathVariable Integer id, @RequestBody Unidade unidade) {
        Optional<Unidade> existing = unidadeFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        unidade.setId(id);
        Unidade updated = unidadeFacade.salvar(unidade);
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
