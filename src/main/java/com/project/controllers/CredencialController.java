package com.project.controllers;

import com.project.entities.Credencial;
import com.project.applications.CredencialApplication;
import com.project.models.CredencialModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
    public CredencialModel buscar(@PathVariable Integer id) {
        Optional<Credencial> credencialOpt = application.buscarPorId(id);
        return credencialOpt.map(this::toModel)
                .orElseThrow(() -> new RuntimeException("Credencial não encontrada com id: " + id));
    }

    @PostMapping
    public CredencialModel create(@RequestBody CredencialModel model) {
        Credencial credencial = toEntity(model);
        Credencial saved = application.salvar(credencial);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public CredencialModel update(@PathVariable Integer id, @RequestBody CredencialModel model) {
        Credencial credencial = toEntity(model);
        credencial.setId(id);
        Credencial updated = application.salvar(credencial);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        application.deletar(id);
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
