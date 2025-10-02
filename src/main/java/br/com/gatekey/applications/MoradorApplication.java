package br.com.gatekey.applications;

import br.com.gatekey.entities.Morador;
import br.com.gatekey.repositories.MoradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorApplication {

    private final MoradorRepository repository;

    public MoradorApplication(MoradorRepository repository) {
        this.repository = repository;
    }

    public Morador salvar(Morador morador) {
        return repository.save(morador);
    }

    public List<Morador> listarTodos() {
        return repository.findAll();
    }

    public Optional<Morador> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
