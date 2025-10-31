package com.project.controllers;

import com.project.facades.UsuarioFacade;
import com.project.models.UsuarioModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @PostMapping
    public UsuarioModel create(@RequestBody UsuarioModel model) {
        UsuarioModel saved = usuarioFacade.salvar(model);
        return saved;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> read(@PathVariable Integer id) {
        return usuarioFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UsuarioModel> listAll() {
        return usuarioFacade.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> update(@PathVariable Integer id, @RequestBody UsuarioModel model) {
        Optional<UsuarioModel> existing = usuarioFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        UsuarioModel updated = usuarioFacade.salvar(model);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (usuarioFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarioFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
