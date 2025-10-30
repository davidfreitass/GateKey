package com.project.applications;

import com.project.entities.MoradorUnidade;
import com.project.entities.MoradorUnidadeId;
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
        return repository.save(moradorUnidade);
    }

    public List<MoradorUnidade> listarTodos() {
        return repository.findAll();
    }

    public Optional<MoradorUnidade> buscarPorId(MoradorUnidadeId id) {
        return repository.findById(id);
    }

    public void deletar(MoradorUnidadeId id) {
        repository.deleteById(id);
    }
}
