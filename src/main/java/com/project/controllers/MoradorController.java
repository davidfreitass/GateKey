package com.project.controllers;

import com.project.entities.Morador;
import com.project.facades.MoradorFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorFacade moradorFacade;

    public MoradorController(MoradorFacade moradorFacade) {
        this.moradorFacade = moradorFacade;
    }

    @GetMapping
    public List<Morador> listAll() {
        return moradorFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> buscar(@PathVariable Integer id) {
        return moradorFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Morador create(@RequestBody Morador morador) {
        return moradorFacade.salvar(morador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Morador> update(@PathVariable Integer id, @RequestBody Morador morador) {
        if (moradorFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        morador.setId(id);
        return ResponseEntity.ok(moradorFacade.salvar(morador));
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

