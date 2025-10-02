package br.com.gatekey.controllers;

import br.com.gatekey.entities.Morador;
import br.com.gatekey.applications.MoradorApplication;
import br.com.gatekey.models.MoradorModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorApplication moradorApplication;

    public MoradorController(MoradorApplication moradorApplication) {
        this.moradorApplication = moradorApplication;
    }

    @GetMapping
    public List<MoradorModel> listAll() {
        return moradorApplication.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MoradorModel buscar(@PathVariable Integer id) {
        Optional<Morador> moradorOpt = moradorApplication.buscarPorId(id);
        return moradorOpt.map(this::toModel)
                .orElseThrow(() -> new RuntimeException("Morador não encontrado com id: " + id));
    }

    @PostMapping
    public MoradorModel create(@RequestBody MoradorModel model) {
        Morador morador = toEntity(model);
        Morador saved = moradorApplication.salvar(morador);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public MoradorModel update(@PathVariable Integer id, @RequestBody MoradorModel model) {
        Morador morador = toEntity(model);
        morador.setId(id);
        Morador updated = moradorApplication.salvar(morador);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        moradorApplication.deletar(id);
    }

    private Morador toEntity(MoradorModel model) {
        Morador morador = new Morador();
        morador.setId(model.getId());
        morador.setNome(model.getNome());
        morador.setCpf(model.getCpf());
        morador.setTelefone(model.getTelefone());
        morador.setEmail(model.getEmail());
        morador.setStatus(model.getStatus());
        return morador;
    }

    private MoradorModel toModel(Morador morador) {
        MoradorModel model = new MoradorModel();
        model.setId(morador.getId());
        model.setNome(morador.getNome());
        model.setCpf(morador.getCpf());
        model.setTelefone(morador.getTelefone());
        model.setEmail(morador.getEmail());
        model.setStatus(morador.getStatus());
        return model;
    }
}
