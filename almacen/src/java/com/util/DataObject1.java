/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.Serializable;

/**
 *
 * @author NORE
 */
public class DataObject1 implements Serializable {

    private int id;
    private String clave1;
    private String clave2;
    private String responsable;
    private String comentario;
    private String nombreObjeto;
    private String serie;

    public DataObject1() {
    }

    public DataObject1(int id, String clave1, String clave2, String responsable, String comentario, String nombreObjeto, String serie) {
        this.id = id;
        this.clave1 = clave1;
        this.clave2 = clave2;
        this.responsable = responsable;
        this.comentario = comentario;
        this.nombreObjeto = nombreObjeto;
        this.serie = serie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave1() {
        return clave1;
    }

    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override

    public String toString() {
        return "DataObject1 [id=" + id + "clave1=" + clave1 + ", clave2=" + clave2 + ", responsable=" + responsable + ", comentario=" + comentario
                + "]";
    }

}
