package com.project.controllers;

import com.project.entities.Credencial;
import com.project.applications.CredencialApplication;
import com.project.models.CredencialModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

    private final CredencialApplication application;

    public CredencialController(CredencialApplication application) {
        this.application = application;
    }

    @GetMapping
    public List<CredencialModel> listAll() {
        return application.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CredencialModel> buscar(@PathVariable Integer id) {
        return application.buscarPorId(id)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CredencialModel create(@RequestBody CredencialModel model) {
        Credencial credencial = toEntity(model);
        Credencial saved = application.salvar(credencial);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CredencialModel> update(@PathVariable Integer id, @RequestBody CredencialModel model) {
        if (application.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Credencial credencial = toEntity(model);
        credencial.setId(id);
        Credencial updated = application.salvar(credencial);
        return ResponseEntity.ok(toModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (application.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        application.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private Credencial toEntity(CredencialModel model) {
        Credencial entity = new Credencial();
        entity.setId(model.getId());
        entity.setTipo(model.getTipo());
        entity.setDadosBiometricos(model.getDadosBiometricos());
        return entity;
    }

    private CredencialModel toModel(Credencial entity) {
        CredencialModel model = new CredencialModel();
        model.setId(entity.getId());
        model.setTipo(entity.getTipo());
        model.setDadosBiometricos(entity.getDadosBiometricos());
        return model;
    }
}