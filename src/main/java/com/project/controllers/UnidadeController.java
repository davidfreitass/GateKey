package com.project.controllers;

import com.project.entities.Unidade;
import com.project.facades.UnidadeFacade;
import com.project.models.UnidadeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeFacade unidadeFacade;

    public UnidadeController(UnidadeFacade unidadeFacade) {
        this.unidadeFacade = unidadeFacade;
    }

    @GetMapping
    public List<UnidadeModel> listAll() {
        return unidadeFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeModel> buscar(@PathVariable Integer id) {
        return unidadeFacade.buscarPorId(id)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UnidadeModel create(@RequestBody UnidadeModel model) {
        Unidade unidade = toEntity(model);
        Unidade saved = unidadeFacade.salvar(unidade);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeModel> update(@PathVariable Integer id, @RequestBody UnidadeModel model) {
        if (unidadeFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Unidade unidade = toEntity(model);
        unidade.setId(id);
        Unidade updated = unidadeFacade.salvar(unidade);
        return ResponseEntity.ok(toModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (unidadeFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        unidadeFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private Unidade toEntity(UnidadeModel model) {
        Unidade entity = new Unidade();
        entity.setId(model.getId());
        entity.setNumero(model.getNumero());
        entity.setBloco(model.getBloco());
        entity.setTipo(model.getTipo());
        return entity;
    }

    private UnidadeModel toModel(Unidade entity) {
        UnidadeModel model = new UnidadeModel();
        model.setId(entity.getId());
        model.setNumero(entity.getNumero());
        model.setBloco(entity.getBloco());
        model.setTipo(entity.getTipo());
        return model;
    }
}
