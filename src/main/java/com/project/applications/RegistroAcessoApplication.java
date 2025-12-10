package com.project.applications;

import com.project.entities.RegistroAcesso;
import com.project.models.RegistroAcessoModel;
import com.project.repositories.RegistroAcessoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        
        model.setDataHora(LocalDateTime.now());

        RegistroAcessoModel saved = repository.save(model);

        return new RegistroAcesso(
                saved.getId(),
                saved.getDataHora(),
                saved.getSituacao(),
                saved.getCredencialId(),
                saved.getDispositivoId()
        );
    }

    public List<RegistroAcesso> listarTodos() {
        return repository.findAll()
                .stream()
                .map(model -> new RegistroAcesso(
                        model.getId(),
                        model.getDataHora(),
                        model.getSituacao(),
                        model.getCredencialId(),
                        model.getDispositivoId()
                ))
                .toList();
    }

    public Optional<RegistroAcesso> buscarPorId(Integer id) {
        return repository.findById(id)
                .map(model -> new RegistroAcesso(
                        model.getId(),
                        model.getDataHora(),
                        model.getSituacao(),
                        model.getCredencialId(),
                        model.getDispositivoId()
                ));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
