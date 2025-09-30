package br.com.gatekey.controllers;

import br.com.gatekey.entities.Dispositivo;
import br.com.gatekey.facades.DispositivoFacade;
import br.com.gatekey.models.DispositivoModel;
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
    public DispositivoModel buscar(@PathVariable int id) {
        Dispositivo dispositivo = dispositivoFacade.buscarPorId(id);
        return toModel(dispositivo);
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
        dispositivo.setTipo(model.getTipo());
        return dispositivo;
    }

    private DispositivoModel toModel(Dispositivo dispositivo) {
        DispositivoModel model = new DispositivoModel();
        model.setId(dispositivo.getId());
        model.setTipo(dispositivo.getTipo());
        model.setLocalizacao(dispositivo.getLocalizacao());
        model.setTipo(model.getTipo());
        return model;
    }
}