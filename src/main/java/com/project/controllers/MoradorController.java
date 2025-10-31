package com.project.controllers;

import com.project.facades.MoradorFacade;
import com.project.models.MoradorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorFacade moradorFacade;

    public MoradorController(MoradorFacade moradorFacade) {
        this.moradorFacade = moradorFacade;
    }

    @GetMapping
    public List<MoradorModel> listAll() {
        return moradorFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorModel> buscar(@PathVariable Integer id) {
        return moradorFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorModel create(@RequestBody MoradorModel model) {
        MoradorModel saved = moradorFacade.salvar(model);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorModel> update(@PathVariable Integer id, @RequestBody MoradorModel model) {
        Optional<MoradorModel> existing = moradorFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        MoradorModel updated = moradorFacade.salvar(model);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (moradorFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        moradorFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
