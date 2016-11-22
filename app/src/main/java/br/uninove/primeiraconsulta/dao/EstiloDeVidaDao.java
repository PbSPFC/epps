package br.uninove.primeiraconsulta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.database.DbEstiloDeVida;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.DbFactory;

/**
 * Created by PB on 19/11/2016.
 */

public class EstiloDeVidaDao {


    public static void salvar(EstiloDeVida estiloDeVida, Context context){
        //Instancia o Banco de Dados
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        //Persistindo valores do objeto no BD
        values.put(numProntuario, estiloDeVida.getNumProntuario());

        //ESTILO DE VIDA

        values.put(gorduraOpt, estiloDeVida.getGorduraOpt());
        values.put(gorduraResul, estiloDeVida.getGordura());
        values.put(fibraOpt, estiloDeVida.getFibraOpt());
        values.put(fibra, estiloDeVida.getFibra());
        values.put(calcioOpt, estiloDeVida.getCalcioOpt());
        values.put(calcio, estiloDeVida.getCalcio());
        values.put(sodioOpt, estiloDeVida.getSodioOpt());
        values.put(sodio, estiloDeVida.getSodio());
        values.put(acucarOpt, estiloDeVida.getAcucarOpt());
        values.put(acucar, estiloDeVida.getAcucar());
        values.put(refriOpt, estiloDeVida.getRefriOpt());
        values.put(refri, estiloDeVida.getRefri());
        values.put(aguaOpt, estiloDeVida.getAguaOpt());
        values.put(agua, estiloDeVida.getAgua());
        values.put(atFisicaOpt, estiloDeVida.getAtFisicaOpt());
        values.put(atFisica, estiloDeVida.getAtFisica());
        values.put(sonoOpt1, estiloDeVida.getSonoOpt1());
        values.put(sonoOpt2, estiloDeVida.getSonoOpt2());
        values.put(sonoOpt3, estiloDeVida.getSonoOpt3());
        values.put(sonoOpt4, estiloDeVida.getSonoOpt4());
        values.put(sonoOpt5, estiloDeVida.getSonoOpt5());
        values.put(sonoOpt6, estiloDeVida.getSonoOpt6());
        values.put(sonoPontos, estiloDeVida.getSonoPontos());
        values.put(sono, estiloDeVida.getSono());
        values.put(cigarroAtivoOpt, estiloDeVida.getCigarroAtivoOpt());
        values.put(cigarroOpt1, estiloDeVida.getCigarroOpt1());
        values.put(cigarro1, estiloDeVida.getCigarro1());
        values.put(cigarroOpt2, estiloDeVida.getCigarroOpt2());
        values.put(cigarro2, estiloDeVida.getCigarro2());
        values.put(cigarroOpt3, estiloDeVida.getCigarroOpt3());
        values.put(cigarro3, estiloDeVida.getCigarro3());
        values.put(cigarroOpt4, estiloDeVida.getCigarroOpt4());
        values.put(cigarro4, estiloDeVida.getCigarro4());
        values.put(cigarroOpt5, estiloDeVida.getCigarroOpt5());
        values.put(cigarro5, estiloDeVida.getCigarro5());
        values.put(cigarroOpt6, estiloDeVida.getCigarroOpt6());
        values.put(cigarro6, estiloDeVida.getCigarro6());
        values.put(cigarroPontos, estiloDeVida.getCigarroPontos());
        values.put(cigarro, estiloDeVida.getCigarro());
        values.put(alcoolAtivoOpt, estiloDeVida.getAlcoolAtivoOpt());
        values.put(alcoolOpt1, estiloDeVida.getAlcoolOpt1());
        values.put(alcoolOpt2, estiloDeVida.getAlcoolOpt2());
        values.put(alcoolOpt3, estiloDeVida.getAlcoolOpt3());
        values.put(alcoolOpt4, estiloDeVida.getAlcoolOpt4());
        values.put(alcool1, estiloDeVida.getAlcool1());
        values.put(alcool2, estiloDeVida.getAlcool2());
        values.put(alcool3, estiloDeVida.getAlcool3());
        values.put(alcool4, estiloDeVida.getAlcool4());
        values.put(alcool, estiloDeVida.getAlcool());
        values.put(sexualmenteAtivo, estiloDeVida.getSexualmenteAtivo());
        values.put(sexualmenteAtivoOpt, estiloDeVida.getSexualmenteAtivoOpt());

        //Verificando se ira fazer udpate ou insert
        if(estiloDeVida.getId()==null) {
            db.insert(DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME, null, values);
            System.out.println("Nome do Médico: " + estiloDeVida.getNumProntuario());
        }else{
            db.update(DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME, values, "id = ?", new String[]{estiloDeVida.getId().toString()});
        }
        db.close();
    }

    public static List<EstiloDeVida> buscarTodosProntuarios(Context context){
        List<EstiloDeVida> lista = new ArrayList<>();

        String sql = "select * from " + DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                EstiloDeVida estiloDeVida = new EstiloDeVida();
                estiloDeVida.setId(cursor.getLong(ID));
                estiloDeVida.setNumProntuario(cursor.getString(NUM_PRONTUARIO));

                //ESTILO DE VIDA

                estiloDeVida.setGorduraOpt(cursor.getInt(GORDURA_OPT));
                estiloDeVida.setGordura(cursor.getString(GORDURA));
                estiloDeVida.setFibraOpt(cursor.getInt(FIBRA_OPT));
                estiloDeVida.setFibra(cursor.getString(FIBRA));
                estiloDeVida.setCalcioOpt(cursor.getInt(CALCIO_OPT));
                estiloDeVida.setCalcio(cursor.getString(CALCIO));
                estiloDeVida.setSodioOpt(cursor.getInt(SODIO_OPT));
                estiloDeVida.setSodio(cursor.getString(SODIO));
                estiloDeVida.setAcucarOpt(cursor.getInt(ACUCAR_OPT));
                estiloDeVida.setAcucar(cursor.getString(ACUCAR));
                estiloDeVida.setRefriOpt(cursor.getInt(REFRI_OPT));
                estiloDeVida.setRefri(cursor.getString(REFRI));
                estiloDeVida.setAguaOpt(cursor.getInt(AGUA_OPT));
                estiloDeVida.setAgua(cursor.getString(AGUA));
                estiloDeVida.setAtFisicaOpt(cursor.getInt(ATFISICA_OPT));
                estiloDeVida.setAtFisica(cursor.getString(ATFISICA));
                estiloDeVida.setSonoOpt1(cursor.getInt(SONO_OPT_1));
                estiloDeVida.setSonoOpt2(cursor.getInt(SONO_OPT_2));
                estiloDeVida.setSonoOpt3(cursor.getInt(SONO_OPT_3));
                estiloDeVida.setSonoOpt4(cursor.getInt(SONO_OPT_4));
                estiloDeVida.setSonoOpt5(cursor.getInt(SONO_OPT_5));
                estiloDeVida.setSonoOpt6(cursor.getInt(SONO_OPT_6));
                estiloDeVida.setSonoPontos(cursor.getInt(SONO_PONTOS));
                estiloDeVida.setSono(cursor.getString(SONO));
                estiloDeVida.setCigarroAtivoOpt(cursor.getInt(CIGARRO_ATIVO_OPT));
                estiloDeVida.setCigarroOpt1(cursor.getInt(CIGARRO_OPT_1));
                estiloDeVida.setCigarro1(cursor.getString(CIGARRO_1));
                estiloDeVida.setCigarroOpt2(cursor.getInt(CIGARRO_OPT_2));
                estiloDeVida.setCigarro2(cursor.getString(CIGARRO_2));
                estiloDeVida.setCigarroOpt3(cursor.getInt(CIGARRO_OPT_3));
                estiloDeVida.setCigarro3(cursor.getString(CIGARRO_3));
                estiloDeVida.setCigarroOpt4(cursor.getInt(CIGARRO_OPT_4));
                estiloDeVida.setCigarro4(cursor.getString(CIGARRO_4));
                estiloDeVida.setCigarroOpt5(cursor.getInt(CIGARRO_OPT_5));
                estiloDeVida.setCigarro5(cursor.getString(CIGARRO_5));
                estiloDeVida.setCigarroOpt6(cursor.getInt(CIGARRO_OPT_6));
                estiloDeVida.setCigarro6(cursor.getString(CIGARRO_6));
                estiloDeVida.setCigarroPontos(cursor.getInt(CIGARRO_PONTOS));
                estiloDeVida.setCigarro(cursor.getString(CIGARRO));
                estiloDeVida.setAlcoolAtivoOpt(cursor.getInt(ALCOOL_ATIVO_OPT));
                estiloDeVida.setAlcoolOpt1(cursor.getInt(ALCOOL_OPT_1));
                estiloDeVida.setAlcoolOpt2(cursor.getInt(ALCOOL_OPT_2));
                estiloDeVida.setAlcoolOpt3(cursor.getInt(ALCOOL_OPT_3));
                estiloDeVida.setAlcoolOpt4(cursor.getInt(ALCOOL_OPT_4));
                estiloDeVida.setAlcool1(cursor.getString(ALCOOL_1));
                estiloDeVida.setAlcool2(cursor.getString(ALCOOL_2));
                estiloDeVida.setAlcool3(cursor.getString(ALCOOL_3));
                estiloDeVida.setAlcool4(cursor.getString(ALCOOL_4));
                estiloDeVida.setAlcool(cursor.getString(ALCOOL));
                estiloDeVida.setSexualmenteAtivo(cursor.getString(SEXUALMENTE_ATIVO));
                estiloDeVida.setSexualmenteAtivoOpt(cursor.getInt(SEXUALMENTE_ATIVO_OPT));

                lista.add(estiloDeVida);

            }while(cursor.moveToNext());
        }


        db.close();
        return lista;
    }

    public static EstiloDeVida buscarPorNumProntuario(Prontuario p, Context context){

        List<EstiloDeVida> lista = new ArrayList<>();

        String sql = "select * from " + DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                EstiloDeVida estiloDeVida = new EstiloDeVida();
                estiloDeVida.setId(cursor.getLong(ID));
                estiloDeVida.setNumProntuario(cursor.getString(NUM_PRONTUARIO));

                //ESTILO DE VIDA

                estiloDeVida.setGorduraOpt(cursor.getInt(GORDURA_OPT));
                estiloDeVida.setGordura(cursor.getString(GORDURA));
                estiloDeVida.setFibraOpt(cursor.getInt(FIBRA_OPT));
                estiloDeVida.setFibra(cursor.getString(FIBRA));
                estiloDeVida.setCalcioOpt(cursor.getInt(CALCIO_OPT));
                estiloDeVida.setCalcio(cursor.getString(CALCIO));
                estiloDeVida.setSodioOpt(cursor.getInt(SODIO_OPT));
                estiloDeVida.setSodio(cursor.getString(SODIO));
                estiloDeVida.setAcucarOpt(cursor.getInt(ACUCAR_OPT));
                estiloDeVida.setAcucar(cursor.getString(ACUCAR));
                estiloDeVida.setRefriOpt(cursor.getInt(REFRI_OPT));
                estiloDeVida.setRefri(cursor.getString(REFRI));
                estiloDeVida.setAguaOpt(cursor.getInt(AGUA_OPT));
                estiloDeVida.setAgua(cursor.getString(AGUA));
                estiloDeVida.setAtFisicaOpt(cursor.getInt(ATFISICA_OPT));
                estiloDeVida.setAtFisica(cursor.getString(ATFISICA));
                estiloDeVida.setSonoOpt1(cursor.getInt(SONO_OPT_1));
                estiloDeVida.setSonoOpt2(cursor.getInt(SONO_OPT_2));
                estiloDeVida.setSonoOpt3(cursor.getInt(SONO_OPT_3));
                estiloDeVida.setSonoOpt4(cursor.getInt(SONO_OPT_4));
                estiloDeVida.setSonoOpt5(cursor.getInt(SONO_OPT_5));
                estiloDeVida.setSonoOpt6(cursor.getInt(SONO_OPT_6));
                estiloDeVida.setSonoPontos(cursor.getInt(SONO_PONTOS));
                estiloDeVida.setSono(cursor.getString(SONO));
                estiloDeVida.setCigarroAtivoOpt(cursor.getInt(CIGARRO_ATIVO_OPT));
                estiloDeVida.setCigarroOpt1(cursor.getInt(CIGARRO_OPT_1));
                estiloDeVida.setCigarro1(cursor.getString(CIGARRO_1));
                estiloDeVida.setCigarroOpt2(cursor.getInt(CIGARRO_OPT_2));
                estiloDeVida.setCigarro2(cursor.getString(CIGARRO_2));
                estiloDeVida.setCigarroOpt3(cursor.getInt(CIGARRO_OPT_3));
                estiloDeVida.setCigarro3(cursor.getString(CIGARRO_3));
                estiloDeVida.setCigarroOpt4(cursor.getInt(CIGARRO_OPT_4));
                estiloDeVida.setCigarro4(cursor.getString(CIGARRO_4));
                estiloDeVida.setCigarroOpt5(cursor.getInt(CIGARRO_OPT_5));
                estiloDeVida.setCigarro5(cursor.getString(CIGARRO_5));
                estiloDeVida.setCigarroOpt6(cursor.getInt(CIGARRO_OPT_6));
                estiloDeVida.setCigarro6(cursor.getString(CIGARRO_6));
                estiloDeVida.setCigarroPontos(cursor.getInt(CIGARRO_PONTOS));
                estiloDeVida.setCigarro(cursor.getString(CIGARRO));
                estiloDeVida.setAlcoolAtivoOpt(cursor.getInt(ALCOOL_ATIVO_OPT));
                estiloDeVida.setAlcoolOpt1(cursor.getInt(ALCOOL_OPT_1));
                estiloDeVida.setAlcoolOpt2(cursor.getInt(ALCOOL_OPT_2));
                estiloDeVida.setAlcoolOpt3(cursor.getInt(ALCOOL_OPT_3));
                estiloDeVida.setAlcoolOpt4(cursor.getInt(ALCOOL_OPT_4));
                estiloDeVida.setAlcool1(cursor.getString(ALCOOL_1));
                estiloDeVida.setAlcool2(cursor.getString(ALCOOL_2));
                estiloDeVida.setAlcool3(cursor.getString(ALCOOL_3));
                estiloDeVida.setAlcool4(cursor.getString(ALCOOL_4));
                estiloDeVida.setAlcool(cursor.getString(ALCOOL));
                estiloDeVida.setSexualmenteAtivo(cursor.getString(SEXUALMENTE_ATIVO));
                estiloDeVida.setSexualmenteAtivoOpt(cursor.getInt(SEXUALMENTE_ATIVO_OPT));

                lista.add(estiloDeVida);

            }while(cursor.moveToNext());
        }


        for (EstiloDeVida estilo : lista) {
            if(p.getNumProntuario().equals(estilo.getNumProntuario())){
                return estilo;
            }
        }

        db.close();
        return null;
    }

    public static EstiloDeVida buscarPorId(Long id, Context context){

        String sql = "select * from " + DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME + " where ID = " + id;
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                EstiloDeVida estiloDeVida = new EstiloDeVida();
                estiloDeVida.setId(cursor.getLong(ID));
                estiloDeVida.setNumProntuario(cursor.getString(NUM_PRONTUARIO));

                //ESTILO DE VIDA

                estiloDeVida.setGorduraOpt(cursor.getInt(GORDURA_OPT));
                estiloDeVida.setGordura(cursor.getString(GORDURA));
                estiloDeVida.setFibraOpt(cursor.getInt(FIBRA_OPT));
                estiloDeVida.setFibra(cursor.getString(FIBRA));
                estiloDeVida.setCalcioOpt(cursor.getInt(CALCIO_OPT));
                estiloDeVida.setCalcio(cursor.getString(CALCIO));
                estiloDeVida.setSodioOpt(cursor.getInt(SODIO_OPT));
                estiloDeVida.setSodio(cursor.getString(SODIO));
                estiloDeVida.setAcucarOpt(cursor.getInt(ACUCAR_OPT));
                estiloDeVida.setAcucar(cursor.getString(ACUCAR));
                estiloDeVida.setRefriOpt(cursor.getInt(REFRI_OPT));
                estiloDeVida.setRefri(cursor.getString(REFRI));
                estiloDeVida.setAguaOpt(cursor.getInt(AGUA_OPT));
                estiloDeVida.setAgua(cursor.getString(AGUA));
                estiloDeVida.setAtFisicaOpt(cursor.getInt(ATFISICA_OPT));
                estiloDeVida.setAtFisica(cursor.getString(ATFISICA));
                estiloDeVida.setSonoOpt1(cursor.getInt(SONO_OPT_1));
                estiloDeVida.setSonoOpt2(cursor.getInt(SONO_OPT_2));
                estiloDeVida.setSonoOpt3(cursor.getInt(SONO_OPT_3));
                estiloDeVida.setSonoOpt4(cursor.getInt(SONO_OPT_4));
                estiloDeVida.setSonoOpt5(cursor.getInt(SONO_OPT_5));
                estiloDeVida.setSonoOpt6(cursor.getInt(SONO_OPT_6));
                estiloDeVida.setSonoPontos(cursor.getInt(SONO_PONTOS));
                estiloDeVida.setSono(cursor.getString(SONO));
                estiloDeVida.setCigarroAtivoOpt(cursor.getInt(CIGARRO_ATIVO_OPT));
                estiloDeVida.setCigarroOpt1(cursor.getInt(CIGARRO_OPT_1));
                estiloDeVida.setCigarro1(cursor.getString(CIGARRO_1));
                estiloDeVida.setCigarroOpt2(cursor.getInt(CIGARRO_OPT_2));
                estiloDeVida.setCigarro2(cursor.getString(CIGARRO_2));
                estiloDeVida.setCigarroOpt3(cursor.getInt(CIGARRO_OPT_3));
                estiloDeVida.setCigarro3(cursor.getString(CIGARRO_3));
                estiloDeVida.setCigarroOpt4(cursor.getInt(CIGARRO_OPT_4));
                estiloDeVida.setCigarro4(cursor.getString(CIGARRO_4));
                estiloDeVida.setCigarroOpt5(cursor.getInt(CIGARRO_OPT_5));
                estiloDeVida.setCigarro5(cursor.getString(CIGARRO_5));
                estiloDeVida.setCigarroOpt6(cursor.getInt(CIGARRO_OPT_6));
                estiloDeVida.setCigarro6(cursor.getString(CIGARRO_6));
                estiloDeVida.setCigarroPontos(cursor.getInt(CIGARRO_PONTOS));
                estiloDeVida.setCigarro(cursor.getString(CIGARRO));
                estiloDeVida.setAlcoolAtivoOpt(cursor.getInt(ALCOOL_ATIVO_OPT));
                estiloDeVida.setAlcoolOpt1(cursor.getInt(ALCOOL_OPT_1));
                estiloDeVida.setAlcoolOpt2(cursor.getInt(ALCOOL_OPT_2));
                estiloDeVida.setAlcoolOpt3(cursor.getInt(ALCOOL_OPT_3));
                estiloDeVida.setAlcoolOpt4(cursor.getInt(ALCOOL_OPT_4));
                estiloDeVida.setAlcool1(cursor.getString(ALCOOL_1));
                estiloDeVida.setAlcool2(cursor.getString(ALCOOL_2));
                estiloDeVida.setAlcool3(cursor.getString(ALCOOL_3));
                estiloDeVida.setAlcool4(cursor.getString(ALCOOL_4));
                estiloDeVida.setAlcool(cursor.getString(ALCOOL));
                estiloDeVida.setSexualmenteAtivo(cursor.getString(SEXUALMENTE_ATIVO));
                estiloDeVida.setSexualmenteAtivoOpt(cursor.getInt(SEXUALMENTE_ATIVO_OPT));
                db.close();
                return estiloDeVida;
            }while(cursor.moveToNext());
        }

        db.close();
        return null;
    }

    public static void excluirEstiloDeVida(EstiloDeVida estiloDeVida, Context context) {
        SQLiteDatabase db = DbFactory.getDB(context).getWritableDatabase();
        db.delete(DbEstiloDeVida.ESTILO_DE_VIDA_TB_NAME, "id =?", new String[]{estiloDeVida.getId().toString()});
        System.out.println("Paciente: " + estiloDeVida.getNumProntuario());
        db.close();
    }

    public static final int ID = 0;
    public static final int NUM_PRONTUARIO = 1;
    public static final int GORDURA_OPT = 2;
    public static final int GORDURA = 3;
    public static final int FIBRA_OPT = 4;
    public static final int FIBRA = 5;
    public static final int CALCIO_OPT = 6;
    public static final int CALCIO = 7;
    public static final int SODIO_OPT = 8;
    public static final int SODIO = 9;
    public static final int ACUCAR_OPT = 10;
    public static final int ACUCAR = 11;
    public static final int REFRI_OPT = 12;
    public static final int REFRI = 13;
    public static final int AGUA_OPT = 14;
    public static final int AGUA = 15;
    public static final int ATFISICA_OPT = 16;
    public static final int ATFISICA = 17;
    public static final int SONO_OPT_1 = 18;
    public static final int SONO_OPT_2 = 19;
    public static final int SONO_OPT_3 = 20;
    public static final int SONO_OPT_4 = 21;
    public static final int SONO_OPT_5 = 22;
    public static final int SONO_OPT_6 = 23;
    public static final int SONO_PONTOS = 24;
    public static final int SONO = 25;
    public static final int CIGARRO_ATIVO_OPT = 26;
    public static final int CIGARRO_OPT_1 = 27;
    public static final int CIGARRO_1 = 28;
    public static final int CIGARRO_OPT_2 = 29;
    public static final int CIGARRO_2 = 30;
    public static final int CIGARRO_OPT_3 = 31;
    public static final int CIGARRO_3 = 32;
    public static final int CIGARRO_OPT_4 = 33;
    public static final int CIGARRO_4 = 34;
    public static final int CIGARRO_OPT_5 = 35;
    public static final int CIGARRO_5 = 36;
    public static final int CIGARRO_OPT_6 = 37;
    public static final int CIGARRO_6 = 38;
    public static final int CIGARRO_PONTOS = 39;
    public static final int CIGARRO = 40;
    public static final int ALCOOL_ATIVO_OPT = 41;
    public static final int ALCOOL_OPT_1 = 42;
    public static final int ALCOOL_OPT_2 = 43;
    public static final int ALCOOL_OPT_3 = 44;
    public static final int ALCOOL_OPT_4 = 45;
    public static final int ALCOOL_1 = 46;
    public static final int ALCOOL_2 = 47;
    public static final int ALCOOL_3 = 48;
    public static final int ALCOOL_4 = 49;
    public static final int ALCOOL = 50;
    public static final int SEXUALMENTE_ATIVO = 51;
    public static final int SEXUALMENTE_ATIVO_OPT = 52;

    public static final String id = "id";
    public static final String numProntuario = "num_prontuario";
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
    public static final String alcoolAtivoOpt = "alcool_ativo_opt";
    public static final String alcoolOpt1 = "alcool_opt_1";
    public static final String alcoolOpt2 = "alcool_opt_2";
    public static final String alcoolOpt3 = "alcool_opt_3";
    public static final String alcoolOpt4 = "alcool_opt_4";
    public static final String alcool1 = "alcool_1";
    public static final String alcool2 = "alcool_2";
    public static final String alcool3 = "alcool_3";
    public static final String alcool4 = "alcool_4";
    public static final String alcool = "alcool";
    public static final String sexualmenteAtivo = "SEXUALMENTE_ATIVO";
    public static final String sexualmenteAtivoOpt = "SEXUALMENTE_ATIVO_OPT";

}
