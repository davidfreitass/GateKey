package com.project.applications;



import com.project.entities.Dispositivo;
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
        return repository.save(dispositivo);
    }

    public List<Dispositivo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Dispositivo> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
 }
}

