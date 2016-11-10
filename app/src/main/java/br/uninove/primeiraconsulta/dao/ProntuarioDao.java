package br.uninove.primeiraconsulta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbProntuario;
import br.uninove.primeiraconsulta.database.DbUsuario;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 09/11/2016.
 */

public class ProntuarioDao {

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int NOME_PACIENTE = 2;
    public static final int USUARIO_ID = 3;
    public static final int USUARIO_RA = 4;
    public static final int NOME_MEDICO = 5;
    public static final int SEXO = 6;
    public static final int IDADE = 7;
    public static final int PESO = 8;
    public static final int ALTURA = 9;
    public static final int COMENTARIO_FINAL = 10;

    public static final String id = "id";
    public static final String numProntuario = "num_prontuario";
    public static final String nomePaciente = "nome_paciente";
    public static final String usuarioId = "usuario_id";
    public static final String usuarioRa = "usuario_ra";
    public static final String nomeMedico = "nome_medico";
    public static final String sexo = "sexo";
    public static final String idade = "idade";
    public static final String peso = "peso";
    public static final String altura = "altura";
    public static final String comentarioFinal = "comentario_final";

    public static void salvar(Prontuario prontuario, Context context){
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        values.put(numProntuario, prontuario.getNumProntuario());
        values.put(nomePaciente, prontuario.getNomePaciente());
        values.put(usuarioId, prontuario.getIdUsuario());
        values.put(usuarioRa, prontuario.getRaUsuario());
        values.put(nomeMedico, prontuario.getNomeMedico());
        values.put(sexo, prontuario.getSexo());
        values.put(idade, prontuario.getIdade());
        values.put(peso, prontuario.getPeso());
        values.put(altura, prontuario.getAltura());
        values.put(comentarioFinal, prontuario.getComentario());
        //Verificando se ira fazer udpate ou insert
        if(prontuario.getId()==null) {
            db.insert(DbProntuario.PRONTUARIO_TB_NAME, null, values);
            System.out.println("Nome do Médico: " + prontuario.getNomeMedico());
            System.out.println("Ra: " + prontuario.getRaUsuario());
        }else{
            db.update(DbProntuario.PRONTUARIO_TB_NAME, values, "id = ?", new String[]{prontuario.getId().toString()});
        }
        db.close();
    }

    public static List<Prontuario> buscarTodosProntuarios(Context context){
        List<Prontuario> lista = new ArrayList<>();

        String sql = "select * from " + DbProntuario.PRONTUARIO_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Prontuario prontuario = new Prontuario();
                prontuario.setId(cursor.getLong(ID));
                prontuario.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                prontuario.setNomePaciente(cursor.getString(NOME_PACIENTE));
                prontuario.setIdUsuario(cursor.getLong(USUARIO_ID));
                prontuario.setRaUsuario(cursor.getString(USUARIO_RA));
                prontuario.setNomeMedico(cursor.getString(NOME_MEDICO));
                prontuario.setSexo(cursor.getString(SEXO));
                prontuario.setIdade(cursor.getInt(IDADE));
                prontuario.setPeso(cursor.getInt(PESO));
                prontuario.setAltura(cursor.getFloat(ALTURA));
                prontuario.setComentario(cursor.getString(COMENTARIO_FINAL));

                lista.add(prontuario);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;
    }

    public static List<Prontuario> buscarTodosPorIdUsuario(Long idUsuario, Context context) {

        List<Prontuario> lista = new ArrayList<>();

        String sql = "select * from " + DbProntuario.PRONTUARIO_TB_NAME + " where USUARIO_ID = " + idUsuario;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Prontuario prontuario = new Prontuario();
                prontuario.setId(cursor.getLong(ID));
                prontuario.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                prontuario.setNomePaciente(cursor.getString(NOME_PACIENTE));
                prontuario.setIdUsuario(cursor.getLong(USUARIO_ID));
                prontuario.setRaUsuario(cursor.getString(USUARIO_RA));
                prontuario.setNomeMedico(cursor.getString(NOME_MEDICO));
                prontuario.setSexo(cursor.getString(SEXO));
                prontuario.setIdade(cursor.getInt(IDADE));
                prontuario.setPeso(cursor.getInt(PESO));
                prontuario.setAltura(cursor.getFloat(ALTURA));
                prontuario.setComentario(cursor.getString(COMENTARIO_FINAL));

                lista.add(prontuario);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;

    }


    public static void excluirProntuario(Prontuario prontuario, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbProntuario.PRONTUARIO_TB_NAME, "id=?", new String[]{prontuario.getId() + ""});
        System.out.println("Paciente: " + prontuario.getNomePaciente());
        db.close();
    }

    public static Prontuario buscaPorNumProntuario(String numPront, Context context){

        String sql = "select * from " + DbProntuario.PRONTUARIO_TB_NAME + " where NUM_PRONTUARIO = " + numPront;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Prontuario prontuario = new Prontuario();
                prontuario.setId(cursor.getLong(ID));
                prontuario.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                prontuario.setNomePaciente(cursor.getString(NOME_PACIENTE));
                prontuario.setIdUsuario(cursor.getLong(USUARIO_ID));
                prontuario.setRaUsuario(cursor.getString(USUARIO_RA));
                prontuario.setNomeMedico(cursor.getString(NOME_MEDICO));
                prontuario.setSexo(cursor.getString(SEXO));
                prontuario.setIdade(cursor.getInt(IDADE));
                prontuario.setPeso(cursor.getInt(PESO));
                prontuario.setAltura(cursor.getFloat(ALTURA));
                prontuario.setComentario(cursor.getString(COMENTARIO_FINAL));

                db.close();
                return prontuario;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }


}
