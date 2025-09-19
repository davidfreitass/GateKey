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

    public RegistroAcesso salvar(RegistroAcesso registro) {
        return repository.save(registro);
    }

    public List<RegistroAcesso> listar() {
        return repository.findAll();
    }
}
