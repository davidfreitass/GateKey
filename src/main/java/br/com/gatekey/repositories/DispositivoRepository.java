package br.com.gatekey.repositories;



import br.com.gatekey.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer>  {
    Dispositivo salvar(Dispositivo dispositivo);
    Dispositivo buscarPorId(int id);
    List<Dispositivo> listarTodos();
    void deletar(int id);
}