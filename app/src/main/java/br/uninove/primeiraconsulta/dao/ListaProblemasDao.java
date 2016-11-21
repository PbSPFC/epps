package br.uninove.primeiraconsulta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbListaProblemas;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 21/11/2016.
 */

public class ListaProblemasDao {

    public static void salvar(List<ListaProblemas> lp, Prontuario prontuario, Context context){
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        for (ListaProblemas listaProblemas:lp) {
            listaProblemas.setNumProntuario(prontuario.getNumProntuario());

            values.put(numProntuario, listaProblemas.getNumProntuario());
            values.put(descricao,listaProblemas.getDescricao());
            values.put(acao,listaProblemas.getAcao());


            //Verificando se ira fazer udpate ou insert
            if(listaProblemas.getId()==null) {
                db.insert(DbListaProblemas.LISTA_PROBLEMAS_TB_NAME, null, values);
                System.out.println("Nome do Médico: " + listaProblemas.getNumProntuario());
            }else{
                db.update(DbListaProblemas.LISTA_PROBLEMAS_TB_NAME, values, "id = ?", new String[]{listaProblemas.getId().toString()});
            }
        }
        

        db.close();
    }

    public static List<ListaProblemas> buscarTodos(Context context){
        List<ListaProblemas> lista = new ArrayList<>();

        String sql = "select * from " + DbListaProblemas.LISTA_PROBLEMAS_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                ListaProblemas listaProblemas = new ListaProblemas();
                listaProblemas.setId(cursor.getLong(ID));
                listaProblemas.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                listaProblemas.setDescricao(cursor.getString(DESCRICAO));
                listaProblemas.setAcao(cursor.getString(ACAO));

                lista.add(listaProblemas);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;
    }

    public static List<ListaProblemas> buscarPorNumProntuario(Prontuario p, Context context){
        List<ListaProblemas> lista = new ArrayList<>();

        String sql = "select * from " + DbListaProblemas.LISTA_PROBLEMAS_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                ListaProblemas listaProblemas = new ListaProblemas();
                listaProblemas.setId(cursor.getLong(ID));
                listaProblemas.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                listaProblemas.setDescricao(cursor.getString(DESCRICAO));
                listaProblemas.setAcao(cursor.getString(ACAO));

                lista.add(listaProblemas);

            }while(cursor.moveToNext());
        }

        List<ListaProblemas> listaAtualizada = new ArrayList<>();

        for (ListaProblemas lp : lista) {
            if(p.getNumProntuario().equals(lp.getNumProntuario())){
                listaAtualizada.add(lp);
            }
        }

        db.close();
        return listaAtualizada;
    }

    public static ListaProblemas buscarPorId(Long id, Context context){

        String sql = "select * from " + DbListaProblemas.LISTA_PROBLEMAS_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                ListaProblemas listaProblemas = new ListaProblemas();
                listaProblemas.setId(cursor.getLong(ID));
                listaProblemas.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                listaProblemas.setDescricao(cursor.getString(DESCRICAO));
                listaProblemas.setAcao(cursor.getString(ACAO));
                db.close();
                return listaProblemas;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }


    public static void excluirListaProblemas(ListaProblemas listaProblemas, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbListaProblemas.LISTA_PROBLEMAS_TB_NAME, "id =?", new String[]{listaProblemas.getId().toString()});
        System.out.println("ListaProblemas: " + listaProblemas.getNumProntuario());
        db.close();
    }

    public static void excluirListaProblemasNumProntuario(Prontuario prontuario, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbListaProblemas.LISTA_PROBLEMAS_TB_NAME, "num_prontuario =?", new String[]{prontuario.getNumProntuario().toString()});
        System.out.println("ListaProblemas: " + prontuario.getNumProntuario());
        db.close();
    }

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int DESCRICAO = 2;
    public static final int ACAO = 3;

    public static final String id = "ID";
    public static final String numProntuario = "NUM_PRONTUARIO";
    public static final String descricao = "DESCRICAO";
    public static final String acao = "ACAO";


}
