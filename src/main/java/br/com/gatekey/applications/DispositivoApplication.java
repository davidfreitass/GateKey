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

    public Dispositivo salvar(Dispositivo dispositivo) {
        return null;
    }

    public List<Dispositivo> listar() {
        return repository.findAll();
    }

    public Optional<Dispositivo> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void excluir(Integer id) {
    }
}
