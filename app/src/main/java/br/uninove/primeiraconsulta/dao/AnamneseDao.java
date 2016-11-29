package br.uninove.primeiraconsulta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbAnamnese;
import br.uninove.primeiraconsulta.database.DbExameFisico;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 20/11/2016.
 */

public class AnamneseDao {

    public static void salvar(Anamnese anamnese, Context context){
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        values.put(numProntuario, anamnese.getNumProntuario());
        values.put(queixaDuracao,anamnese.getQueixa());
        values.put(historiaDoenca,anamnese.getHistoriaDoenca());
        values.put(interrogatorio,anamnese.getInterrogatorio());
        values.put(percepcao,anamnese.getPercepcao());


        //Verificando se ira fazer udpate ou insert
        if(anamnese.getId()==null) {
            db.insert(DbAnamnese.ANAMNESE_TB_NAME, null, values);
            System.out.println("Nome do Médico: " + anamnese.getNumProntuario());
        }else{
            db.update(DbAnamnese.ANAMNESE_TB_NAME, values, "id = ?", new String[]{anamnese.getId().toString()});
        }
        db.close();
    }

    public static List<Anamnese> buscarTodosProntuarios(Context context){
        List<Anamnese> lista = new ArrayList<>();

        String sql = "select * from " + DbAnamnese.ANAMNESE_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Anamnese anamnese = new Anamnese();
                anamnese.setId(cursor.getLong(ID));
                anamnese.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                anamnese.setQueixa(cursor.getString(QUEIXA_DURACAO));
                anamnese.setHistoriaDoenca(cursor.getString(HISTORIA_DOENCA_ATUAL));
                anamnese.setInterrogatorio(cursor.getString(INTERROGATORIO));
                anamnese.setPercepcao(cursor.getString(PERCEPCAO_PACIENTE));

                lista.add(anamnese);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;
    }

    public static Anamnese buscarPorNumProntuario(Prontuario p, Context context){
        List<Anamnese> lista = new ArrayList<>();

        String sql = "select * from " + DbAnamnese.ANAMNESE_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Anamnese anamnese = new Anamnese();
                anamnese.setId(cursor.getLong(ID));
                anamnese.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                anamnese.setQueixa(cursor.getString(QUEIXA_DURACAO));
                anamnese.setHistoriaDoenca(cursor.getString(HISTORIA_DOENCA_ATUAL));
                anamnese.setInterrogatorio(cursor.getString(INTERROGATORIO));
                anamnese.setPercepcao(cursor.getString(PERCEPCAO_PACIENTE));

                lista.add(anamnese);

            }while(cursor.moveToNext());
        }

        for (Anamnese a : lista) {
            if(p.getNumProntuario().equals(a.getNumProntuario())){
                return a;
            }
        }

        db.close();
        return null;
    }

    public static Anamnese buscarPorId(Long id, Context context){

        String sql = "select * from " + DbAnamnese.ANAMNESE_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Anamnese anamnese = new Anamnese();
                anamnese.setId(cursor.getLong(ID));
                anamnese.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                anamnese.setQueixa(cursor.getString(QUEIXA_DURACAO));
                anamnese.setHistoriaDoenca(cursor.getString(HISTORIA_DOENCA_ATUAL));
                anamnese.setInterrogatorio(cursor.getString(INTERROGATORIO));
                anamnese.setPercepcao(cursor.getString(PERCEPCAO_PACIENTE));
                db.close();
                return anamnese;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }


    public static void excluirAnamnese(Anamnese anamnese, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbAnamnese.ANAMNESE_TB_NAME, "id =?", new String[]{anamnese.getId().toString()});
        System.out.println("Anamnese: " + anamnese.getNumProntuario());
        db.close();
    }

    public static void excluirTodosAnamnese(Prontuario p, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbAnamnese.ANAMNESE_TB_NAME, "num_prontuario =?", new String[]{p.getNumProntuario().toString()});
        db.close();
    }

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int QUEIXA_DURACAO = 2;
    public static final int HISTORIA_DOENCA_ATUAL = 3;
    public static final int INTERROGATORIO = 4;
    public static final int PERCEPCAO_PACIENTE = 5;

    public static final String id = "ID";
    public static final String numProntuario = "NUM_PRONTUARIO";
    public static final String queixaDuracao = "QUEIXA_DURACAO";
    public static final String historiaDoenca = "HISTORIA_DOENCA_ATUAL";
    public static final String interrogatorio = "INTERROGATORIO";
    public static final String percepcao = "PERCEPCAO_PACIENTE";

}
