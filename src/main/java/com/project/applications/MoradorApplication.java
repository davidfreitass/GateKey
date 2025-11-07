package com.project.applications;

import com.project.entities.Morador;
import com.project.exceptions.MoradorException;

import com.project.models.MoradorModel;
import com.project.repositories.MoradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorApplication {

    private final MoradorRepository moradorRepository;

    public MoradorApplication(MoradorRepository repository) {
        this.moradorRepository = repository;
    }

    public Morador salvar(Morador morador) {
        if (morador == null) {
            throw new MoradorException("Cliente nulo");
        }

        String cpf = morador.getCpf();
        if (!morador.validarCpf(cpf)) {
            throw new MoradorException("CPF inválido: " + cpf);
        }

        MoradorModel model = morador.toModel();
        MoradorModel saved = moradorRepository.save(model);

        return new Morador(
                saved.getId(),
                saved.getNome(),
                saved.getCpf(),
                saved.getTelefone(),
                saved.getEmail(),
                saved.getStatus()
        );
    }

    public List<Morador> listarTodos() {
        return moradorRepository.findAll()
                .stream()
                .map(model -> new Morador(
                        model.getId(),
                        model.getNome(),
                        model.getCpf(),
                        model.getTelefone(),
                        model.getEmail(),
                        model.getStatus()
                ))
                .toList();
    }

    public Optional<Morador> buscarPorId(Integer id) {
        return moradorRepository.findById(id)
                .map(model -> new Morador(
                        model.getId(),
                        model.getNome(),
                        model.getCpf(),
                        model.getTelefone(),
                        model.getEmail(),
                        model.getStatus()
                ));
    }

    public void deletar(Integer id) {
        moradorRepository.deleteById(id);
    }
}
