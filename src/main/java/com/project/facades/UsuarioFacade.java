package com.project.facades;

import com.project.applications.UnidadeApplication;
import com.project.applications.UsuarioApplication;
import com.project.entities.Usuario;
import com.project.models.FuncionarioModel;
import com.project.models.UsuarioModel;
import com.project.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioFacade {

    private final UsuarioApplication usuarioApplication;

    public UsuarioFacade(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioApplication.salvar(usuario);
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioApplication.buscarPorId(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioApplication.listarTodos();
    }

    public void deletar(int id) {
        usuarioApplication.deletar(id);
    }
}