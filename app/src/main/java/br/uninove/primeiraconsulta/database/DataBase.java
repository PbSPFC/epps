package br.uninove.primeiraconsulta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.entidade.Status;
import br.uninove.primeiraconsulta.entidade.Usuario;

/**
 * Created by PB on 09/11/2016.
 */

public class DataBase extends SQLiteOpenHelper {


    private static final String NOME_DB = "PRIMEIRA_CONSULTA_DB";
    private static final int VERSAO_DB = 28;

    public DataBase(Context context) {
        super(context, NOME_DB, null, VERSAO_DB
        );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbStatus.CREATE_TB_STATUS);
        db.execSQL(DbUsuario.CREATE_TB_USUARIO);
        db.execSQL(DbStatus.STATUS_INSERT_PROFESSOR);
        db.execSQL(DbStatus.STATUS_INSERT_ALUNO);
        db.execSQL(DbProntuario.CREATE_PRONTUARIO);
        db.execSQL(DbEstiloDeVida.CREATE_ESTILO_DE_VIDA);
        db.execSQL(DbExameFisico.CREATE_EXAME_FISICO);
        db.execSQL(DbAnamnese.CREATE_TB_ANAMNESE);
        db.execSQL(DbListaProblemas.CREATE_TB_LISTA_PROBLEMAS);
        db.execSQL(DbUsuario.USUARIO_INSERT);
        db.execSQL(DbUsuario.USUARIO_INSERT_LUIS_FABIANO);
        db.execSQL(DbUsuario.USUARIO_INSERT_BERMUDINHA_DO_PATRICK);
        db.execSQL(DbUsuario.USUARIO_INSERT_PB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DbStatus.STATUS_DROP_TB);
        db.execSQL(DbUsuario.USUARIO_DROP_TB);
        db.execSQL(DbAnamnese.ANAMNESE_DROP_TB);
        db.execSQL(DbEstiloDeVida.ESTILO_DE_VIDA_DROP_TB);
        db.execSQL(DbExameFisico.EXAME_FISICO_DROP_TB);
        db.execSQL(DbProntuario.PRONTUARIO_DROP_TB);
        db.execSQL(DbListaProblemas.CREATE_TB_LISTA_PROBLEMAS);

        onCreate(db);
    }

}
