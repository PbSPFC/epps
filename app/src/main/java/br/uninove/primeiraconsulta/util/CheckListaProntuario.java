package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;

/**
 * Created by PB on 10/11/2016.
 */

public class CheckListaProntuario {

    public static List<Prontuario> checkProntuarioUsuarioId(Long id, Context context) throws Exception {
        try {
            List<Prontuario> prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
            List<Prontuario> listaRetorno = new ArrayList<>();
            for (Prontuario pron : prontuarioLista) {
                if (id == pron.getIdUsuario()) {
                    listaRetorno.add(pron);
                }
            }

            return listaRetorno;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    public static List<Prontuario> checkProntuarioNumProntuario(String numProntuario, Context context) throws Exception {
        try {
            List<Prontuario> prontuarioLista = LogProntuarioDao.buscarTodosProntuarios(context);
            List<Prontuario> listaRetorno = new ArrayList<>();
            for (Prontuario pron : prontuarioLista) {
                if (numProntuario.equals(pron.getNumProntuario())) {
                    listaRetorno.add(pron);
                }
            }

            return listaRetorno;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

}
