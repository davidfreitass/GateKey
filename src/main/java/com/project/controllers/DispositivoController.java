package com.project.controllers;

import com.project.facades.DispositivoFacade;
import com.project.models.DispositivoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoFacade dispositivoFacade;

    public DispositivoController(DispositivoFacade dispositivoFacade) {
        this.dispositivoFacade = dispositivoFacade;

    }

    @GetMapping
    public List<DispositivoModel> listAll() {
        return dispositivoFacade.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DispositivoModel> buscar(@PathVariable Integer id) {
        return dispositivoFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public DispositivoModel create(@RequestBody DispositivoModel model) {
        DispositivoModel saved = dispositivoFacade.salvar(model);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoModel> update(@PathVariable Integer id, @RequestBody DispositivoModel model) {
        if (dispositivoFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        model.setId(id);
        DispositivoModel updated = dispositivoFacade.salvar(model);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (dispositivoFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        dispositivoFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
