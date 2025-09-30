package br.com.gatekey.applications;


import br.com.gatekey.entities.RegistroAcesso;
import br.com.gatekey.repositories.RegistroAcessoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistroAcessoApplication {
    private final RegistroAcessoRepository repository;

    public RegistroAcessoApplication(RegistroAcessoRepository repository) {
        this.repository = repository;
    }

    public RegistroAcesso salvar(RegistroAcesso registroAcesso) {
        return repository.salvar(registroAcesso);
    }

    public RegistroAcesso buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<RegistroAcesso> listarTodos() {
        return repository.listarTodos();
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}
