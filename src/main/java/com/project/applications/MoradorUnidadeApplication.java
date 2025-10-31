package com.project.applications;

import com.project.entities.MoradorUnidade;
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
        if (moradorUnidade.getIdMorador() == null || moradorUnidade.getIdUnidade() == null) {
            throw new IllegalArgumentException("Os IDs de Morador e Unidade são obrigatórios para a associação.");
        }
        return repository.save(moradorUnidade);
    }

    public List<MoradorUnidade> listarTodos() {
        return repository.findAll();
    }

    public Optional<MoradorUnidade> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<MoradorUnidade> buscarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        return repository.findByIdMoradorAndIdUnidade(moradorId, unidadeId);
    }

    public boolean deletarPorIdsMoradorUnidade(Integer moradorId, Integer unidadeId) {
        Optional<MoradorUnidade> associacao = repository.findByIdMoradorAndIdUnidade(moradorId, unidadeId);
        if (associacao.isPresent()) {
            repository.delete(associacao.get());
            return true;
        }
        return false;
    }
}
