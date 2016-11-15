package br.uninove.primeiraconsulta.entidade;

import java.io.Serializable;

/**
 * Created by PB on 09/11/2016.
 */

public class Prontuario implements Serializable {

    public Prontuario() {
    }

    private Long id;
    private String numProntuario;
    private String nomePaciente;
    private Long idUsuario;
    private String raUsuario;
    private String nomeMedico;
    private String sexo;
    private Integer idade;
    private Integer peso;
    private Float altura;

    //Estilo de vida / Habitos.

    private Integer gorduraOpt;
    private String gordura;

    private String comentario;


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

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
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

    public Integer getGorduraOpt() {
        return gorduraOpt;
    }

    public void setGorduraOpt(Integer gorduraOpt) {
        this.gorduraOpt = gorduraOpt;
    }

    public String getGordura() {
        return gordura;
    }

    public void setGordura(String gordura) {
        this.gordura = gordura;
    }
}
