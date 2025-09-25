package br.com.gatekey.controllers;

import br.com.gatekey.applications.RegistroAcessoApplication;
import br.com.gatekey.entities.RegistroAcesso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-acesso")
public class RegistroAcessoController {

    private final RegistroAcessoApplication application;

    public RegistroAcessoController(RegistroAcessoApplication application) {
        this.application = application;
    }

    @GetMapping
    public ResponseEntity<List<RegistroAcesso>> listar() {
        return ResponseEntity.ok(application.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroAcesso> buscarPorId(@PathVariable Integer id) {
        return application.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RegistroAcesso> salvar(@RequestBody RegistroAcesso registro) {
        return ResponseEntity.ok(application.salvar(registro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroAcesso> atualizar(@PathVariable Integer id,
                                                    @RequestBody RegistroAcesso registro) {
        registro.setId(id);
        return ResponseEntity.ok(application.salvar(registro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        application.excluir(id);
        return ResponseEntity.noContent().build();
    }
}