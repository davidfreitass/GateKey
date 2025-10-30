package com.project.controllers;

import com.project.entities.MoradorUnidade;
import com.project.entities.MoradorUnidadeId;
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

    @GetMapping("/{moradorId}/{unidadeId}")
    public ResponseEntity<MoradorUnidade> buscar(@PathVariable Integer moradorId, @PathVariable Integer unidadeId) {
        MoradorUnidadeId id = new MoradorUnidadeId(moradorId, unidadeId);
        return facade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorUnidade create(@RequestBody MoradorUnidade moradorUnidade) {
        return facade.salvar(moradorUnidade);
    }

    @DeleteMapping("/{moradorId}/{unidadeId}")
    public ResponseEntity<Void> delete(@PathVariable Integer moradorId, @PathVariable Integer unidadeId) {
        MoradorUnidadeId id = new MoradorUnidadeId(moradorId, unidadeId);
        if (facade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        facade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
