package com.project.applications;

import com.project.entities.Unidade;
import com.project.entities.Usuario;
import com.project.models.UnidadeModel;
import com.project.models.UsuarioModel;
import com.project.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioApplication {

    private final UsuarioRepository usuarioRepository;

    public UsuarioApplication(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        UsuarioModel model = usuario.toModel();
        UsuarioModel saved = usuarioRepository.save(model);

        return new Usuario(
                saved.getId(),
                saved.getLogin(),
                saved.getSenha(),
                saved.getNivelAcesso(),
                saved.getStatus()
        );
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(model -> new Usuario(
                        model.getId(),
                        model.getLogin(),
                        model.getSenha(),
                        model.getNivelAcesso(),
                        model.getStatus()
                ))
                .toList();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(model -> new Usuario(
                        model.getId(),
                        model.getLogin(),
                        model.getSenha(),
                        model.getNivelAcesso(),
                        model.getStatus()
                ));
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}