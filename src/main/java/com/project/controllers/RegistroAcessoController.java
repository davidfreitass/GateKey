package com.project.controllers;

import com.project.entities.RegistroAcesso;
import com.project.facades.RegistroAcessoFacade;
import com.project.models.RegistroAcessoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registros-acesso")
public class RegistroAcessoController {

    private final RegistroAcessoFacade registroAcessoFacade;

    public RegistroAcessoController(RegistroAcessoFacade registroAcessoFacade) {
        this.registroAcessoFacade = registroAcessoFacade;
    }

    @GetMapping
    public List<RegistroAcessoModel> listAll() {
        return registroAcessoFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroAcessoModel> buscar(@PathVariable Integer id) {
        return registroAcessoFacade.buscarPorId(id)
                .map(this::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RegistroAcessoModel create(@RequestBody RegistroAcessoModel model) {
        RegistroAcesso registroAcesso = toEntity(model);
        RegistroAcesso saved = registroAcessoFacade.salvar(registroAcesso);
        return toModel(saved);
    }

    @PutMapping("/{id}")
    public RegistroAcessoModel update(@PathVariable int id, @RequestBody RegistroAcessoModel model) {
        RegistroAcesso registroAcesso = toEntity(model);
        registroAcesso.setId(id);
        RegistroAcesso updated = registroAcessoFacade.salvar(registroAcesso);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        registroAcessoFacade.deletar(id);
    }

        private RegistroAcesso toEntity (RegistroAcessoModel model){
            RegistroAcesso registroAcesso = new RegistroAcesso();
            registroAcesso.setId(model.getId());
            registroAcesso.setDataHora(model.getDataHora());
            registroAcesso.setSituacao(model.getSituacao());
            return registroAcesso;
        }

        private RegistroAcessoModel toModel (RegistroAcesso registroAcesso){
            RegistroAcessoModel model = new RegistroAcessoModel();
            model.setId(registroAcesso.getId());
            model.setDataHora(registroAcesso.getDataHora());
            model.setSituacao(registroAcesso.getSituacao());
            return model;
        }
    }
