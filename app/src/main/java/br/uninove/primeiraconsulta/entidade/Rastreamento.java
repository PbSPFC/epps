package br.uninove.primeiraconsulta.entidade;

/**
 * Created by PB on 22/11/2016.
 */

public class Rastreamento {

    private String nivel;
    private String rastreamento;
    private String titulo;
    private String texto;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getRastreamento() {
        return rastreamento;
    }

    public void setRastreamento(String rastreamento) {
        this.rastreamento = rastreamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
