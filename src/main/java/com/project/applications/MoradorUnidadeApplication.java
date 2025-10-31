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

    @Transactional
    public MoradorUnidadeModel salvar(MoradorUnidadeModel moradorUnidadeModel) {
        return repository.save(moradorUnidadeModel);
    }

    public List<MoradorUnidadeModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<MoradorUnidadeModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<MoradorUnidadeModel> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        // O nome do método de repositório deve ser ajustado
        return repository.findByMorador_IdAndUnidade_Id(moradorId, unidadeId);
    }

    @Transactional
    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        // O nome do método de repositório deve ser ajustado
        Optional<MoradorUnidadeModel> associacao = repository.findByMorador_IdAndUnidade_Id(moradorId, unidadeId);
        if (associacao.isPresent()) {
            repository.delete(associacao.get());
            return true;
        }
        return false;
    }
}