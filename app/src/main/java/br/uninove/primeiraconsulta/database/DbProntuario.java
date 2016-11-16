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
            "USUARIO_RA TEXT NOT NULL," +
            "NOME_MEDICO TEXT NOT NULL," +
            "SEXO TEXT NOT NULL," +
            "IDADE INTEGER NOT NULL," +
            "PESO INTEGER NOT NULL," +
            "ALTURA REAL NOT NULL," +
            "COMENTARIO_FINAL TEXT," +
            "GORDURA_OPT INTEGER," +
            "GORDURA TEXT," +
            "FIBRA_OPT INTEGER," +
            "FIBRA TEXT," +
            "CALCIO_OPT INTEGER," +
            "CALCIO TEXT," +
            "SODIO_OPT INTEGER," +
            "SODIO TEXT," +
            "ACUCAR_OPT INTEGER," +
            "ACUCAR TEXT," +
            "REFRI_OPT INTEGER," +
            "REFRI TEXT," +
            "AGUA_OPT INTEGER," +
            "AGUA TEXT," +
            "ATFISICA_OPT INTEGER," +
            "ATFISICA TEXT," +
            "SONO_OPT_1 INTEGER," +
            "SONO_OPT_2 INTEGER," +
            "SONO_OPT_3 INTEGER," +
            "SONO_OPT_4 INTEGER," +
            "SONO_OPT_5 INTEGER," +
            "SONO_OPT_6 INTEGER," +
            "SONO_PONTOS INTEGER," +
            "SONO TEXT," +
            "CIGARRO_ATIVO_OPT INTEGER," +
            "CIGARRO_OPT_1 INTEGER," +
            "CIGARRO_1 TEXT," +
            "CIGARRO_OPT_2 INTEGER," +
            "CIGARRO_2 TEXT," +
            "CIGARRO_OPT_3 INTEGER," +
            "CIGARRO_3 TEXT," +
            "CIGARRO_OPT_4 INTEGER," +
            "CIGARRO_4 TEXT," +
            "CIGARRO_OPT_5 INTEGER," +
            "CIGARRO_5 TEXT," +
            "CIGARRO_OPT_6 INTEGER," +
            "CIGARRO_6 TEXT," +
            "CIGARRO_PONTOS INTEGER," +
            "CIGARRO TEXT," +
            "FOREIGN KEY(USUARIO_ID) REFERENCES "+DbUsuario.USUARIO_TB_NAME+"" +
            ")";
    public static final String PRONTUARIO_DROP_TB = "DROP TABLE IF EXISTS "+PRONTUARIO_TB_NAME;


}
