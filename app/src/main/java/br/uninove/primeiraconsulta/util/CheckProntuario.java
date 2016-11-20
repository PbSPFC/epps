package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.List;

import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;

/**
 * Created by PB on 10/11/2016.
 */

public class CheckProntuario {

    public static boolean checkCampos(Prontuario p, Context context) {

        if(!p.getNumProntuario().isEmpty() &&
                p.getIdUsuario()!= null && !p.getRaUsuario().isEmpty() && !p.getNomeMedico().isEmpty() &&
                !p.getSexo().isEmpty() && p.getIdade() != null && p.getPeso() != null && p.getAltura() != null){
            return true;
        }
        return false;
    }

    public static Prontuario checkNumProntuario(Prontuario p, EstiloDeVida estiloDeVida, ExameFisico exameFisico, Context context) {
        List<Prontuario> prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
        for (Prontuario pron : prontuarioLista) {
            if(p.getNumProntuario().equals(pron.getNumProntuario())){
                return null;
            }
        }

        p = nadaConstaProntuario(p);
        estiloDeVida = nadaConstaEstiloDeVida(estiloDeVida);
        EstiloDeVidaDao.salvar(estiloDeVida, context);
        ExameFisicoDao.salvar(exameFisico, context);

        estiloDeVida = EstiloDeVidaDao.buscarPorNumProntuario(p, context);
        exameFisico = ExameFisicoDao.buscarPorNumProntuario(p, context);

        p.setIdEstiloDeVida(estiloDeVida.getId());
        System.out.println("Id Estilo de Vida: " + p.getIdEstiloDeVida());
        p.setIdExameFisico(exameFisico.getId());
        System.out.println("Id Exame Fisico: " + p.getIdExameFisico());

        ProntuarioDao.salvar(p, context);

        prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
        for (Prontuario pron : prontuarioLista) {
            if(p.getNumProntuario().equals(pron.getNumProntuario())){
                p = pron;
            }
        }

        return p;
    }

    public static Prontuario nadaConstaProntuario(Prontuario p){
        if(p.getComentario().isEmpty()){p.setComentario("Nada Consta.");}

        return p;
    }

    public static EstiloDeVida nadaConstaEstiloDeVida(EstiloDeVida estiloDeVida){
        if(estiloDeVida.getGordura().isEmpty() || estiloDeVida.getGordura().equals("")){estiloDeVida.setGordura("Nada Consta.");}
        if(estiloDeVida.getFibra().isEmpty() || estiloDeVida.getFibra().equals("")){estiloDeVida.setFibra("Nada Consta.");}
        if(estiloDeVida.getCalcio().isEmpty() || estiloDeVida.getCalcio().equals("")){estiloDeVida.setCalcio("Nada Consta.");}
        if(estiloDeVida.getSodio().isEmpty() || estiloDeVida.getSodio().equals("")){estiloDeVida.setSodio("Nada Consta.");}
        if(estiloDeVida.getAcucar().isEmpty() || estiloDeVida.getAcucar().equals("")){estiloDeVida.setAcucar("Nada Consta.");}
        if(estiloDeVida.getRefri().isEmpty() || estiloDeVida.getRefri().equals("")){estiloDeVida.setRefri("Nada Consta.");}
        if(estiloDeVida.getAgua().isEmpty() || estiloDeVida.getAgua().equals("")){estiloDeVida.setAgua("Nada Consta.");}
        if(estiloDeVida.getAtFisica().isEmpty() || estiloDeVida.getAtFisica().equals("")){estiloDeVida.setAtFisica("Nada Consta.");}
        if(estiloDeVida.getSono().isEmpty() || estiloDeVida.getSono().equals("")){estiloDeVida.setSono("Nada Consta.");}

        return estiloDeVida;
    }


    public static Float getImc(Integer peso, Float altura){
        Float imc = peso / (altura*altura);
        return imc;
    }

    public static String getImcResultado(Float imc){
        if(imc < 18.5){
            return "Magreza.";
        } else if (imc >= 18.5 && imc < 25){
            return "Peso normal.";
        } else if (imc >= 25 && imc < 30){
            return "Sobrepeso.";
        } else if (imc >= 30 && imc < 35){
            return "Obesidade Classe I.";
        } else if (imc >= 35 && imc < 40){
            return "Obesidade Classe II.";
        } else {
            return "Obesidade Classe III.";
        }
    }

}
