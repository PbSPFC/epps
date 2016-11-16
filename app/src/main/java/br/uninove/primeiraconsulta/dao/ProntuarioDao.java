package br.uninove.primeiraconsulta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbProntuario;
import br.uninove.primeiraconsulta.database.DbUsuario;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 09/11/2016.
 */

public class ProntuarioDao {

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int NOME_PACIENTE = 2;
    public static final int USUARIO_ID = 3;
    public static final int USUARIO_RA = 4;
    public static final int NOME_MEDICO = 5;
    public static final int SEXO = 6;
    public static final int IDADE = 7;
    public static final int PESO = 8;
    public static final int ALTURA = 9;
    public static final int COMENTARIO_FINAL = 10;
    public static final int GORDURA_OPT = 11;
    public static final int GORDURA = 12;
    public static final int FIBRA_OPT = 13;
    public static final int FIBRA = 14;
    public static final int CALCIO_OPT = 15;
    public static final int CALCIO = 16;
    public static final int SODIO_OPT = 17;
    public static final int SODIO = 18;
    public static final int ACUCAR_OPT = 19;
    public static final int ACUCAR = 20;
    public static final int REFRI_OPT = 21;
    public static final int REFRI = 22;
    public static final int AGUA_OPT = 23;
    public static final int AGUA = 24;
    public static final int ATFISICA_OPT = 25;
    public static final int ATFISICA = 26;
    public static final int SONO_OPT_1 = 27;
    public static final int SONO_OPT_2 = 28;
    public static final int SONO_OPT_3 = 29;
    public static final int SONO_OPT_4 = 30;
    public static final int SONO_OPT_5 = 31;
    public static final int SONO_OPT_6 = 32;
    public static final int SONO_PONTOS = 33;
    public static final int SONO = 34;
    public static final int CIGARRO_ATIVO_OPT = 35;
    public static final int CIGARRO_OPT_1 = 36;
    public static final int CIGARRO_1 = 37;
    public static final int CIGARRO_OPT_2 = 38;
    public static final int CIGARRO_2 = 39;
    public static final int CIGARRO_OPT_3 = 40;
    public static final int CIGARRO_3 = 41;
    public static final int CIGARRO_OPT_4 = 42;
    public static final int CIGARRO_4 = 43;
    public static final int CIGARRO_OPT_5 = 44;
    public static final int CIGARRO_5 = 45;
    public static final int CIGARRO_OPT_6 = 46;
    public static final int CIGARRO_6 = 47;
    public static final int CIGARRO_PONTOS = 48;
    public static final int CIGARRO = 49;


    public static final String id = "id";
    public static final String numProntuario = "num_prontuario";
    public static final String nomePaciente = "nome_paciente";
    public static final String usuarioId = "usuario_id";
    public static final String usuarioRa = "usuario_ra";
    public static final String nomeMedico = "nome_medico";
    public static final String sexo = "sexo";
    public static final String idade = "idade";
    public static final String peso = "peso";
    public static final String altura = "altura";
    public static final String comentarioFinal = "comentario_final";
    public static final String gorduraOpt = "gordura_opt";
    public static final String gorduraResul = "gordura";
    public static final String fibraOpt = "fibra_opt";
    public static final String fibra = "fibra";
    public static final String calcioOpt = "calcio_opt";
    public static final String calcio = "calcio";
    public static final String sodioOpt = "sodio_opt";
    public static final String sodio = "sodio";
    public static final String acucarOpt = "acucar_opt";
    public static final String acucar = "acucar";
    public static final String refriOpt = "refri_opt";
    public static final String refri = "refri";
    public static final String aguaOpt = "agua_opt";
    public static final String agua = "agua";
    public static final String atFisicaOpt = "atfisica_opt";
    public static final String atFisica = "atfisica";
    public static final String sonoOpt1 = "sono_opt_1";
    public static final String sonoOpt2 = "sono_opt_2";
    public static final String sonoOpt3 = "sono_opt_3";
    public static final String sonoOpt4 = "sono_opt_4";
    public static final String sonoOpt5 = "sono_opt_5";
    public static final String sonoOpt6 = "sono_opt_6";
    public static final String sonoPontos = "sono_pontos";
    public static final String sono = "sono";
    public static final String cigarroAtivoOpt = "cigarro_ativo_opt";
    public static final String cigarroOpt1 = "cigarro_opt_1";
    public static final String cigarro1 = "cigarro_1";
    public static final String cigarroOpt2 = "cigarro_opt_2";
    public static final String cigarro2 = "cigarro_2";
    public static final String cigarroOpt3 = "cigarro_opt_3";
    public static final String cigarro3 = "cigarro_3";
    public static final String cigarroOpt4 = "cigarro_opt_4";
    public static final String cigarro4 = "cigarro_4";
    public static final String cigarroOpt5 = "cigarro_opt_5";
    public static final String cigarro5 = "cigarro_5";
    public static final String cigarroOpt6 = "cigarro_opt_6";
    public static final String cigarro6 = "cigarro_6";
    public static final String cigarroPontos = "cigarro_pontos";
    public static final String cigarro = "cigarro";

    public static void salvar(Prontuario prontuario, Context context){
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        values.put(numProntuario, prontuario.getNumProntuario());
        values.put(nomePaciente, prontuario.getNomePaciente());
        values.put(usuarioId, prontuario.getIdUsuario());
        values.put(usuarioRa, prontuario.getRaUsuario());
        values.put(nomeMedico, prontuario.getNomeMedico());
        values.put(sexo, prontuario.getSexo());
        values.put(idade, prontuario.getIdade());
        values.put(peso, prontuario.getPeso());
        values.put(altura, prontuario.getAltura());
        values.put(comentarioFinal, prontuario.getComentario());
        values.put(gorduraOpt, prontuario.getGorduraOpt());
        values.put(gorduraResul, prontuario.getGordura());
        values.put(fibraOpt, prontuario.getFibraOpt());
        values.put(fibra, prontuario.getFibra());
        values.put(calcioOpt, prontuario.getCalcioOpt());
        values.put(calcio, prontuario.getCalcio());
        values.put(sodioOpt, prontuario.getSodioOpt());
        values.put(sodio, prontuario.getSodio());
        values.put(acucarOpt, prontuario.getAcucarOpt());
        values.put(acucar, prontuario.getAcucar());
        values.put(refriOpt, prontuario.getRefriOpt());
        values.put(refri, prontuario.getRefri());
        values.put(aguaOpt, prontuario.getAguaOpt());
        values.put(agua, prontuario.getAgua());
        values.put(atFisicaOpt, prontuario.getAtFisicaOpt());
        values.put(atFisica, prontuario.getAtFisica());
        values.put(sonoOpt1, prontuario.getSonoOpt1());
        values.put(sonoOpt2, prontuario.getSonoOpt2());
        values.put(sonoOpt3, prontuario.getSonoOpt3());
        values.put(sonoOpt4, prontuario.getSonoOpt4());
        values.put(sonoOpt5, prontuario.getSonoOpt5());
        values.put(sonoOpt6, prontuario.getSonoOpt6());
        values.put(sonoPontos, prontuario.getSonoPontos());
        values.put(sono, prontuario.getSono());
        values.put(cigarroAtivoOpt, prontuario.getCigarroAtivoOpt());
        values.put(cigarroOpt1, prontuario.getCigarroOpt1());
        values.put(cigarro1, prontuario.getCigarro1());
        values.put(cigarroOpt2, prontuario.getCigarroOpt2());
        values.put(cigarro2, prontuario.getCigarro2());
        values.put(cigarroOpt3, prontuario.getCigarroOpt3());
        values.put(cigarro3, prontuario.getCigarro3());
        values.put(cigarroOpt4, prontuario.getCigarroOpt4());
        values.put(cigarro4, prontuario.getCigarro4());
        values.put(cigarroOpt5, prontuario.getCigarroOpt5());
        values.put(cigarro5, prontuario.getCigarro5());
        values.put(cigarroOpt6, prontuario.getCigarroOpt6());
        values.put(cigarro6, prontuario.getCigarro6());
        values.put(cigarroPontos, prontuario.getCigarroPontos());
        values.put(cigarro, prontuario.getCigarro());

        //Verificando se ira fazer udpate ou insert
        if(prontuario.getId()==null) {
            db.insert(DbProntuario.PRONTUARIO_TB_NAME, null, values);
            System.out.println("Nome do Médico: " + prontuario.getNomeMedico());
            System.out.println("Ra: " + prontuario.getRaUsuario());
        }else{
            db.update(DbProntuario.PRONTUARIO_TB_NAME, values, "id = ?", new String[]{prontuario.getId().toString()});
        }
        db.close();
    }

    public static List<Prontuario> buscarTodosProntuarios(Context context){
        List<Prontuario> lista = new ArrayList<>();

        String sql = "select * from " + DbProntuario.PRONTUARIO_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Prontuario prontuario = new Prontuario();
                prontuario.setId(cursor.getLong(ID));
                prontuario.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                prontuario.setNomePaciente(cursor.getString(NOME_PACIENTE));
                prontuario.setIdUsuario(cursor.getLong(USUARIO_ID));
                prontuario.setRaUsuario(cursor.getString(USUARIO_RA));
                prontuario.setNomeMedico(cursor.getString(NOME_MEDICO));
                prontuario.setSexo(cursor.getString(SEXO));
                prontuario.setIdade(cursor.getInt(IDADE));
                prontuario.setPeso(cursor.getInt(PESO));
                prontuario.setAltura(cursor.getFloat(ALTURA));
                prontuario.setComentario(cursor.getString(COMENTARIO_FINAL));
                prontuario.setGorduraOpt(cursor.getInt(GORDURA_OPT));
                prontuario.setGordura(cursor.getString(GORDURA));
                prontuario.setFibraOpt(cursor.getInt(FIBRA_OPT));
                prontuario.setFibra(cursor.getString(FIBRA));
                prontuario.setCalcioOpt(cursor.getInt(CALCIO_OPT));
                prontuario.setCalcio(cursor.getString(CALCIO));
                prontuario.setSodioOpt(cursor.getInt(SODIO_OPT));
                prontuario.setSodio(cursor.getString(SODIO));
                prontuario.setAcucarOpt(cursor.getInt(ACUCAR_OPT));
                prontuario.setAcucar(cursor.getString(ACUCAR));
                prontuario.setRefriOpt(cursor.getInt(REFRI_OPT));
                prontuario.setRefri(cursor.getString(REFRI));
                prontuario.setAguaOpt(cursor.getInt(AGUA_OPT));
                prontuario.setAgua(cursor.getString(AGUA));
                prontuario.setAtFisicaOpt(cursor.getInt(ATFISICA_OPT));
                prontuario.setAtFisica(cursor.getString(ATFISICA));
                prontuario.setSonoOpt1(cursor.getInt(SONO_OPT_1));
                prontuario.setSonoOpt2(cursor.getInt(SONO_OPT_2));
                prontuario.setSonoOpt3(cursor.getInt(SONO_OPT_3));
                prontuario.setSonoOpt4(cursor.getInt(SONO_OPT_4));
                prontuario.setSonoOpt5(cursor.getInt(SONO_OPT_5));
                prontuario.setSonoOpt6(cursor.getInt(SONO_OPT_6));
                prontuario.setSonoPontos(cursor.getInt(SONO_PONTOS));
                prontuario.setSono(cursor.getString(SONO));
                prontuario.setCigarroAtivoOpt(cursor.getInt(CIGARRO_ATIVO_OPT));
                prontuario.setCigarroOpt1(cursor.getInt(CIGARRO_OPT_1));
                prontuario.setCigarro1(cursor.getString(CIGARRO_1));
                prontuario.setCigarroOpt2(cursor.getInt(CIGARRO_OPT_2));
                prontuario.setCigarro2(cursor.getString(CIGARRO_2));
                prontuario.setCigarroOpt3(cursor.getInt(CIGARRO_OPT_3));
                prontuario.setCigarro3(cursor.getString(CIGARRO_3));
                prontuario.setCigarroOpt4(cursor.getInt(CIGARRO_OPT_4));
                prontuario.setCigarro4(cursor.getString(CIGARRO_4));
                prontuario.setCigarroOpt5(cursor.getInt(CIGARRO_OPT_5));
                prontuario.setCigarro5(cursor.getString(CIGARRO_5));
                prontuario.setCigarroOpt6(cursor.getInt(CIGARRO_OPT_6));
                prontuario.setCigarro6(cursor.getString(CIGARRO_6));
                prontuario.setCigarroPontos(cursor.getInt(CIGARRO_PONTOS));
                prontuario.setCigarro(cursor.getString(CIGARRO));

                lista.add(prontuario);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;
    }

    public static List<Prontuario> buscarTodosPorIdUsuario(Long idUsuario, Context context) {

        List<Prontuario> lista = new ArrayList<>();

        String sql = "select * from " + DbProntuario.PRONTUARIO_TB_NAME + " where USUARIO_ID = " + idUsuario;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Prontuario prontuario = new Prontuario();
                prontuario.setId(cursor.getLong(ID));
                prontuario.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                prontuario.setNomePaciente(cursor.getString(NOME_PACIENTE));
                prontuario.setIdUsuario(cursor.getLong(USUARIO_ID));
                prontuario.setRaUsuario(cursor.getString(USUARIO_RA));
                prontuario.setNomeMedico(cursor.getString(NOME_MEDICO));
                prontuario.setSexo(cursor.getString(SEXO));
                prontuario.setIdade(cursor.getInt(IDADE));
                prontuario.setPeso(cursor.getInt(PESO));
                prontuario.setAltura(cursor.getFloat(ALTURA));
                prontuario.setComentario(cursor.getString(COMENTARIO_FINAL));
                prontuario.setGorduraOpt(cursor.getInt(GORDURA_OPT));
                prontuario.setGordura(cursor.getString(GORDURA));
                prontuario.setFibraOpt(cursor.getInt(FIBRA_OPT));
                prontuario.setFibra(cursor.getString(FIBRA));
                prontuario.setCalcioOpt(cursor.getInt(CALCIO_OPT));
                prontuario.setCalcio(cursor.getString(CALCIO));
                prontuario.setSodioOpt(cursor.getInt(SODIO_OPT));
                prontuario.setSodio(cursor.getString(SODIO));
                prontuario.setAcucarOpt(cursor.getInt(ACUCAR_OPT));
                prontuario.setAcucar(cursor.getString(ACUCAR));
                prontuario.setRefriOpt(cursor.getInt(REFRI_OPT));
                prontuario.setRefri(cursor.getString(REFRI));
                prontuario.setAguaOpt(cursor.getInt(AGUA_OPT));
                prontuario.setAgua(cursor.getString(AGUA));
                prontuario.setAtFisicaOpt(cursor.getInt(ATFISICA_OPT));
                prontuario.setAtFisica(cursor.getString(ATFISICA));
                prontuario.setSonoOpt1(cursor.getInt(SONO_OPT_1));
                prontuario.setSonoOpt2(cursor.getInt(SONO_OPT_2));
                prontuario.setSonoOpt3(cursor.getInt(SONO_OPT_3));
                prontuario.setSonoOpt4(cursor.getInt(SONO_OPT_4));
                prontuario.setSonoOpt5(cursor.getInt(SONO_OPT_5));
                prontuario.setSonoOpt6(cursor.getInt(SONO_OPT_6));
                prontuario.setSonoPontos(cursor.getInt(SONO_PONTOS));
                prontuario.setSono(cursor.getString(SONO));
                prontuario.setCigarroAtivoOpt(cursor.getInt(CIGARRO_ATIVO_OPT));
                prontuario.setCigarroOpt1(cursor.getInt(CIGARRO_OPT_1));
                prontuario.setCigarro1(cursor.getString(CIGARRO_1));
                prontuario.setCigarroOpt2(cursor.getInt(CIGARRO_OPT_2));
                prontuario.setCigarro2(cursor.getString(CIGARRO_2));
                prontuario.setCigarroOpt3(cursor.getInt(CIGARRO_OPT_3));
                prontuario.setCigarro3(cursor.getString(CIGARRO_3));
                prontuario.setCigarroOpt4(cursor.getInt(CIGARRO_OPT_4));
                prontuario.setCigarro4(cursor.getString(CIGARRO_4));
                prontuario.setCigarroOpt5(cursor.getInt(CIGARRO_OPT_5));
                prontuario.setCigarro5(cursor.getString(CIGARRO_5));
                prontuario.setCigarroOpt6(cursor.getInt(CIGARRO_OPT_6));
                prontuario.setCigarro6(cursor.getString(CIGARRO_6));
                prontuario.setCigarroPontos(cursor.getInt(CIGARRO_PONTOS));
                prontuario.setCigarro(cursor.getString(CIGARRO));

                lista.add(prontuario);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;

    }


    public static void excluirProntuario(Prontuario prontuario, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbProntuario.PRONTUARIO_TB_NAME, "id=?", new String[]{prontuario.getId() + ""});
        System.out.println("Paciente: " + prontuario.getNomePaciente());
        db.close();
    }

    public static Prontuario buscaPorNumProntuario(String numPront, Context context){

        String sql = "select * from " + DbProntuario.PRONTUARIO_TB_NAME + " where NUM_PRONTUARIO = " + numPront;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Prontuario prontuario = new Prontuario();
                prontuario.setId(cursor.getLong(ID));
                prontuario.setNumProntuario(cursor.getString(NUM_PRONTUARIO));
                prontuario.setNomePaciente(cursor.getString(NOME_PACIENTE));
                prontuario.setIdUsuario(cursor.getLong(USUARIO_ID));
                prontuario.setRaUsuario(cursor.getString(USUARIO_RA));
                prontuario.setNomeMedico(cursor.getString(NOME_MEDICO));
                prontuario.setSexo(cursor.getString(SEXO));
                prontuario.setIdade(cursor.getInt(IDADE));
                prontuario.setPeso(cursor.getInt(PESO));
                prontuario.setAltura(cursor.getFloat(ALTURA));
                prontuario.setComentario(cursor.getString(COMENTARIO_FINAL));
                prontuario.setGorduraOpt(cursor.getInt(GORDURA_OPT));
                prontuario.setGordura(cursor.getString(GORDURA));
                prontuario.setFibraOpt(cursor.getInt(FIBRA_OPT));
                prontuario.setFibra(cursor.getString(FIBRA));
                prontuario.setCalcioOpt(cursor.getInt(CALCIO_OPT));
                prontuario.setCalcio(cursor.getString(CALCIO));
                prontuario.setSodioOpt(cursor.getInt(SODIO_OPT));
                prontuario.setSodio(cursor.getString(SODIO));
                prontuario.setAcucarOpt(cursor.getInt(ACUCAR_OPT));
                prontuario.setAcucar(cursor.getString(ACUCAR));
                prontuario.setRefriOpt(cursor.getInt(REFRI_OPT));
                prontuario.setRefri(cursor.getString(REFRI));
                prontuario.setAguaOpt(cursor.getInt(AGUA_OPT));
                prontuario.setAgua(cursor.getString(AGUA));
                prontuario.setAtFisicaOpt(cursor.getInt(ATFISICA_OPT));
                prontuario.setAtFisica(cursor.getString(ATFISICA));
                prontuario.setSonoOpt1(cursor.getInt(SONO_OPT_1));
                prontuario.setSonoOpt2(cursor.getInt(SONO_OPT_2));
                prontuario.setSonoOpt3(cursor.getInt(SONO_OPT_3));
                prontuario.setSonoOpt4(cursor.getInt(SONO_OPT_4));
                prontuario.setSonoOpt5(cursor.getInt(SONO_OPT_5));
                prontuario.setSonoOpt6(cursor.getInt(SONO_OPT_6));
                prontuario.setSonoPontos(cursor.getInt(SONO_PONTOS));
                prontuario.setSono(cursor.getString(SONO));
                prontuario.setCigarroAtivoOpt(cursor.getInt(CIGARRO_ATIVO_OPT));
                prontuario.setCigarroOpt1(cursor.getInt(CIGARRO_OPT_1));
                prontuario.setCigarro1(cursor.getString(CIGARRO_1));
                prontuario.setCigarroOpt2(cursor.getInt(CIGARRO_OPT_2));
                prontuario.setCigarro2(cursor.getString(CIGARRO_2));
                prontuario.setCigarroOpt3(cursor.getInt(CIGARRO_OPT_3));
                prontuario.setCigarro3(cursor.getString(CIGARRO_3));
                prontuario.setCigarroOpt4(cursor.getInt(CIGARRO_OPT_4));
                prontuario.setCigarro4(cursor.getString(CIGARRO_4));
                prontuario.setCigarroOpt5(cursor.getInt(CIGARRO_OPT_5));
                prontuario.setCigarro5(cursor.getString(CIGARRO_5));
                prontuario.setCigarroOpt6(cursor.getInt(CIGARRO_OPT_6));
                prontuario.setCigarro6(cursor.getString(CIGARRO_6));
                prontuario.setCigarroPontos(cursor.getInt(CIGARRO_PONTOS));
                prontuario.setCigarro(cursor.getString(CIGARRO));

                db.close();
                return prontuario;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }


}
