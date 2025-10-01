package br.com.gatekey.repositories;

import br.com.gatekey.entities.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MoradorRepository {

    void salvar(Morador morador);
    Morador buscarPorId(int id);
    List<Morador> buscarTodos();
    void atualizar(Morador morador);
    void remover(int id);

}
