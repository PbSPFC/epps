package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.List;

import br.uninove.primeiraconsulta.activity.cadastro.CadastroUsuarioActivity;
import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.entidade.Status;
import br.uninove.primeiraconsulta.entidade.Usuario;

/**
 * Created by PB on 09/11/2016.
 */

public class CheckCadastro {


    public static boolean checkRa(String ra, Context context) {
        List<Usuario> listaUsuarios = UsuarioDao.buscarTodosUsuarios(context);
        for (Usuario u:listaUsuarios) {
            if(ra.equals(u.getRa())){
                return false;
            }
        }
        return true;
    }


    public static boolean checkCampoInvalido(String nome, String ra, String senha, Context context) {
        if(!nome.isEmpty() && !ra.isEmpty() && !senha.isEmpty()){

            Usuario usuario = new Usuario();
            usuario.setRa(ra);
            usuario.setSenha(senha);
            usuario.setNome(nome);
            Status status = new Status();
            status.setId(new Long(2));
            usuario.setStatus(status);

            UsuarioDao.salvar(usuario, context);

            return true;
        }
        return false;
    }
}
