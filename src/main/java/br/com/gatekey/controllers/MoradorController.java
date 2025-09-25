package br.com.gatekey.controllers;


import br.com.gatekey.entities.Morador;
import br.com.gatekey.facades.MoradorFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorFacade facade;

    public MoradorController(MoradorFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public void cadastrar(@RequestBody Morador morador) {
        facade.cadastrar(morador);
    }

    @GetMapping("/{id}")
    public Morador buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @GetMapping
    public List<Morador> listarTodos() {
        return facade.listarTodos();
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Morador morador) {
        morador.setId(id);
        facade.atualizar(morador);
    }
    
    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        facade.remover(id);
    }
}
