package br.uninove.primeiraconsulta.dao.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbExameFisico;
import br.uninove.primeiraconsulta.database.log.DbLogExameFisico;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 19/11/2016.
 */

public class LogExameFisicoDao {

    public static void salvar(ExameFisico exameFisico, Context context){
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        values.put(numProntuario, exameFisico.getNumProntuario());

        //EXAME FISICO

        values.put(sistole,exameFisico.getSistole());
        values.put(diastole,exameFisico.getDiastole());
        values.put(imc,exameFisico.getImc());
        values.put(cervical,exameFisico.getCervical());
        values.put(cintura,exameFisico.getCintura());
        values.put(quadril,exameFisico.getQuadril());
        values.put(snellenDireita,exameFisico.getSnellenDireita());
        values.put(snellenEsquerda,exameFisico.getSnellenEsquerda());
        values.put(paResultado,exameFisico.getPaResultado());
        values.put(imcResultado,exameFisico.getImcResultado());
        values.put(cervicalResultado,exameFisico.getCervicalResultado());
        values.put(cinturaresultado,exameFisico.getCinturaResultado());
        values.put(quadrilResultado,exameFisico.getQuadrilResultado());
        values.put(snellenResultado,exameFisico.getSnellenResultado());
        values.put(comentario,exameFisico.getComentario());



        db.insert(DbLogExameFisico.EXAME_FISICO_TB_NAME, null, values);

        db.close();
    }

    public static List<ExameFisico> buscarTodosProntuarios(Context context){
        List<ExameFisico> lista = new ArrayList<>();

        String sql = "select * from " + DbLogExameFisico.EXAME_FISICO_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                ExameFisico exameFisico = new ExameFisico();
                exameFisico.setId(cursor.getLong(ID));
                exameFisico.setNumProntuario(cursor.getString(NUM_PRONTUARIO));

                //EXAME FISICO

                exameFisico.setSistole(cursor.getInt(SISTOLE));
                exameFisico.setDiastole(cursor.getInt(DIASTOLE));
                exameFisico.setImc(cursor.getFloat(IMC));
                exameFisico.setCervical(cursor.getInt(CERVICAL));
                exameFisico.setCintura(cursor.getInt(CINTURA));
                exameFisico.setQuadril(cursor.getFloat(QUADRIL));
                exameFisico.setSnellenDireita(cursor.getInt(SNELLEN_DIREITA));
                exameFisico.setSnellenEsquerda(cursor.getInt(SNELLEN_ESQUERDA));
                exameFisico.setPaResultado(cursor.getString(PA_RESULTADO));
                exameFisico.setImcResultado(cursor.getString(IMC_RESULTADO));
                exameFisico.setCervicalResultado(cursor.getString(CERVICAL_RESULTADO));
                exameFisico.setCinturaResultado(cursor.getString(CINTURA_RESULTADO));
                exameFisico.setQuadrilResultado(cursor.getString(QUADRIL_RESULTADO));
                exameFisico.setSnellenResultado(cursor.getString(SNELLEN_RESULTADO));
                exameFisico.setComentario(cursor.getString(COMENTARIO));

                lista.add(exameFisico);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;
    }

    public static ExameFisico buscarPorNumProntuario(Prontuario p, Context context){
        List<ExameFisico> lista = new ArrayList<>();

        String sql = "select * from " + DbLogExameFisico.EXAME_FISICO_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                ExameFisico exameFisico = new ExameFisico();
                exameFisico.setId(cursor.getLong(ID));
                exameFisico.setNumProntuario(cursor.getString(NUM_PRONTUARIO));

                //EXAME FISICO

                exameFisico.setSistole(cursor.getInt(SISTOLE));
                exameFisico.setDiastole(cursor.getInt(DIASTOLE));
                exameFisico.setImc(cursor.getFloat(IMC));
                exameFisico.setCervical(cursor.getInt(CERVICAL));
                exameFisico.setCintura(cursor.getInt(CINTURA));
                exameFisico.setQuadril(cursor.getFloat(QUADRIL));
                exameFisico.setSnellenDireita(cursor.getInt(SNELLEN_DIREITA));
                exameFisico.setSnellenEsquerda(cursor.getInt(SNELLEN_ESQUERDA));
                exameFisico.setPaResultado(cursor.getString(PA_RESULTADO));
                exameFisico.setImcResultado(cursor.getString(IMC_RESULTADO));
                exameFisico.setCervicalResultado(cursor.getString(CERVICAL_RESULTADO));
                exameFisico.setCinturaResultado(cursor.getString(CINTURA_RESULTADO));
                exameFisico.setQuadrilResultado(cursor.getString(QUADRIL_RESULTADO));
                exameFisico.setSnellenResultado(cursor.getString(SNELLEN_RESULTADO));
                exameFisico.setComentario(cursor.getString(COMENTARIO));

                lista.add(exameFisico);

            }while(cursor.moveToNext());
        }

        for (ExameFisico exame : lista) {
            if(p.getNumProntuario().equals(exame.getNumProntuario())){
                return exame;
            }
        }

        db.close();
        return null;
    }

    public static ExameFisico buscarPorId(Long id, Context context){

        String sql = "select * from " + DbLogExameFisico.EXAME_FISICO_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                ExameFisico exameFisico = new ExameFisico();
                exameFisico.setId(cursor.getLong(ID));
                exameFisico.setNumProntuario(cursor.getString(NUM_PRONTUARIO));

                //EXAME FISICO

                exameFisico.setSistole(cursor.getInt(SISTOLE));
                exameFisico.setDiastole(cursor.getInt(DIASTOLE));
                exameFisico.setImc(cursor.getFloat(IMC));
                exameFisico.setCervical(cursor.getInt(CERVICAL));
                exameFisico.setCintura(cursor.getInt(CINTURA));
                exameFisico.setQuadril(cursor.getFloat(QUADRIL));
                exameFisico.setSnellenDireita(cursor.getInt(SNELLEN_DIREITA));
                exameFisico.setSnellenEsquerda(cursor.getInt(SNELLEN_ESQUERDA));
                exameFisico.setPaResultado(cursor.getString(PA_RESULTADO));
                exameFisico.setImcResultado(cursor.getString(IMC_RESULTADO));
                exameFisico.setCervicalResultado(cursor.getString(CERVICAL_RESULTADO));
                exameFisico.setCinturaResultado(cursor.getString(CINTURA_RESULTADO));
                exameFisico.setQuadrilResultado(cursor.getString(QUADRIL_RESULTADO));
                exameFisico.setSnellenResultado(cursor.getString(SNELLEN_RESULTADO));
                exameFisico.setComentario(cursor.getString(COMENTARIO));
                db.close();
                return exameFisico;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }


    public static void excluirExameFisico(ExameFisico exameFisico, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbLogExameFisico.EXAME_FISICO_TB_NAME, "id =?", new String[]{exameFisico.getId().toString()});
        db.close();
    }

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int SISTOLE = 2;
    public static final int DIASTOLE = 3;
    public static final int IMC = 4;
    public static final int CERVICAL = 5;
    public static final int CINTURA = 6;
    public static final int QUADRIL = 7;
    public static final int SNELLEN_DIREITA = 8;
    public static final int SNELLEN_ESQUERDA = 9;
    public static final int PA_RESULTADO = 10;
    public static final int IMC_RESULTADO = 11;
    public static final int CERVICAL_RESULTADO = 12;
    public static final int CINTURA_RESULTADO = 13;
    public static final int QUADRIL_RESULTADO = 14;
    public static final int SNELLEN_RESULTADO = 15;
    public static final int COMENTARIO = 16;

    public static final String id = "id";
    public static final String numProntuario = "num_prontuario";
    public static final String sistole = "sistole";
    public static final String diastole = "diastole";
    public static final String imc = "imc";
    public static final String cervical = "cervical";
    public static final String cintura = "cintura";
    public static final String quadril = "quadril";
    public static final String snellenDireita = "snellen_direita";
    public static final String snellenEsquerda = "snellen_esquerda";
    public static final String paResultado = "pa_resultado";
    public static final String imcResultado = "imc_resultado";
    public static final String cervicalResultado = "cervical_resultado";
    public static final String cinturaresultado = "cintura_resultado";
    public static final String quadrilResultado = "quadril_resultado";
    public static final String snellenResultado = "snellen_resultado";
    public static final String comentario = "comentario";

}
