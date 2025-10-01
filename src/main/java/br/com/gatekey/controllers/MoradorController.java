package br.com.gatekey.controllers;

import br.com.gatekey.entities.Morador;
import br.com.gatekey.facades.MoradorFacade;
import org.springframework.stereotype.Service;
import br.com.gatekey.models.MoradorModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorFacade moradorFacade;

    public MoradorController(MoradorFacade moradorFacade) {
        this.moradorFacade = moradorFacade;
    }

    @GetMapping
    public List<MoradorModel> listAll() {
        return moradorFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MoradorModel buscar(@PathVariable int id) {
        Morador morador = moradorFacade.buscarPorId(id);
        return toModel(morador);
    }

    @PostMapping
    public MoradorModel create(@RequestBody MoradorModel model) {
        Morador morador = toEntity(model);
        Morador saved = moradorFacade.salvar(morador);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public MoradorModel update(@PathVariable int id, @RequestBody MoradorModel model) {
        Morador morador = toEntity(model);
        morador.setId(id);
        Morador updated = moradorFacade.salvar(morador);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        moradorFacade.deletar(id);
    }

    private Morador toEntity(MoradorModel model) {
        Morador morador = new Morador();
        morador.setId(model.getId());
        morador.setNome(model.getNome());
        morador.setCpf(model.getCpf());
        morador.setTelefone(model.getTelefone());
        morador.setApartamento(model.getApartamento());
        return morador;
    }

    private MoradorModel toModel(Morador morador) {
        MoradorModel model = new MoradorModel();
        model.setId(morador.getId());
        model.setNome(morador.getNome());
        model.setCpf(morador.getCpf());
        model.setTelefone(morador.getTelefone());
        model.setApartamento(morador.getApartamento());
        return model;
    }
}
