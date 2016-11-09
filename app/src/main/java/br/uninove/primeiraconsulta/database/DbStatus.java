package br.uninove.primeiraconsulta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.uninove.primeiraconsulta.entidade.Status;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 09/11/2016.
 */

public class DbStatus {

    public static final String STATUS_TB_NAME = "STATUS";

    public static final String CREATE_TB_STATUS = "CREATE TABLE IF NOT EXISTS " + STATUS_TB_NAME +
            " (" +
            "ID INTEGER PRIMARY KEY," +
            "STATUS_NOME TEXT NOT NULL" +
            ")";

    public static final String STATUS_INSERT_PROFESSOR = "INSERT INTO " + STATUS_TB_NAME + " (STATUS_NOME) VALUES" +
            "('Professor')";
    public static final String STATUS_INSERT_ALUNO = "INSERT INTO " + STATUS_TB_NAME + " (STATUS_NOME) VALUES" +
            "('Aluno')";
    public static final String STATUS_DROP_TB = "DROP TABLE IF EXISTS " + STATUS_TB_NAME;



}
