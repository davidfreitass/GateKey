package com.project.applications;

import com.project.entities.MoradorUnidade;
import com.project.entities.RegistroAcesso;
import com.project.models.MoradorUnidadeModel;
import com.project.repositories.MoradorUnidadeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MoradorUnidadeApplication {

    private final MoradorUnidadeRepository repository;

    public MoradorUnidadeApplication(MoradorUnidadeRepository repository) {
        this.repository = repository;
    }

    public MoradorUnidade salvar(MoradorUnidade moradorUnidade) {
        MoradorUnidadeModel model = moradorUnidade.toModel();
        MoradorUnidadeModel saved = repository.save(model);

        return moradorUnidade.fromModel(saved);
    }

    public List<MoradorUnidade> listarTodos() {
        MoradorUnidade moradorUnidadeConverter = new MoradorUnidade();
        return repository.findAll()
                .stream()
                .map(moradorUnidadeConverter::fromModel)
                .toList();
    }

    public Optional<MoradorUnidade> buscarPorId(Long id) {
        MoradorUnidade moradorUnidadeConverter = new MoradorUnidade();
        return repository.findById(id)
                .map(moradorUnidadeConverter::fromModel);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}