package br.com.gatekey.controllers;

import br.com.gatekey.entities.Usuario;
import br.com.gatekey.facades.UsuarioFacade;
import br.com.gatekey.applications.UsuarioApplication;
import br.com.gatekey.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        UsuarioApplication usuarioApplication = new UsuarioApplication(usuarioRepository);
        this.usuarioFacade = new UsuarioFacade(usuarioApplication);
    }

    @PostMapping
    public String cadastrar(@RequestBody Usuario usuario) {
        usuarioFacade.cadastrar(usuario);
        return "Usuário cadastrado com sucesso!";
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable int id) {
        return usuarioFacade.buscarPorId(id);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioFacade.listarTodos();
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuarioFacade.atualizar(usuario);
        return "Usuário atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id) {
        usuarioFacade.remover(id);
        return "Usuário removido com sucesso!";
    }
}