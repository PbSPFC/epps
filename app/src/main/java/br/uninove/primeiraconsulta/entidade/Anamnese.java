package br.uninove.primeiraconsulta.entidade;

import java.io.Serializable;

/**
 * Created by PB on 20/11/2016.
 */

public class Anamnese implements Serializable{

    private Long id;
    private String numProntuario;
    private String queixa;
    private String historiaDoenca;
    private String interrogatorio;
    private String percepcao;
    private String dataEdicao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumProntuario() {
        return numProntuario;
    }

    public void setNumProntuario(String numProntuario) {
        this.numProntuario = numProntuario;
    }

    public String getQueixa() {
        return queixa;
    }

    public void setQueixa(String queixa) {
        this.queixa = queixa;
    }

    public String getHistoriaDoenca() {
        return historiaDoenca;
    }

    public void setHistoriaDoenca(String historiaDoenca) {
        this.historiaDoenca = historiaDoenca;
    }

    public String getInterrogatorio() {
        return interrogatorio;
    }

    public void setInterrogatorio(String interrogatorio) {
        this.interrogatorio = interrogatorio;
    }

    public String getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(String percepcao) {
        this.percepcao = percepcao;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }
}
