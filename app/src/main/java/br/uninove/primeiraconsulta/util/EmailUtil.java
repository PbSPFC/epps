package br.uninove.primeiraconsulta.util;

import java.util.List;

import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;

/**
 * Created by PB on 28/11/2016.
 */

public class EmailUtil {


    public static String getEmail(Prontuario prontuario, EstiloDeVida estiloDeVida, ExameFisico exameFisico, Anamnese anamnese, List<ListaProblemas> listaProblemas) throws Exception {
        String email = "";
        try {
            email = "Número de prontuário: " + prontuario.getNumProntuario() + "\n" +
                    "Registrado por: " + prontuario.getNomeMedico() + "\n" +
                    "Data de criação do prontuário: " + prontuario.getData() + "\n" +
                    "Data de última edição do prontuário: " + prontuario.getDataEdicao() + "\n" +
                    "Sexo: " + prontuario.getSexo() + "\n" +
                    "Idade: " + prontuario.getIdade() + "\n" +
                    "Peso: " + prontuario.getPeso() + "\n" +
                    "Altura: " + prontuario.getAltura() + "\n" +
                    "\n" +
                    "\t\tANAMNESE\t\t" +
                    "\n\n" +
                    "Queixa e duração: " + anamnese.getQueixa() + "\n" +
                    "História da doença: " + anamnese.getHistoriaDoenca() + "\n" +
                    "Interrogatório sobre técnologias: " + anamnese.getInterrogatorio() + "\n" +
                    "Percepção do paciente sobre a doença: " + anamnese.getPercepcao() + "\n" +
                    "\n" +
                    "\t\tESTILO DE VIDA\t\t" +
                    "\n\n" +
                    "Gordura: " + estiloDeVida.getGordura() + "\n" +
                    "Fibra: " + estiloDeVida.getFibra() + "\n" +
                    "Calcio: " + estiloDeVida.getCalcio() + "\n" +
                    "Sódio: " + estiloDeVida.getCalcio() + "\n" +
                    "Açúcar: " + estiloDeVida.getAcucar() + "\n" +
                    "Refrigerante: " + estiloDeVida.getRefri() + "\n" +
                    "Água: " + estiloDeVida.getAgua() + "\n" +
                    "Atividade Física: " + estiloDeVida.getAtFisica() + "\n" +
                    "Sexualmente Ativo: " + estiloDeVida.getSexualmenteAtivo() + "\n" +
                    "Sono: " + estiloDeVida.getSono() + "\n" +
                    "Tabaco: " + estiloDeVida.getCigarro() + "\n" +
                    "Álcool: " + estiloDeVida.getAlcool() + "\n" +
                    "\n" +
                    "\t\tEXAME FÍSICO\t\t" +
                    "\n\n" +
                    "Sistole: " + exameFisico.getSistole() + "\n" +
                    "Diastole: " + exameFisico.getDiastole() + "\n" +
                    "Pressão Arterial: " + exameFisico.getPaResultado() + "\n" +
                    "IMC: " + exameFisico.getImc() + ", Resultado: " + exameFisico.getImcResultado() + "\n" +
                    "Circunferência Cervical: " + exameFisico.getCervical() + ", Resultado: " + exameFisico.getCervicalResultado() + "\n" +
                    "Circunferência da Cintura: " + exameFisico.getCintura() + ", Resultado: " + exameFisico.getCinturaResultado() + "\n" +
                    "Quadril: " + exameFisico.getQuadril() + ", Resultado: " + exameFisico.getQuadrilResultado() + "\n" +
                    "Snellen (Direita): " + exameFisico.getSnellenDireita() + "\n" +
                    "Snellen (Esquerda): " + exameFisico.getSnellenEsquerda() + "\n" +
                    "Snellen Resultado: " + exameFisico.getSnellenResultado() + "\n" +
                    "Comentário: " + exameFisico.getComentario() + "\n" +
                    "\n" +
                    "\t\tLISTA DE PROBLEMAS\t\t" +
                    "\n\n";
            for (ListaProblemas lista : listaProblemas) {
                email = email + "" +
                        "Descrição: " + lista.getDescricao() + "\n" +
                        "Ação: " + lista.getAcao() + "\n";
            }
            email = email + "" +
                    "\n" +
                    "\t\tCOMENTÁRIO FINAL\t\t\n" +
                    "Comentário: " + prontuario.getComentario();
        }catch (Exception e){
            throw new Exception(e);
        }
        return email;
    }
}
