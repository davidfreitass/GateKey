package br.com.gatekey.applications;



import br.com.gatekey.entities.Dispositivo;
import br.com.gatekey.repositories.DispositivoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DispositivoApplication {
    private final DispositivoRepository repository;

    public DispositivoApplication(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo salvar(Dispositivo credencial) {
        return repository.salvar(credencial);
    }

    public Dispositivo buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Dispositivo> listarTodos() {
        return repository.listarTodos();
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}

