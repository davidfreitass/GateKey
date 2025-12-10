package com.project.applications;

import com.project.entities.Usuario;
import com.project.models.FuncionarioModel;
import com.project.models.UsuarioModel;
import com.project.repositories.FuncionarioRepository;
import com.project.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioApplication {

    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;

    public UsuarioApplication(UsuarioRepository usuarioRepository, FuncionarioRepository funcionarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Usuario salvar(Usuario usuario) {

        FuncionarioModel funcionario = usuario.getFuncionario();

        if (funcionario != null ) {
            Integer funcionarioId = funcionario.getId();
            FuncionarioModel funcionarioRef = funcionarioRepository.getReferenceById(funcionarioId);
            usuario.setFuncionario(funcionarioRef);
        }

        UsuarioModel model = usuario.toModel();
        UsuarioModel saved = usuarioRepository.save(model);

        return new Usuario().fromModel(saved);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(model -> new Usuario().fromModel(model))
                .toList();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(model -> new Usuario().fromModel(model));
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}