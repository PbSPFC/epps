package br.uninove.primeiraconsulta.entidade;

import java.io.Serializable;

/**
 * Created by PB on 09/11/2016.
 */

public class Prontuario implements Serializable {

    public Prontuario() {
    }

    private Long id;
    private Long idEstiloDeVida;
    private Long idExameFisico;
    private Long idAnamnese;
    private String numProntuario;
    private Long idUsuario;
    private String raUsuario;
    private String nomeMedico;
    private String sexo;
    private Integer idade;
    private Integer peso;
    private Float altura;
    private String comentario;
    private String data;
    private String dataEdicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEstiloDeVida() {
        return idEstiloDeVida;
    }

    public Long getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(Long idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public void setIdEstiloDeVida(Long idEstiloDeVida) {
        this.idEstiloDeVida = idEstiloDeVida;
    }

    public Long getIdExameFisico() {
        return idExameFisico;
    }

    public void setIdExameFisico(Long idExameFisico) {
        this.idExameFisico = idExameFisico;
    }

    public String getNumProntuario() {
        return numProntuario;
    }

    public void setNumProntuario(String numProntuario) {
        this.numProntuario = numProntuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRaUsuario() {
        return raUsuario;
    }

    public void setRaUsuario(String raUsuario) {
        this.raUsuario = raUsuario;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao) {
        this.dataEdicao = dataEdicao;
    }
}
