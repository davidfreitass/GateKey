package com.project.applications;

import com.project.models.MoradorUnidadeModel;
import com.project.repositories.MoradorUnidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorUnidadeApplication {

    private final MoradorUnidadeRepository repository;

    public MoradorUnidadeApplication(MoradorUnidadeRepository repository) {
        this.repository = repository;
    }

    public MoradorUnidadeModel salvar(MoradorUnidadeModel moradorUnidadeModel) {
        return repository.save(moradorUnidadeModel);
    }

    public List<MoradorUnidadeModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<MoradorUnidadeModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }

    public Optional<MoradorUnidadeModel> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return repository.findByMorador_IdAndUnidade_Id(moradorId, unidadeId);
    }

    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        Optional<MoradorUnidadeModel> associacao = repository.findByMorador_IdAndUnidade_Id(moradorId, unidadeId);
        if (associacao.isPresent()) {
            repository.delete(associacao.get());
            return true;
        }
        return false;
    }
}