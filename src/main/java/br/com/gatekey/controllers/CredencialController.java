package br.com.gatekey.controllers;

import br.com.gatekey.entities.Credencial;
import br.com.gatekey.facades.CredencialFacade;
import br.com.gatekey.models.CredencialModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

    private final CredencialFacade credencialFacade;

    public CredencialController(CredencialFacade credencialFacade) {
        this.credencialFacade = credencialFacade;
    }

    @PostMapping
    public CredencialModel create(@RequestBody CredencialModel model) {
        Credencial credencial = toEntity(model);
        Credencial saved = credencialFacade.salvar(credencial);
        return toModel(saved);
    }

    @GetMapping("/{id}")
    public CredencialModel read(@PathVariable int id) {
        Credencial credencial = credencialFacade.buscarPorId(id);
        return toModel(credencial);
    }

    @GetMapping
    public List<CredencialModel> listAll() {
        return credencialFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public CredencialModel update(@PathVariable int id, @RequestBody CredencialModel model) {
        Credencial credencial = toEntity(model);
        credencial.setId(id);
        Credencial updated = credencialFacade.salvar(credencial);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        credencialFacade.deletar(id);
    }

    private Credencial toEntity(CredencialModel model) {
        Credencial credencial = new Credencial();
        credencial.setId(model.getId());
        credencial.setTipo(model.getTipo());
        credencial.setDadosBiometricos(model.getDadosBiometricos());
        return credencial;
    }

    private CredencialModel toModel(Credencial credencial) {
        CredencialModel model = new CredencialModel();
        model.setId(credencial.getId());
        model.setTipo(credencial.getTipo());
        model.setDadosBiometricos(credencial.getDadosBiometricos());
        return model;
    }
}
