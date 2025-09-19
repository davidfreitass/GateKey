package br.com.gatekey.repositories;

import br.com.gatekey.entities.Unidade;
import java.util.List;

public interface UnidadeRepository {
    Unidade salvar(Unidade unidade);
    Unidade buscarPorId(int id);
    List<Unidade> listarTodos();
    void deletar(int id);
}
