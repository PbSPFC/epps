package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.List;

import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.database.DbProntuario;
import br.uninove.primeiraconsulta.entidade.Prontuario;

/**
 * Created by PB on 10/11/2016.
 */

public class CheckNovoProntuario {

    public static boolean checkCampos(Prontuario p, Context context) {

        if(!p.getNumProntuario().isEmpty() && !p.getNomePaciente().isEmpty() &&
                p.getIdUsuario()!= null && !p.getRaUsuario().isEmpty() && !p.getNomeMedico().isEmpty() &&
                !p.getSexo().isEmpty() && p.getIdade() != null && p.getPeso() != null && p.getAltura() != null){
            return true;
        }
        return false;
    }

    public static Prontuario checkNumProntuario(Prontuario p, Context context) {
        List<Prontuario> prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
        for (Prontuario pron : prontuarioLista) {
            if(p.getNumProntuario().equals(pron.getNumProntuario())){
                return null;
            }
        }
        p = nadaConsta(p);
        ProntuarioDao.salvar(p, context);
        return p;
    }

    public static Prontuario nadaConsta(Prontuario p){
        if(p.getComentario().isEmpty()){
            p.setComentario("Nada Consta!");
        }
        if(p.getGordura().isEmpty() || p.getGordura().equals("")){
            p.setComentario("Nada Consta!");
        }

        return p;
    }

}
