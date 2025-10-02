package br.com.gatekey.controllers;

import br.com.gatekey.entities.Usuario;
import br.com.gatekey.facades.UsuarioFacade;
import br.com.gatekey.models.UsuarioModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @PostMapping
    public UsuarioModel create(@RequestBody UsuarioModel model) {
        Usuario usuario = toEntity(model);
        Usuario saved = usuarioFacade.salvar(usuario);
        return toModel(saved);
    }

    @GetMapping("/{id}")
    public UsuarioModel read(@PathVariable int id) {
        Usuario usuario = usuarioFacade.buscarPorId(id);
        return toModel(usuario);
    }

    @GetMapping
    public List<UsuarioModel> listAll() {
        return usuarioFacade.listarTodos()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public UsuarioModel update(@PathVariable int id, @RequestBody UsuarioModel model) {
        Usuario usuario = toEntity(model);
        usuario.setId(id);
        Usuario updated = usuarioFacade.salvar(usuario);
        return toModel(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        usuarioFacade.deletar(id);
    }

    private Usuario toEntity(UsuarioModel model) {
        Usuario usuario = new Usuario();
        usuario.setId(model.getId());
        usuario.setLogin(model.getLogin());
        usuario.setSenha(model.getSenha());
        usuario.setNivelAcesso(model.getNivelAcesso());
        usuario.setStatus(model.getStatus());
        return usuario;
    }

    private UsuarioModel toModel(Usuario usuario) {
        UsuarioModel model = new UsuarioModel();
        model.setId(usuario.getId());
        model.setLogin(usuario.getLogin());
        model.setSenha(usuario.getSenha());
        model.setNivelAcesso(usuario.getNivelAcesso());
        model.setStatus(usuario.getStatus());
        return model;
    }
}