package com.project.controllers;

import com.project.entities.MoradorUnidade;
import com.project.facades.MoradorUnidadeFacade;
import com.project.models.MoradorUnidadeModel;
import com.project.models.MoradorModel;
import com.project.models.UnidadeModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/morador-unidade")
public class MoradorUnidadeController {

    private final MoradorUnidadeFacade facade;

    public MoradorUnidadeController(MoradorUnidadeFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public List<MoradorUnidadeModel> listAll() {
        return facade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorUnidadeModel> buscarPorId(@PathVariable Long id) {
        return facade.buscarPorId(id)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/detalhe/{moradorId}/{unidadeId}")
    public ResponseEntity<MoradorUnidadeModel> buscarPorIdsLogicos(
            @PathVariable Integer moradorId,
            @PathVariable Integer unidadeId) {

        return facade.buscarPorIdsMoradorUnidade(moradorId, unidadeId)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MoradorUnidadeModel create(@RequestBody MoradorUnidadeModel model) {
        MoradorUnidade entity = toEntity(model);
        MoradorUnidade saved = facade.salvar(entity);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorUnidadeModel> update(@PathVariable Long id,
                                                      @RequestBody MoradorUnidadeModel model) {
        if (facade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        MoradorUnidade entity = toEntity(model);
        entity.setId(id);
        MoradorUnidade updated = facade.salvar(entity);
        return ResponseEntity.ok(toModel(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorId(@PathVariable Long id) {
        if (facade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        facade.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/detalhe/{moradorId}/{unidadeId}")
    public ResponseEntity<Void> deletePorIdsLogicos(@PathVariable Integer moradorId,
                                                    @PathVariable Integer unidadeId) {
        if (facade.deletarPorIdsMoradorUnidade(moradorId, unidadeId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private MoradorUnidade toEntity(MoradorUnidadeModel model) {
        MoradorUnidade entity = new MoradorUnidade();
        if (model.getId() != null) entity.setId(model.getId());
        if (model.getMorador() != null) entity.setIdMorador(model.getMorador().getId());
        if (model.getUnidade() != null) entity.setIdUnidade(model.getUnidade().getId());
        return entity;
    }

    private MoradorUnidadeModel toModel(MoradorUnidade entity) {
        MoradorModel morador = new MoradorModel();
        morador.setId(entity.getIdMorador());

        UnidadeModel unidade = new UnidadeModel();
        unidade.setId(entity.getIdUnidade());

        MoradorUnidadeModel model = new MoradorUnidadeModel();

        model.setMorador(morador);
        model.setUnidade(unidade);
        model.setIdMorador(entity.getIdMorador());
        model.setIdUnidade(entity.getIdUnidade());
        model.setId(entity.getId());

        return model;
    }
}
