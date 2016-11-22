package br.uninove.primeiraconsulta.database;

/**
 * Created by PB on 19/11/2016.
 */

public class DbEstiloDeVida {

    public static final String ESTILO_DE_VIDA_TB_NAME = "ESTILO_DE_VIDA";
    public static final String CREATE_ESTILO_DE_VIDA = "CREATE TABLE IF NOT EXISTS "+ESTILO_DE_VIDA_TB_NAME+" " +
            "(" +
            "ID INTEGER PRIMARY KEY," +
            "NUM_PRONTUARIO TEXT NOT NULL," +

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
            "ALCOOL_ATIVO_OPT INTEGER," +
            "ALCOOL_OPT_1 INTEGER," +
            "ALCOOL_OPT_2 INTEGER," +
            "ALCOOL_OPT_3 INTEGER," +
            "ALCOOL_OPT_4 INTEGER," +
            "ALCOOL_1 TEXT," +
            "ALCOOL_2 TEXT," +
            "ALCOOL_3 TEXT," +
            "ALCOOL_4 TEXT," +
            "ALCOOL TEXT," +
            "SEXUALMENTE_ATIVO TEXT," +
            "SEXUALMENTE_ATIVO_OPT INTEGER" +
            ")";
    public static final String ESTILO_DE_VIDA_DROP_TB = "DROP TABLE IF EXISTS "+ESTILO_DE_VIDA_TB_NAME;

}
