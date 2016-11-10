package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;

/**
 * Created by PB on 10/11/2016.
 */

public class CheckListaProntuario {

    public static List<Prontuario> checkProntuarioUsuarioId(Long id, Context context) {
        List<Prontuario> prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
        List<Prontuario> listaRetorno = new ArrayList<>();
        for (Prontuario pron : prontuarioLista) {
            if(id == pron.getIdUsuario()){
                listaRetorno.add(pron);
            }
        }

        return listaRetorno;
    }

}
