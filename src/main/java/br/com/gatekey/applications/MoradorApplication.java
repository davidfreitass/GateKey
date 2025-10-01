package br.com.gatekey.applications;

import br.com.gatekey.entities.Morador;
import br.com.gatekey.repositories.MoradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorApplication {
    private final MoradorRepository repository;

    public MoradorApplication(MoradorRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Morador morador) {
        repository.salvar(morador);
    }

    public Morador buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Morador> listarTodos() {
        return repository.buscarTodos();
    }

    public void atualizar(Morador morador) {
        repository.atualizar(morador);
    }

    public void remover(int id) {
        repository.remover(id);
    }
}
