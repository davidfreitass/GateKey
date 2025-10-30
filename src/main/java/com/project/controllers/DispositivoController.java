package com.project.controllers;

import com.project.entities.Dispositivo;
import com.project.facades.DispositivoFacade;
import com.project.models.DispositivoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoFacade dispositivoFacade;

    public DispositivoController(DispositivoFacade dispositivoFacade) {
        this.dispositivoFacade = dispositivoFacade;

    }

    @GetMapping
    public List<DispositivoModel> listAll() {
        return dispositivoFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }




    @GetMapping("/{id}")
    public ResponseEntity<DispositivoModel> buscar(@PathVariable Integer id) {
        return dispositivoFacade.buscarPorId(id)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


        @PostMapping
    public DispositivoModel create(@RequestBody DispositivoModel model) {
        Dispositivo dispositivo = toEntity(model);
        Dispositivo saved = dispositivoFacade.salvar(dispositivo);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public DispositivoModel update(@PathVariable int id, @RequestBody DispositivoModel model) {
        Dispositivo dispositivo = toEntity(model);
        dispositivo.setId(id);
        Dispositivo updated = dispositivoFacade.salvar(dispositivo);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dispositivoFacade.deletar(id);
    }

    private Dispositivo toEntity(DispositivoModel model) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setId(model.getId());
        dispositivo.setTipo(model.getTipo());
        dispositivo.setLocalizacao(model.getLocalizacao());
        return dispositivo;
    }


    private DispositivoModel toModel(Dispositivo dispositivo) {
        DispositivoModel model = new DispositivoModel();
        model.setId(dispositivo.getId());
        model.setTipo(dispositivo.getTipo());
        model.setLocalizacao(dispositivo.getLocalizacao());
        return model;
    }
}