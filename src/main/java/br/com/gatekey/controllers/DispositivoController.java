package br.com.gatekey.controllers;

import br.com.gatekey.applications.DispositivoApplication;
import br.com.gatekey.entities.Dispositivo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/dispositivos")
    public class DispositivoController {

        private final DispositivoApplication application;

        public DispositivoController(DispositivoApplication application) {
            this.application = application;
        }

        @GetMapping
        public ResponseEntity<List<Dispositivo>> listar() {
            return ResponseEntity.ok(application.listar());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Dispositivo> buscar(@PathVariable Integer id) {
            return application.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Dispositivo> salvar(@RequestBody Dispositivo dispositivo) {
            return ResponseEntity.ok(application.salvar(dispositivo));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Dispositivo> atualizar(@PathVariable Integer id, @RequestBody Dispositivo dispositivo) {
            dispositivo.setId(id);
            return ResponseEntity.ok(application.salvar(dispositivo));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> excluir(@PathVariable Integer id) {
            application.excluir(id);
            return ResponseEntity.noContent().build();
        }
}
