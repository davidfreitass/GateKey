package br.com.gatekey.applications;

import br.com.gatekey.entities.Credencial;
import br.com.gatekey.repositories.CredencialRepository;

import java.util.List;

public class CredencialApplication {

    private final CredencialRepository repository;

    public CredencialApplication(CredencialRepository repository) {
        this.repository = repository;
    }

    public Credencial salvar(Credencial credencial) {
        return repository.salvar(credencial);
    }

    public Credencial buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Credencial> listarTodos() {
        return repository.listarTodos();
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}
