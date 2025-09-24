package br.com.gatekey.controllers;

import br.com.gatekey.entities.Unidade;
import br.com.gatekey.facades.UnidadeFacade;
import br.com.gatekey.models.UnidadeModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeFacade unidadeFacade;

    public UnidadeController(UnidadeFacade unidadeFacade) {
        this.unidadeFacade = unidadeFacade;
    }

    @PostMapping
    public UnidadeModel create(@RequestBody UnidadeModel model) {
        Unidade unidade = toEntity(model);
        Unidade saved = unidadeFacade.salvar(unidade);
        return toModel(saved);
    }

    @GetMapping("/{id}")
    public UnidadeModel read(@PathVariable int id) {
        Unidade unidade = unidadeFacade.buscarPorId(id);
        return toModel(unidade);
    }

    @GetMapping
    public List<UnidadeModel> listAll() {
        return unidadeFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public UnidadeModel update(@PathVariable int id, @RequestBody UnidadeModel model) {
        Unidade unidade = toEntity(model);
        unidade.setId(id);
        Unidade updated = unidadeFacade.salvar(unidade);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        unidadeFacade.deletar(id);
    }

    private Unidade toEntity(UnidadeModel model) {
        Unidade unidade = new Unidade();
        unidade.setId(model.getId());
        unidade.setNumero(model.getNumero());
        unidade.setBloco(model.getBloco());
        unidade.setTipo(model.getTipo());
        return unidade;
    }

    private UnidadeModel toModel(Unidade unidade) {
        UnidadeModel model = new UnidadeModel();
        model.setId(unidade.getId());
        model.setNumero(unidade.getNumero());
        model.setBloco(unidade.getBloco());
        model.setTipo(unidade.getTipo());
        return model;
    }
}
