package br.uninove.primeiraconsulta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 09/11/2016.
 */

public class DbUsuario {

    public static final String USUARIO_TB_NAME = "USUARIO";
    public static final String CREATE_TB_USUARIO = "CREATE TABLE IF NOT EXISTS " + USUARIO_TB_NAME +
            " (" +
            "ID INTEGER PRIMARY KEY," +
            "RA TEXT NOT NULL," +
            "SENHA TEXT NOT NULL," +
            "NOME TEXT NOT NULL," +
            "STATUS_ID INTEGER NOT NULL," +
            "FOREIGN KEY(STATUS_ID) REFERENCES " + DbStatus.STATUS_TB_NAME +
            ")";

    public static final String USUARIO_INSERT = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "STATUS_ID) VALUES" +
            "(" +
            "'123456', '123', 'Espadilha', 1" +
            ")";
    public static final String USUARIO_DROP_TB = "DROP TABLE IF EXISTS " + USUARIO_TB_NAME;

}
