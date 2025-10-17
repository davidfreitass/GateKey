package com.project.controllers;

import com.project.entities.Funcionario;
import com.project.facades.FuncionarioFacade;
import com.project.models.FuncionarioModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioFacade funcionarioFacade;

    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    @PostMapping
    public FuncionarioModel create(@RequestBody FuncionarioModel model) {
        Funcionario funcionario = toEntity(model);
        Funcionario saved = funcionarioFacade.salvar(funcionario);
        return toModel(saved);
    }

    @GetMapping("/{id}")
    public FuncionarioModel read(@PathVariable int id) {
        Funcionario funcionario = funcionarioFacade.buscarPorId(id);
        return toModel(funcionario);
    }

    @GetMapping
    public List<FuncionarioModel> listAll() {
        return funcionarioFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public FuncionarioModel update(@PathVariable int id, @RequestBody FuncionarioModel model) {
        Funcionario funcionario = toEntity(model);
        funcionario.setId(id);
        Funcionario updated = funcionarioFacade.salvar(funcionario);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        funcionarioFacade.deletar(id);
    }

    private Funcionario toEntity(FuncionarioModel model) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(model.getId());
        funcionario.setNome(model.getNome());
        funcionario.setCpf(model.getCpf());
        funcionario.setTelefone(model.getTelefone());
        funcionario.setEmail(model.getEmail());
        funcionario.setFotoPerfil(model.getFotoPerfil());
        funcionario.setStatus(model.getStatus());
        return funcionario;
    }

    private FuncionarioModel toModel(Funcionario funcionario) {
        FuncionarioModel model = new FuncionarioModel();
        model.setId(funcionario.getId());
        model.setNome(funcionario.getNome());
        model.setCpf(funcionario.getCpf());
        model.setTelefone(funcionario.getTelefone());
        model.setEmail(funcionario.getEmail());
        model.setFotoPerfil(funcionario.getFotoPerfil());
        model.setStatus(funcionario.getStatus());
        return model;
    }
}