package com.project.controllers;

import com.project.applications.CredencialApplication;
import com.project.models.CredencialModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

    private final CredencialApplication application;

    public CredencialController(CredencialApplication application) {
        this.application = application;
    }

    @GetMapping
    public List<CredencialModel> listAll() {
        return application.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CredencialModel> buscar(@PathVariable Integer id) {
        return application.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CredencialModel create(@RequestBody CredencialModel model) {
        CredencialModel saved = application.salvar(model);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CredencialModel> update(@PathVariable Integer id, @RequestBody CredencialModel model) {
        if (application.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        CredencialModel updated = application.salvar(model);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (application.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        application.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
