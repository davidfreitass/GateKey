package br.com.gatekey.repositories;

import br.com.gatekey.entities.Credencial;
import java.util.List;

public interface CredencialRepository {
    Credencial salvar(Credencial credencial);
    Credencial buscarPorId(int id);
    List<Credencial> listarTodos();
    void deletar(int id);
}
