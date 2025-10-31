package com.project.facades;

import com.project.entities.Credencial;
import com.project.models.CredencialModel;
import com.project.repositories.CredencialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialFacade {

    private final CredencialRepository repository;

    public CredencialFacade(CredencialRepository repository) {
        this.repository = repository;
    }


    public CredencialModel salvar(CredencialModel credencialModel) {
        return repository.save(credencialModel);
    }

    public CredencialModel buscarPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credencial não encontrada"));
    }

    public List<CredencialModel> listarTodos() {
        return repository.findAll();
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }
}
