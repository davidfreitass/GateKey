package com.project.applications;

import com.project.entities.Funcionario;
import com.project.entities.Morador;
import com.project.exceptions.FuncionarioException;
import com.project.exceptions.MoradorException;
import com.project.models.FuncionarioModel;
import com.project.models.MoradorModel;
import com.project.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioApplication {

    private final FuncionarioRepository repository;

    public FuncionarioApplication(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvar(Funcionario funcionario) {

        if (funcionario == null) {
            throw new FuncionarioException("Cliente nulo");
        }

        String cpf = funcionario.getCpf();
        if (!funcionario.validarCpf(cpf)) {
            throw new FuncionarioException("CPF inválido: " + cpf);
        }

        FuncionarioModel model = funcionario.toModel();
        FuncionarioModel saved = repository.save(model);

        return new Funcionario(
                saved.getId(),
                saved.getNome(),
                saved.getCpf(),
                saved.getTelefone(),
                saved.getEmail(),
                saved.getFotoPerfil(),
                saved.getStatus()
        );
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll()
                .stream()
                .map(model -> new Funcionario(
                        model.getId(),
                        model.getNome(),
                        model.getCpf(),
                        model.getTelefone(),
                        model.getEmail(),
                        model.getFotoPerfil(),
                        model.getStatus()
                ))
                .toList();
    }

    public Optional<Funcionario> buscarPorId(Integer id) {
        return repository.findById(id)
                .map(model -> new Funcionario(
                        model.getId(),
                        model.getNome(),
                        model.getCpf(),
                        model.getTelefone(),
                        model.getEmail(),
                        model.getFotoPerfil(),
                        model.getStatus()
                ));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}