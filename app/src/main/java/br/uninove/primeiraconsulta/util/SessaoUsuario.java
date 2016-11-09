package br.uninove.primeiraconsulta.util;

import br.uninove.primeiraconsulta.entidade.Usuario;

/**
 * Created by PB on 09/11/2016.
 */

public class SessaoUsuario {

    private static Usuario usuarioSessao;

    public static Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public static void setUsuarioSessao(Usuario usuarioSessao) {
        SessaoUsuario.usuarioSessao = usuarioSessao;
    }
}
