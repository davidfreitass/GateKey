package br.com.gatekey.applications;


import br.com.gatekey.entities.Dispositivo;
import br.com.gatekey.repositories.DispositivoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DispositivoApplication {
    private final DispositivoRepository repository;

    public DispositivoApplication(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo salvar(Dispositivo dispositivo) {
        return repository.save(dispositivo);
    }

    public List<Dispositivo> listar() {
        return repository.findAll();
    }
}
