package com.project.controllers;

import com.project.entities.RegistroAcesso;
import com.project.facades.RegistroAcessoFacade;
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
    public List<RegistroAcesso> listAll() {
        return registroAcessoFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroAcesso> buscar(@PathVariable Integer id) {
        return registroAcessoFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegistroAcesso create(@RequestBody RegistroAcesso registroAcesso) {
        RegistroAcesso saved = registroAcessoFacade.salvar(registroAcesso);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroAcesso> update(@PathVariable Integer id, @RequestBody RegistroAcesso registroAcesso) {
        Optional<RegistroAcesso> existing = registroAcessoFacade.buscarPorId(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        registroAcesso.setId(id);
        RegistroAcesso updated = registroAcessoFacade.salvar(registroAcesso);
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
