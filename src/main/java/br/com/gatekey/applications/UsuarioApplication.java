package br.com.gatekey.applications;

import br.com.gatekey.entities.*;
import br.com.gatekey.facades.UsuarioFacade;

public class Main {
    public static void main(String[] args) {
        UsuarioFacade usuarioFacade = new UsuarioFacade();

        Usuario usuario = new Usuario(
                1,
                "adm",
                "12345",
                NivelAcesso.ADMIN,
                Status.ATIVO,
                0,
                0
        );

        usuarioFacade.registrarUsuario(usuario);

        Usuario logado = usuarioFacade.login("adm", "12345");

        if (logado != null) {
            System.out.println("Login realizado com sucesso! Bem-vindo, " + logado.getLogin());
        } else {
            System.out.println("Falha no login!");
        }
    }
}
