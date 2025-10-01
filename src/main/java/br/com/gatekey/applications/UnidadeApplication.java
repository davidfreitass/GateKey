package br.com.gatekey.application;

import br.com.gatekey.entities.Unidade;
import br.com.gatekey.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeApplication {

    private final UnidadeRepository repository;

    public UnidadeApplication(UnidadeRepository repository) {
        this.repository = repository;
    }

    public Unidade salvar(Unidade unidade) {
        return repository.save(unidade);
    }

    public Unidade buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Unidade> listarTodos() {
        return repository.findAll();
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }
}
