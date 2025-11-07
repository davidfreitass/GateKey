package com.project.applications;



import com.project.entities.Dispositivo;
import com.project.models.DispositivoModel;
import com.project.repositories.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoApplication {

    private final DispositivoRepository repository;

    public DispositivoApplication(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo salvar(Dispositivo dispositivo) {
        DispositivoModel model = dispositivo.toModel();
        DispositivoModel saved = repository.save(model);

        return new Dispositivo(
                saved.getId(),
                saved.getLocalizacao(),
                saved.getTipo(),
                saved.getStatus()
        );
    }

    public List<Dispositivo> listarTodos() {
        return repository.findAll()
                .stream()
                .map(model -> new Dispositivo(
                        model.getId(),
                        model.getLocalizacao(),
                        model.getTipo(),
                        model.getStatus()
                ))
                .toList();
    }

    public Optional<Dispositivo> buscarPorId(Integer id) {
        return repository.findById(id)
                .map(model -> new Dispositivo(
                        model.getId(),
                        model.getLocalizacao(),
                        model.getTipo(),
                        model.getStatus()
                ));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
 }
}

