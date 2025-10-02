package br.com.gatekey.controllers;

import br.com.gatekey.entities.Unidade;
import br.com.gatekey.facades.UnidadeFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeFacade unidadeFacade;

    public UnidadeController(UnidadeFacade unidadeFacade) {
        this.unidadeFacade = unidadeFacade;
    }

    @GetMapping
    public List<Unidade> listAll() {
        return unidadeFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscar(@PathVariable Integer id) {
        Optional<Unidade> unidade = unidadeFacade.buscarPorId(id);
        return unidade.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Unidade create(@RequestBody Unidade unidade) {
        return unidadeFacade.salvar(unidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> update(@PathVariable Integer id, @RequestBody Unidade unidade) {
        if (unidadeFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        unidade.setId(id);
        return ResponseEntity.ok(unidadeFacade.salvar(unidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (unidadeFacade.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        unidadeFacade.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
