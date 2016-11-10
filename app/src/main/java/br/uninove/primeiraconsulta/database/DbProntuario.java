package br.uninove.primeiraconsulta.database;

/**
 * Created by PB on 09/11/2016.
 */

public class DbProntuario {

    public static final String PRONTUARIO_TB_NAME = "PRONTUARIO";
    public static final String CREATE_PRONTUARIO = "CREATE TABLE IF NOT EXISTS "+PRONTUARIO_TB_NAME+" " +
            "(" +
            "ID INTEGER PRIMARY KEY," +
            "NUM_PRONTUARIO TEXT NOT NULL," +
            "NOME_PACIENTE TEXT NOT NULL," +
            "USUARIO_ID INTEGER NOT NULL," +
            "NOME_MEDICO TEXT NOT NULL," +
            "SEXO TEXT NOT NULL," +
            "IDADE INTEGER NOT NULL," +
            "PESO INTEGER NOT NULL," +
            "ALTURA REAL NOT NULL," +
            "COMENTARIO_FINAL TEXT," +
            "FOREIGN KEY(USUARIO_ID) REFERENCES "+DbUsuario.USUARIO_TB_NAME+"" +
            ")";
    public static final String PRONTUARIO_DROP_TB = "DROP TABLE IF EXISTS "+PRONTUARIO_TB_NAME;


}
