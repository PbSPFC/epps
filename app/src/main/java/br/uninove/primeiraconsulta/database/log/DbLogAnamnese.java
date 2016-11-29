package br.uninove.primeiraconsulta.database.log;

/**
 * Created by PB on 20/11/2016.
 */

public class DbLogAnamnese {

    public static final String ANAMNESE_TB_NAME = "LOG_ANAMNESE";

    public static final String CREATE_TB_ANAMNESE = "CREATE TABLE IF NOT EXISTS " + ANAMNESE_TB_NAME +
            "(" +
            "ID INTEGER PRIMARY KEY," +
            "NUM_PRONTUARIO TEXT NOT NULL," +
            "QUEIXA_DURACAO TEXT," +
            "HISTORIA_DOENCA_ATUAL TEXT," +
            "INTERROGATORIO TEXT," +
            "PERCEPCAO_PACIENTE TEXT," +
            "DATA_EDICAO TEXT" +
            ")";


    public static final String ANAMNESE_DROP_TB = "DROP TABLE IF EXISTS " + ANAMNESE_TB_NAME;

}
