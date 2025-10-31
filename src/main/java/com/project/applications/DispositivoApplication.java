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

    public DispositivoModel salvar(DispositivoModel dispositivoModel) {
        return repository.save(dispositivoModel);
    }

    public List<DispositivoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<DispositivoModel> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
 }
}

