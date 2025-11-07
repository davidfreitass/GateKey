package com.project.facades;

import com.project.applications.CredencialApplication;
import com.project.entities.Credencial;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CredencialFacade {

    private final CredencialApplication credencialApplication;

    public CredencialFacade(CredencialApplication credencialApplication) {
        this.credencialApplication = credencialApplication;
    }

    public Credencial salvar(Credencial credencial) {
        return credencialApplication.salvar(credencial);
    }

    public Optional<Credencial> buscarPorId(int id) {
        return credencialApplication.buscarPorId(id);
    }

    public List<Credencial> listarTodos() {
        return credencialApplication.listarTodos();
    }

    public void deletar(int id) {
        credencialApplication.deletar(id);
    }
}
