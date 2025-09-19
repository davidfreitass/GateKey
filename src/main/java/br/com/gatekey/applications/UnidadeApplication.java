package br.com.gatekey.applications;

import br.com.gatekey.entities.Unidade;
import br.com.gatekey.repositories.UnidadeRepository;

import java.util.List;

public class UnidadeApplication {

    private final UnidadeRepository repository;

    public UnidadeApplication(UnidadeRepository repository) {
        this.repository = repository;
    }

    public Unidade salvar(Unidade unidade) {
        return repository.salvar(unidade);
    }

    public Unidade buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Unidade> listarTodos() {
        return repository.listarTodos();
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}
