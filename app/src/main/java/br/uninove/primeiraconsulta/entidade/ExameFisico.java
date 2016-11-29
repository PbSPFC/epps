package br.uninove.primeiraconsulta.entidade;

import java.io.Serializable;

/**
 * Created by PB on 19/11/2016.
 */

public class ExameFisico implements Serializable{

    private Long id;
    private String numProntuario;

    //Exame Fisico
    private Integer sistole;
    private Integer diastole;
    private Float imc;
    private Integer cervical;
    private Integer cintura;
    private Float quadril;
    private Integer snellenDireita;
    private Integer snellenEsquerda;

    private String paResultado;
    private String imcResultado;
    private String cervicalResultado;
    private String cinturaResultado;
    private String quadrilResultado;
    private String snellenResultado;

    private String comentario;
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

    public Integer getSistole() {
        return sistole;
    }

    public void setSistole(Integer sistole) {
        this.sistole = sistole;
    }

    public Integer getDiastole() {
        return diastole;
    }

    public void setDiastole(Integer diastole) {
        this.diastole = diastole;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public Integer getCervical() {
        return cervical;
    }

    public void setCervical(Integer cervical) {
        this.cervical = cervical;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Float getQuadril() {
        return quadril;
    }

    public void setQuadril(Float quadril) {
        this.quadril = quadril;
    }

    public Integer getSnellenDireita() {
        return snellenDireita;
    }

    public void setSnellenDireita(Integer snellenDireita) {
        this.snellenDireita = snellenDireita;
    }

    public Integer getSnellenEsquerda() {
        return snellenEsquerda;
    }

    public void setSnellenEsquerda(Integer snellenEsquerda) {
        this.snellenEsquerda = snellenEsquerda;
    }

    public String getPaResultado() {
        return paResultado;
    }

    public void setPaResultado(String paResultado) {
        this.paResultado = paResultado;
    }

    public String getImcResultado() {
        return imcResultado;
    }

    public void setImcResultado(String imcResultado) {
        this.imcResultado = imcResultado;
    }

    public String getCervicalResultado() {
        return cervicalResultado;
    }

    public void setCervicalResultado(String cervicalResultado) {
        this.cervicalResultado = cervicalResultado;
    }

    public String getCinturaResultado() {
        return cinturaResultado;
    }

    public void setCinturaResultado(String cinturaResultado) {
        this.cinturaResultado = cinturaResultado;
    }

    public String getQuadrilResultado() {
        return quadrilResultado;
    }

    public void setQuadrilResultado(String quadrilResultado) {
        this.quadrilResultado = quadrilResultado;
    }

    public String getSnellenResultado() {
        return snellenResultado;
    }

    public void setSnellenResultado(String snellenResultado) {
        this.snellenResultado = snellenResultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }
}
