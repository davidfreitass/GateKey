package com.project.applications;

import com.project.entities.Dispositivo;
import com.project.entities.RegistroAcesso;
import com.project.models.RegistroAcessoModel;
import com.project.repositories.RegistroAcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroAcessoApplication {

    private final RegistroAcessoRepository repository;

    public RegistroAcessoApplication(RegistroAcessoRepository repository) {
        this.repository = repository;
    }

    public RegistroAcesso salvar(RegistroAcesso registroAcesso) {
        RegistroAcessoModel model = registroAcesso.toModel();
        RegistroAcessoModel saved = repository.save(model);

        return new RegistroAcesso(
                saved.getId(),
                saved.getDataHora(),
                saved.getSituacao()
        );
    }

    public List<RegistroAcesso> listarTodos() {
        return repository.findAll()
                .stream()
                .map(model -> new RegistroAcesso(
                        model.getId(),
                        model.getDataHora(),
                        model.getSituacao()
                ))
                .toList();
    }

    public Optional<RegistroAcesso> buscarPorId(Integer id) {
        return repository.findById(id)
                .map(model -> new RegistroAcesso(
                        model.getId(),
                        model.getDataHora(),
                        model.getSituacao()
                ));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}