/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblDetalleprestamoFacade;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.util.DataObject1;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

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
    private List<DataObject1> dtl;

    @EJB
    TblDetalleprestamoFacade detalleFacade;

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
        dtl = detalleFacade.rastrea(res);
        RequestContext.getCurrentInstance().update("formita/searchInfo");
    }

    public String creaPrestamo() {
        System.out.println("crea prestamo");
        return null;
    }

    public List<DataObject1> getDtl() {
        return dtl;
    }

    public void setDtl(List<DataObject1> dtl) {
        this.dtl = dtl;
    }


}
