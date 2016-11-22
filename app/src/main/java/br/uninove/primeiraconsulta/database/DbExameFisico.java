package br.uninove.primeiraconsulta.database;

/**
 * Created by PB on 19/11/2016.
 */

public class DbExameFisico {

    public static final String EXAME_FISICO_TB_NAME = "EXAME_FISICO";
    public static final String CREATE_EXAME_FISICO = "CREATE TABLE IF NOT EXISTS "+EXAME_FISICO_TB_NAME+" " +
            "(" +
            "ID INTEGER PRIMARY KEY," +
            "NUM_PRONTUARIO TEXT NOT NULL," +

            "SISTOLE INTEGER," +
            "DIASTOLE INTEGER," +
            "IMC REAL," +
            "CERVICAL INTEGER," +
            "CINTURA INTEGER," +
            "QUADRIL REAL," +
            "SNELLEN_DIREITA INTEGER," +
            "SNELLEN_ESQUERDA INTEGER," +
            "PA_RESULTADO TEXT," +
            "IMC_RESULTADO TEXT," +
            "CERVICAL_RESULTADO TEXT," +
            "CINTURA_RESULTADO TEXT," +
            "QUADRIL_RESULTADO TEXT," +
            "SNELLEN_RESULTADO TEXT," +
            "COMENTARIO TEXT" +
            ")";
    public static final String EXAME_FISICO_DROP_TB = "DROP TABLE IF EXISTS "+EXAME_FISICO_TB_NAME;

}
