/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("personal")
@SessionScoped
public class PersonalLoans implements Serializable {

    private String res;
    private String responsable;
    private String serie;
    private TblDetalleprestamo dtl;

    public PersonalLoans() {
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void asigna() {
        System.out.println("ME INVOCARON");
    }

    public String creaPrestamo() {
        System.out.println("crea prestamo");
        return null;
    }
}
