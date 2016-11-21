package br.uninove.primeiraconsulta.entidade;

import java.io.Serializable;

/**
 * Created by PB on 21/11/2016.
 */

public class ListaProblemas implements Serializable{

    public ListaProblemas(){}

    public ListaProblemas(String acao, String descricao) {
        this.acao = acao;
        this.descricao = descricao;
    }

    private Long id;
    private String numProntuario;
    private String descricao;
    private String acao;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
