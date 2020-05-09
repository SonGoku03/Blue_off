package com.emontec.blue_off.entidades;

import java.io.Serializable;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class Bodegas implements Serializable {

    private String elemento;
    private String valor;
    private String series;

    public Bodegas(String  elemento, String valor, String series) {
        this.elemento = elemento;
        this.valor = valor;
        this.series = series;

    }

    public Bodegas(){

    }

    public String getElemento() {
        return elemento;
    }
    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }

}
