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
            "EMAIL TEXT NOT NULL," +
            "STATUS_ID INTEGER NOT NULL," +
            "FOREIGN KEY(STATUS_ID) REFERENCES " + DbStatus.STATUS_TB_NAME +
            ")";

    public static final String USUARIO_DROP_TB = "DROP TABLE IF EXISTS " + USUARIO_TB_NAME;

    public static final String USUARIO_INSERT = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'123456', '123', 'Espadilha', 'espadilha@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_LUIS_FABIANO = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'321', '123', 'Luis Fabiano', 'lf9@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_BERMUDINHA_DO_PATRICK = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'1111', '123', 'Bermudinha Do Patrick', 'bermudinhadopatrick@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_REGIS_TADEU = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'666', '123', 'Regis Tadeu', 'registadeu@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_GANSO = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'10', '123', 'Paulo Henrique Ganso', 'phGanshow@email.com', 1" +
            ")";

    public static final String USUARIO_INSERT_LINEU = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'444', '123', 'Lineu', 'aosomdagrandefamilia@email.com', 1" +
            ")";

    public static final String USUARIO_INSERT_BARBA_MAN = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'333', '123', 'BarbaMan (Kbooom)', 'explodindo@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_RAFAEL = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'111', '123', 'Rafael', 'rafael@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_DEBORA = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'123', '123', 'Débora', 'debora@email.com', 1" +
            ")";
    public static final String USUARIO_INSERT_PB = "INSERT INTO " + USUARIO_TB_NAME + "(RA, SENHA, NOME," +
            "EMAIL, STATUS_ID) VALUES" +
            "(" +
            "'11', '123', 'Pb (Saiyajin)', 'pb_nogueira@hotmail.com', 1" +
            ")";
}
