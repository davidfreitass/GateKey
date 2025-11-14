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

        return new MoradorUnidade(
                saved.getId(),
                saved.getMoradorId(),
                saved.getUnidadeId()
        );
    }

    public List<MoradorUnidade> listarTodos() {
        return repository.findAll()
                .stream()
                .map(model -> new MoradorUnidade(
                        model.getId(),
                        model.getMoradorId(),
                        model.getUnidadeId()
                ))
                .toList();
    }

    public Optional<MoradorUnidade> buscarPorId(Long id) {
        return repository.findById(id)
                .map(model -> new MoradorUnidade(
                        model.getId(),
                        model.getMoradorId(),
                        model.getUnidadeId()
                ));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}