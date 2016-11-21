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
            "USUARIO_ID INTEGER NOT NULL," +
            "USUARIO_RA TEXT NOT NULL," +
            "NOME_MEDICO TEXT NOT NULL," +
            "SEXO TEXT NOT NULL," +
            "IDADE INTEGER NOT NULL," +
            "PESO INTEGER NOT NULL," +
            "ALTURA REAL NOT NULL," +
            "COMENTARIO_FINAL TEXT," +
            "ID_ESTILO_DE_VIDA INTEGER NOT NULL," +
            "ID_EXAME_FISICO INTEGER NOT NULL," +
            "ID_ANAMNESE INTEGER NOT NULL," +

            "FOREIGN KEY(USUARIO_ID) REFERENCES "+DbUsuario.USUARIO_TB_NAME+"," +
            "FOREIGN KEY(ID_ESTILO_DE_VIDA) REFERENCES "+DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME+"," +
            "FOREIGN KEY(ID_EXAME_FISICO) REFERENCES "+DbExameFisico.EXAME_FISICO_TB_NAME+", " +
            "FOREIGN KEY(ID_ANAMNESE) REFERENCES "+DbAnamnese.ANAMNESE_TB_NAME+"" +
            ")";
    public static final String PRONTUARIO_DROP_TB = "DROP TABLE IF EXISTS "+PRONTUARIO_TB_NAME;


}
