package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.List;

import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.database.DbUsuario;
import br.uninove.primeiraconsulta.entidade.Usuario;

/**
 * Created by PB on 09/11/2016.
 */

public class CheckLogin {

    public static Usuario checklogin(String ra, String senha, Context context) {

        List<Usuario> listaUsuarios = UsuarioDao.buscarTodosUsuarios(context);
        for (Usuario u:listaUsuarios) {
            if(ra.equals(u.getRa()) && senha.equals(u.getSenha())){
                Usuario usuario = new Usuario();
                usuario.setId(u.getId());
                usuario.setRa(u.getRa());
                usuario.setNome(u.getNome());
                usuario.setSenha(u.getSenha());
                usuario.setStatus(u.getStatus());
                return usuario;
            }
        }

        return null;
    }

}
