package com.project.controllers;

import com.project.entities.MoradorUnidade;
import com.project.facades.MoradorUnidadeFacade;
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

    @GetMapping("/detalhe/{moradorId}/{unidadeId}")
    public ResponseEntity<MoradorUnidade> buscarPorIdsLogicos(
            @PathVariable Integer moradorId,
            @PathVariable Integer unidadeId) {

        return facade.buscarPorIdsMoradorUnidade(moradorId, unidadeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorUnidade create(@RequestBody MoradorUnidade moradorUnidade) {
        return facade.salvar(moradorUnidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorId(@PathVariable Long id) {
        if (facade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        facade.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/detalhe/{moradorId}/{unidadeId}")
    public ResponseEntity<Void> deletePorIdsLogicos(
            @PathVariable Integer moradorId,
            @PathVariable Integer unidadeId) {
        if (facade.deletarPorIdsMoradorUnidade(moradorId, unidadeId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}