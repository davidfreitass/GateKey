package com.project.controllers;

import com.project.entities.Morador;
import com.project.facades.MoradorFacade;
import com.project.models.MoradorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorFacade moradorFacade;

    public MoradorController(MoradorFacade moradorFacade) {
        this.moradorFacade = moradorFacade;
    }

    @GetMapping
    public List<MoradorModel> listAll() {
        return moradorFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorModel> buscar(@PathVariable Integer id) {
        return moradorFacade.buscarPorId(id)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorModel create(@RequestBody MoradorModel model) {
        Morador entity = toEntity(model);
        Morador saved = moradorFacade.salvar(entity);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorModel> update(@PathVariable Integer id, @RequestBody MoradorModel model) {
        if (moradorFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Morador entity = toEntity(model);
        entity.setId(id);
        Morador updated = moradorFacade.salvar(entity);
        return ResponseEntity.ok(toModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (moradorFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        moradorFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private MoradorModel toModel(Morador entity) {
        MoradorModel model = new MoradorModel();
        model.setId(entity.getId());
        model.setNome(entity.getNome());
        model.setCpf(entity.getCpf());
        model.setTelefone(entity.getTelefone());
        model.setEmail(entity.getEmail());
        model.setFotoPerfil(entity.getFotoPerfil());
        model.setStatus(entity.getStatus());
        return model;
    }

    private Morador toEntity(MoradorModel model) {
        Morador entity = new Morador();
        entity.setId(model.getId());
        entity.setNome(model.getNome());
        entity.setCpf(model.getCpf());
        entity.setTelefone(model.getTelefone());
        entity.setEmail(model.getEmail());
        entity.setFotoPerfil(model.getFotoPerfil());
        entity.setStatus(model.getStatus());
        return entity;
    }
}
