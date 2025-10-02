package br.com.gatekey.applications;

import br.com.gatekey.entities.Credencial;
import br.com.gatekey.repositories.CredencialRepository;
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
        return repository.save(credencial);
    }

    public List<Credencial> listarTodos() {
        return repository.findAll();
    }

    public Optional<Credencial> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
