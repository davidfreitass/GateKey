package com.project.controllers;

import com.project.entities.Usuario;
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
    public Usuario create(@RequestBody Usuario usuario) {
        Usuario saved = usuarioFacade.salvar(usuario);
        return saved;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> read(@PathVariable Integer id) {
        return usuarioFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Usuario> listAll() {
        return usuarioFacade.listarTodos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> existing = usuarioFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuario.setId(id);
        Usuario updated = usuarioFacade.salvar(usuario);
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
