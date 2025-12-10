package com.project.applications;

import com.project.entities.Credencial;
import com.project.models.CredencialModel;
import com.project.repositories.CredencialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CredencialApplication {

    private final CredencialRepository repository;

    public CredencialApplication(CredencialRepository repository) {
        this.repository = repository;
    }

    public Credencial salvar(Credencial credencial) {

        CredencialModel model = credencial.toModel();

        CredencialModel saved = repository.save(model);

        return new Credencial(
                saved.getId(),
                saved.getDadosBiometricos(),
                saved.getMoradorId(),
                saved.getFuncionarioId()
        );
    }

    public List<Credencial> listarTodos() {
        return repository.findAll()
                .stream()
                .map(model -> new Credencial(
                        model.getId(),
                        model.getDadosBiometricos(),
                        model.getMoradorId(),
                        model.getFuncionarioId()
                ))
                .toList();
    }

    public Optional<Credencial> buscarPorId(Integer id) {
        return repository.findById(id)
                .map(model -> new Credencial(
                        model.getId(),
                        model.getDadosBiometricos(),
                        model.getMoradorId(),
                        model.getFuncionarioId()
                ));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}