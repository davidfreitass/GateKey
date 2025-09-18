package br.com.gatekey.repositories;

import br.com.gatekey.entities.Morador;

import java.util.List;

public interface MoradorRepository {

    void salvar(Morador morador);
    Morador buscarPorId(int id);
    List<Morador> buscarTodos();
    void atualizar(Morador morador);
    void remover(int id);

}
