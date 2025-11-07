package com.project.controllers;

import com.project.entities.Credencial;
import com.project.facades.CredencialFacade;
import com.project.models.CredencialModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

    private final CredencialFacade credencialFacade;

    public CredencialController(CredencialFacade credencialFacade) {
        this.credencialFacade = credencialFacade;
    }

    @GetMapping
    public List<Credencial> listAll() {
        return credencialFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credencial> buscar(@PathVariable Integer id) {
        return credencialFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Credencial create(@RequestBody Credencial credencial) {
        Credencial saved = credencialFacade.salvar(credencial);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credencial> update(@PathVariable Integer id, @RequestBody Credencial credencial) {
        if (credencialFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        credencial.setId(id);
        Credencial updated = credencialFacade.salvar(credencial);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (credencialFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        credencialFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
