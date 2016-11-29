package br.uninove.primeiraconsulta.util;

import android.content.Context;

import java.util.List;

import br.uninove.primeiraconsulta.activity.prontuario.EditarProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.LogProntuarioActivity;
import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.log.LogAnamneseDao;
import br.uninove.primeiraconsulta.dao.log.LogEstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.log.LogExameFisicoDao;
import br.uninove.primeiraconsulta.dao.log.LogListaProblemasDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
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

    public static Prontuario checkNumProntuario(Prontuario prontuario, EstiloDeVida estiloDeVida, ExameFisico exameFisico, Anamnese anamnese, List<ListaProblemas> listaProblemas, Context context) {
        List<Prontuario> prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
        for (Prontuario pron : prontuarioLista) {
            if(prontuario.getNumProntuario().equals(pron.getNumProntuario())){
                return null;
            }
        }




        prontuario = nadaConstaProntuario(prontuario);
        estiloDeVida = nadaConstaEstiloDeVida(estiloDeVida);
        anamnese = nadaConstaAnamnese(anamnese);

        EstiloDeVidaDao.salvar(estiloDeVida, context);
        ExameFisicoDao.salvar(exameFisico, context);
        AnamneseDao.salvar(anamnese, context);

        listaProblemas = nadaConstaListaProb(listaProblemas);
        ListaProblemasDao.salvar(listaProblemas, prontuario, context);

        estiloDeVida = EstiloDeVidaDao.buscarPorNumProntuario(prontuario, context);
        exameFisico = ExameFisicoDao.buscarPorNumProntuario(prontuario, context);
        anamnese = AnamneseDao.buscarPorNumProntuario(prontuario, context);

        prontuario.setIdEstiloDeVida(estiloDeVida.getId());
        prontuario.setIdExameFisico(exameFisico.getId());
        prontuario.setIdAnamnese(anamnese.getId());

        ProntuarioDao.salvar(prontuario, context);


        prontuarioLista = ProntuarioDao.buscarTodosProntuarios(context);
        for (Prontuario pron : prontuarioLista) {
            if(prontuario.getNumProntuario().equals(pron.getNumProntuario())){
                prontuario = pron;
            }
        }

        return prontuario;
    }

    public static List<ListaProblemas> nadaConstaListaProb(List<ListaProblemas> listaProblemas) {

        for (ListaProblemas lp : listaProblemas) {
            if(lp.getDescricao().isEmpty()){lp.setDescricao("N/D");}
            if(lp.getAcao().isEmpty()){lp.setAcao("N/D");}
        }

        return listaProblemas;
    }

    public static Anamnese nadaConstaAnamnese(Anamnese anamnese) {

        if(anamnese.getQueixa().isEmpty()){anamnese.setQueixa("N/D");}
        if(anamnese.getHistoriaDoenca().isEmpty()){anamnese.setHistoriaDoenca("N/D");}
        if(anamnese.getInterrogatorio().isEmpty()){anamnese.setInterrogatorio("N/D");}
        if(anamnese.getPercepcao().isEmpty()){anamnese.setPercepcao("N/D");}

        return anamnese;
    }

    public static Prontuario nadaConstaProntuario(Prontuario p){
        if(p.getComentario().isEmpty()){p.setComentario("N/D");}

        return p;
    }

    public static EstiloDeVida nadaConstaEstiloDeVida(EstiloDeVida estiloDeVida){
        if(estiloDeVida.getGordura().isEmpty() || estiloDeVida.getGordura().equals("")){estiloDeVida.setGordura("N/D");}
        if(estiloDeVida.getFibra().isEmpty() || estiloDeVida.getFibra().equals("")){estiloDeVida.setFibra("N/D");}
        if(estiloDeVida.getCalcio().isEmpty() || estiloDeVida.getCalcio().equals("")){estiloDeVida.setCalcio("N/D");}
        if(estiloDeVida.getSodio().isEmpty() || estiloDeVida.getSodio().equals("")){estiloDeVida.setSodio("N/D");}
        if(estiloDeVida.getAcucar().isEmpty() || estiloDeVida.getAcucar().equals("")){estiloDeVida.setAcucar("N/D");}
        if(estiloDeVida.getRefri().isEmpty() || estiloDeVida.getRefri().equals("")){estiloDeVida.setRefri("N/D");}
        if(estiloDeVida.getAgua().isEmpty() || estiloDeVida.getAgua().equals("")){estiloDeVida.setAgua("N/D");}
        if(estiloDeVida.getAtFisica().isEmpty() || estiloDeVida.getAtFisica().equals("")){estiloDeVida.setAtFisica("N/D");}
        if(estiloDeVida.getSono().isEmpty() || estiloDeVida.getSono().equals("")){estiloDeVida.setSono("N/D");}
        if(estiloDeVida.getSexualmenteAtivo().isEmpty() || estiloDeVida.getSexualmenteAtivo().equals("")){estiloDeVida.setSexualmenteAtivo("N/D");}

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
