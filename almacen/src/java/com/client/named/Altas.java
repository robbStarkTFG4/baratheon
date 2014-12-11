/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.AlmacenFacade;
import com.server.beans.staless.SubfamiliasFacade;
import com.server.beans.staless.TblAreaFacade;
import com.server.beans.staless.TblTipomaterialFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author cristian
 */
@Named("altas")
@SessionScoped

public class Altas implements Serializable {

    @Inject
    BeanMateriales mate;
    private int prioridad;
    private String descripcionArea;
    private String descripcionAlmacen;
    private String nombreSubfam;
    private String descripcionSubfam;
    private String descripcionTipoMat;
    private String AreaTM;
//@EJB TblMaterialFacade mf; 
    @EJB
    AlmacenFacade af;
    @EJB
    SubfamiliasFacade sff;
    @EJB
    TblAreaFacade arf;
    @EJB
    TblTipomaterialFacade tmf;

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcionArea() {
        return descripcionArea;
    }

    public void setDescripcionArea(String descripcionArea) {
        this.descripcionArea = descripcionArea;
    }

    public String getDescripcionAlmacen() {
        return descripcionAlmacen;
    }

    public void setDescripcionAlmacen(String descripcionAlmacen) {
        this.descripcionAlmacen = descripcionAlmacen;
    }

    public String getNombreSubfam() {
        return nombreSubfam;
    }

    public void setNombreSubfam(String nombreSubfam) {
        this.nombreSubfam = nombreSubfam;
    }

    public String getDescripcionSubfam() {
        return descripcionSubfam;
    }

    public void setDescripcionSubfam(String descripcionSubfam) {
        this.descripcionSubfam = descripcionSubfam;
    }

    public String getDescripcionTipoMat() {
        return descripcionTipoMat;
    }

    public void setDescripcionTipoMat(String descripcionTipoMat) {
        this.descripcionTipoMat = descripcionTipoMat;
    }

    public String getAreaTM() {
        return AreaTM;
    }

    public void setAreaTM(String AreaTM) {
        this.AreaTM = AreaTM;
    }

    public void dialogArea(int p) {
        prioridad = p;
        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 130);
        options.put("contentWidth", 400);
        RequestContext.getCurrentInstance().openDialog("/dialogo/addArea.xhtml", options, null);

        // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");
    }

    public void dialogAl() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 130);
        options.put("contentWidth", 400);
        RequestContext.getCurrentInstance().openDialog("/dialogo/addAlmacen.xhtml", options, null);

        // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");
    }

    public void dialogSF(int p) {
        prioridad = p;
       // mate.setListTM(tmf.listaTipoAll());
        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 250);
        options.put("contentWidth", 430);
        RequestContext.getCurrentInstance().openDialog("/dialogo/addSubfam.xhtml", options, null);

        // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");
    }

    public void dialogSF2(int p) {
        prioridad = p;

        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 250);
        options.put("contentWidth", 430);
        RequestContext.getCurrentInstance().openDialog("/dialogo/addSubfam.xhtml", options, null);

        // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");
    }

    public void dialogTM(int p) {
        prioridad = p;
        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 170);
        options.put("contentWidth", 390);

        mate.updateAreas();
        RequestContext.getCurrentInstance().openDialog("/dialogo/addTipo.xhtml", options, null);

        // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");
    }

    public void agregarAl() {
        boolean hecho;

        hecho = af.agregar(descripcionAlmacen);

        if (hecho == true) {
            descripcionAlmacen = null;
            System.out.println("creando msj growl");

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado", "Almacén agregado éxito"));

            // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Parámetros existentes"));
        }

    }

    public void agregarArea() {
        boolean hecho;

        hecho = arf.agregar(descripcionArea);

        if (hecho == true) {
            if (prioridad == 1) {
                descripcionArea = null;
                System.out.println("creando msj growl");
                RequestContext.getCurrentInstance().closeDialog(null);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado", "Área agregada con éxito!!"));
            } else {
                descripcionArea = null;
                mate.setSelectedArea(null);
                mate.setListArea(null);
                RequestContext.getCurrentInstance().closeDialog(null);
            }
            // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Parámetros existentes"));
        }

    }

    public void agregarTipo() {
        boolean hecho;
        if (mate.getSelectedArea() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Seleccionar área"));
        } else {
            hecho = tmf.agregar(descripcionTipoMat, mate.getSelectedArea());

            if (hecho == true) {
                if (prioridad == 1) {
                    descripcionTipoMat = null;
                    AreaTM = null;
                    System.out.println("creando msj growl");

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado", "Tipo de material agregado con éxito"));
                    RequestContext.getCurrentInstance().closeDialog(null);
                    mate.listTM = tmf.listAtm(mate.getSelectedArea().getIdArea());
                    RequestContext.getCurrentInstance().update("formadatos:tbw1:tipo");
                    // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
                } else {
                    descripcionTipoMat = null;
                    AreaTM = null;
                    mate.setListTM(null);
                    mate.setSelectedTipo(null);
                    RequestContext.getCurrentInstance().closeDialog(null);
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Parámetros existentes"));
            }

        }
    }

    public void cerrar() {
        System.out.println("cerrar");
        ///RequestContext.getCurrentInstance().update("formadatos:tbw1");
        RequestContext.getCurrentInstance().closeDialog(null);

    }

    public void list() {

        System.out.println("AJAX");
    }
}
