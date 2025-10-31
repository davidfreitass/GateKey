package com.project.controllers;

import com.project.facades.RegistroAcessoFacade;
import com.project.models.RegistroAcessoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros-acesso")
public class RegistroAcessoController {

    private final RegistroAcessoFacade registroAcessoFacade;

    public RegistroAcessoController(RegistroAcessoFacade registroAcessoFacade) {
        this.registroAcessoFacade = registroAcessoFacade;
    }

    @GetMapping
    public List<RegistroAcessoModel> listAll() {
        return registroAcessoFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroAcessoModel> buscar(@PathVariable Integer id) {
        return registroAcessoFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegistroAcessoModel create(@RequestBody RegistroAcessoModel model) {
        RegistroAcessoModel saved = registroAcessoFacade.salvar(model);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroAcessoModel> update(@PathVariable Integer id, @RequestBody RegistroAcessoModel model) {
        Optional<RegistroAcessoModel> existing = registroAcessoFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        RegistroAcessoModel updated = registroAcessoFacade.salvar(model);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (registroAcessoFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        registroAcessoFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
