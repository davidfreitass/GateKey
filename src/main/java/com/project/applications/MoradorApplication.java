package com.project.applications;

import com.project.entities.Morador;
import com.project.models.MoradorModel;
import com.project.repositories.MoradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorApplication {

    private final MoradorRepository repository;

    public MoradorApplication(MoradorRepository repository) {
        this.repository = repository;
    }

    public MoradorModel salvar(MoradorModel moradorModel) {
        return repository.save(moradorModel);
    }

    public List<MoradorModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<MoradorModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
