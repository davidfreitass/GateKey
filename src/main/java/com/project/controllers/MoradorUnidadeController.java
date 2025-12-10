package com.project.controllers;

import com.project.entities.MoradorUnidade;
import com.project.facades.MoradorUnidadeFacade;
import com.project.models.MoradorUnidadeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/morador-unidade")
public class MoradorUnidadeController {

    private final MoradorUnidadeFacade facade;

    public MoradorUnidadeController(MoradorUnidadeFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<MoradorUnidade> listAll() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorUnidade> buscarPorId(@PathVariable Long id) {
        return facade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorUnidade create(@RequestBody MoradorUnidade moradorUnidade) {
        MoradorUnidade saved = facade.salvar(moradorUnidade);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorUnidade> update(@PathVariable Long id,
                                                      @RequestBody MoradorUnidade moradorUnidade) {
        if (facade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        moradorUnidade.setId(id);

        MoradorUnidade updated = facade.salvar(moradorUnidade);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorId(@PathVariable Long id) {
        if (facade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        facade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}