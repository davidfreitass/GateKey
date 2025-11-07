package com.project.controllers;

import com.project.entities.Dispositivo;
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
    public List<Dispositivo> listAll() {
        return dispositivoFacade.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> buscar(@PathVariable Integer id) {
        return dispositivoFacade.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Dispositivo create(@RequestBody Dispositivo dispositivo) {
        Dispositivo saved = dispositivoFacade.salvar(dispositivo);
        return saved;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> update(@PathVariable Integer id, @RequestBody Dispositivo dispositivo) {
        if (dispositivoFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        dispositivo.setId(id);
        Dispositivo updated = dispositivoFacade.salvar(dispositivo);
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
