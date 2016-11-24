package br.uninove.primeiraconsulta.util;

import br.uninove.primeiraconsulta.entidade.Usuario;

/**
 * Created by PB on 09/11/2016.
 */

public class SessaoUsuario {

    private static Usuario usuarioSessao;
    private static String senha;

    public static Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public static void setUsuarioSessao(Usuario usuarioSessao) {
        SessaoUsuario.usuarioSessao = usuarioSessao;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        SessaoUsuario.senha = senha;
    }
}
