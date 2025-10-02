package br.com.gatekey.controllers;

import br.com.gatekey.entities.Credencial;
import br.com.gatekey.models.CredencialModel;
import br.com.gatekey.applications.CredencialApplication;
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

    @PostMapping
    public CredencialModel create(@RequestBody CredencialModel model) {
        Credencial entity = toEntity(model);
        Credencial saved = application.salvar(entity);
        return toModel(saved);
    }

    @GetMapping("/{id}")
    public CredencialModel read(@PathVariable int id) {
        Credencial entity = application.buscarPorId(id);
        return toModel(entity);
    }

    @GetMapping
    public List<CredencialModel> listAll() {
        return application.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public CredencialModel update(@PathVariable int id, @RequestBody CredencialModel model) {
        Credencial entity = toEntity(model);
        entity.setId(id);
        Credencial updated = application.salvar(entity);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
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
