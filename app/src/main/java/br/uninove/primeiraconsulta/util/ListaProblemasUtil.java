package br.uninove.primeiraconsulta.util;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.entidade.ListaProblemas;

/**
 * Created by PB on 21/11/2016.
 */

public class ListaProblemasUtil {

    public static List<ListaProblemas> listaDeProblemas = new ArrayList<>();

    public static List<ListaProblemas> getNewListaProb(){

        List<ListaProblemas> lista = new ArrayList<>();
        lista.add(new ListaProblemas("", ""));
        lista.add(new ListaProblemas("", ""));
        lista.add(new ListaProblemas("", ""));
        lista.add(new ListaProblemas("", ""));
        lista.add(new ListaProblemas("", ""));
        lista.add(new ListaProblemas("", ""));
        lista.add(new ListaProblemas("", ""));


        return lista;
    }

}
