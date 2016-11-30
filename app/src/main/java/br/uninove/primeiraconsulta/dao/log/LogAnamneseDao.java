package br.uninove.primeiraconsulta.dao.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbAnamnese;
import br.uninove.primeiraconsulta.database.log.DbLogAnamnese;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 20/11/2016.
 */

public class LogAnamneseDao {

    public static void salvar(Anamnese anamnese, Context context) throws Exception {
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        try {
            values.put(numProntuario, anamnese.getNumProntuario());
            values.put(queixaDuracao, anamnese.getQueixa());
            values.put(historiaDoenca, anamnese.getHistoriaDoenca());
            values.put(interrogatorio, anamnese.getInterrogatorio());
            values.put(percepcao, anamnese.getPercepcao());
            values.put(dataEdicao, anamnese.getDataEdicao());


        //Verificando se ira fazer udpate ou insert
        db.insert(DbLogAnamnese.ANAMNESE_TB_NAME, null, values);
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }

    }

    public static List<Anamnese> buscarTodosProntuarios(Context context) throws Exception {
        List<Anamnese> lista = new ArrayList<>();

        String sql = "select * from " + DbLogAnamnese.ANAMNESE_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            if (cursor.moveToFirst()) {
                do {

                    Anamnese anamnese = new Anamnese();
                    anamnese.setId(cursor.getLong(ID));
                    anamnese.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                    anamnese.setQueixa(cursor.getString(QUEIXA_DURACAO));
                    anamnese.setHistoriaDoenca(cursor.getString(HISTORIA_DOENCA_ATUAL));
                    anamnese.setInterrogatorio(cursor.getString(INTERROGATORIO));
                    anamnese.setPercepcao(cursor.getString(PERCEPCAO_PACIENTE));
                    anamnese.setDataEdicao(cursor.getString(DATA_EDICAO));

                    lista.add(anamnese);

                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }
        return lista;
    }

    public static Anamnese buscarPorNumProntuario(Prontuario p, Context context) throws Exception {
        List<Anamnese> lista = new ArrayList<>();

        String sql = "select * from " + DbLogAnamnese.ANAMNESE_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try {
            if (cursor.moveToFirst()) {
                do {

                    Anamnese anamnese = new Anamnese();
                    anamnese.setId(cursor.getLong(ID));
                    anamnese.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                    anamnese.setQueixa(cursor.getString(QUEIXA_DURACAO));
                    anamnese.setHistoriaDoenca(cursor.getString(HISTORIA_DOENCA_ATUAL));
                    anamnese.setInterrogatorio(cursor.getString(INTERROGATORIO));
                    anamnese.setPercepcao(cursor.getString(PERCEPCAO_PACIENTE));
                    anamnese.setDataEdicao(cursor.getString(DATA_EDICAO));

                    lista.add(anamnese);

                } while (cursor.moveToNext());
            }

            for (Anamnese a : lista) {
                if (p.getNumProntuario().equals(a.getNumProntuario()) && p.getDataEdicao().equals(a.getDataEdicao())) {
                    return a;
                }
            }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }

        return null;
    }

    public static Anamnese buscarPorId(Long id, Context context) throws Exception {

        String sql = "select * from " + DbLogAnamnese.ANAMNESE_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    Anamnese anamnese = new Anamnese();
                    anamnese.setId(cursor.getLong(ID));
                    anamnese.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                    anamnese.setQueixa(cursor.getString(QUEIXA_DURACAO));
                    anamnese.setHistoriaDoenca(cursor.getString(HISTORIA_DOENCA_ATUAL));
                    anamnese.setInterrogatorio(cursor.getString(INTERROGATORIO));
                    anamnese.setPercepcao(cursor.getString(PERCEPCAO_PACIENTE));
                    anamnese.setDataEdicao(cursor.getString(DATA_EDICAO));
                    db.close();
                    return anamnese;
                } while (cursor.moveToNext());
            }
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }

        return null;
    }


    public static void excluirAnamnese(Anamnese anamnese, Context context) throws Exception {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        try {
            db.delete(DbLogAnamnese.ANAMNESE_TB_NAME, "id =?", new String[]{anamnese.getId().toString()});
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }

    }
    public static void excluirTodosAnamnese(Prontuario prontuario, Context context) throws Exception {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        try {
            db.delete(DbLogAnamnese.ANAMNESE_TB_NAME, "num_prontuario =?", new String[]{prontuario.getNumProntuario().toString()});
        }catch (Exception e){
            throw new Exception(e);
        }finally {
            db.close();
        }

    }

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int QUEIXA_DURACAO = 2;
    public static final int HISTORIA_DOENCA_ATUAL = 3;
    public static final int INTERROGATORIO = 4;
    public static final int PERCEPCAO_PACIENTE = 5;
    public static final int DATA_EDICAO = 6;

    public static final String id = "ID";
    public static final String numProntuario = "NUM_PRONTUARIO";
    public static final String queixaDuracao = "QUEIXA_DURACAO";
    public static final String historiaDoenca = "HISTORIA_DOENCA_ATUAL";
    public static final String interrogatorio = "INTERROGATORIO";
    public static final String percepcao = "PERCEPCAO_PACIENTE";
    public static final String dataEdicao = "DATA_EDICAO";

}
