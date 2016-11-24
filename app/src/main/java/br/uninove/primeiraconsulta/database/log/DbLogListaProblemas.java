package br.uninove.primeiraconsulta.database.log;

/**
 * Created by PB on 21/11/2016.
 */

public class DbLogListaProblemas {

    public static final String LISTA_PROBLEMAS_TB_NAME = "LOG_LISTA_PROBLEMAS";

    public static final String CREATE_TB_LISTA_PROBLEMAS = "CREATE TABLE IF NOT EXISTS " + LISTA_PROBLEMAS_TB_NAME +
            " (" +
            "ID INTEGER PRIMARY KEY," +
            "NUM_PRONTUARIO TEXT NOT NULL," +
            "DESCRICAO TEXT," +
            "ACAO TEXT," +
            "DATA_EDICAO TEXT" +
            ")";

    public static final String LISTA_PROBLEMAS_DROP_TB = "DROP TABLE IF EXISTS " + LISTA_PROBLEMAS_TB_NAME;

}
