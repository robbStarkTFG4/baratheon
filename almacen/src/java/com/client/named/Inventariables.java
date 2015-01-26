/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblPendientesFacade;
import com.server.beans.staless.TblpiezasFacade;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPendientes;
import com.server.entity.beans.Tblpiezas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author NORE
 */
@Named("inventariable")
@javax.faces.view.ViewScoped
public class Inventariables implements Serializable {

    @EJB
    TblpiezasFacade pzFacade;
    @EJB
    TblPendientesFacade pending;

    private TblMaterial pieza;
    private List<Tblpiezas> piezas;

    private Tblpiezas current;

    private boolean selectForDelete = true;
    private boolean panelBoton = false;
    private boolean showEditor = true;
    private boolean showButton = true;
    private int amountItems;

    private TblPendientes pendiente;

    private List<Tblpiezas> borrar;

    public Inventariables() {
    }

    public TblMaterial getPieza() {
        return pieza;
    }

    public void setPieza(TblMaterial pieza) {
        this.pieza = pieza;
    }

    public List<Tblpiezas> getPiezas() {
        return piezas;
    }

    public Tblpiezas getCurrent() {
        return current;
    }

    public boolean isSelectForDelete() {
        return selectForDelete;
    }

    public void setSelectForDelete(boolean selectForDelete) {
        this.selectForDelete = selectForDelete;
    }

    public void setCurrent(Tblpiezas current) {
        this.current = current;
    }

    public boolean isPanelBoton() {
        return panelBoton;
    }

    public void setPanelBoton(boolean panelBoton) {
        this.panelBoton = panelBoton;
    }

    public boolean isShowEditor() {
        return showEditor;
    }

    public void setShowEditor(boolean showEditor) {
        this.showEditor = showEditor;
    }

    public List<Tblpiezas> getBorrar() {
        return borrar;
    }

    public void setBorrar(List<Tblpiezas> borrar) {
        this.borrar = borrar;
    }

    public boolean isShowButton() {
        return showButton;
    }

    public void setShowButton(boolean showButton) {
        this.showButton = showButton;
    }

    public void buscar() {
        //System.out.println("qwewqewqeqwewqeqweqwacxcxzprewvckv ");

        pendiente = pending.findPending(pieza.getNoParte());
        if (pendiente != null) {
            amountItems = Integer.parseInt(pendiente.getConcepto());
            System.out.println("la cantidad para borrar es: " + amountItems);
            selectForDelete = false;
            showEditor = false;
            showButton = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccionar" + "(" + amountItems + ")" + " elementos a eliminar", null));
            RequestContext.getCurrentInstance().update("formainvents:actGuardar");
        } else {
            selectForDelete = true;
            showButton = false;
            RequestContext.getCurrentInstance().update("formainvents:actGuardar");
        }

        piezas = pzFacade.findItems(pieza.getNoParte());

        //RequestContext.getCurrentInstance().update("formainvents:actGuardar");
        RequestContext.getCurrentInstance().update("formainvents:searchItems");
        RequestContext.getCurrentInstance().update("formainvents:actGuardar");
    }

    public void addToList() {
        if (borrar == null) {
            borrar = new ArrayList<>();
        }
        if ((borrar.size() + 1) < amountItems) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccionar" + "(" + (amountItems - (borrar.size() + 1)) + ")" + " elementos a eliminar", null));

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Presiona Guardar para realizar los cambios", null));
            selectForDelete = true;
            panelBoton = true;
            RequestContext.getCurrentInstance().update("formainvents:searchItems");
            RequestContext.getCurrentInstance().update("formainvents:btnPanel");
        }
        piezas.remove(current);
        borrar.add(current);
        RequestContext.getCurrentInstance().update("formainvents:searchItems");
        RequestContext.getCurrentInstance().update("formainvents:brr");

        //  System.out.println(current.getNoPartemodelo());
    }

    public void borraLista() {
        panelBoton = false;
        showEditor = true;
        showButton = false;
        for (Tblpiezas pieza1 : borrar) {
            System.out.println(pieza1);
            try {
                pzFacade.remove(pieza1);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hubo algun error intenta mas tarde.", null));
            }
        }

        try {
            pending.remove(pendiente);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hubo algun error intenta mas tarde.", null));
        }
        borrar.clear();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambios guardados con exito.", null));
        RequestContext.getCurrentInstance().update("formainvents:searchItems");
        RequestContext.getCurrentInstance().update("formainvents:btnPanel");
        RequestContext.getCurrentInstance().update("formainvents:brr");
        RequestContext.getCurrentInstance().update("formainvents:actGuardar");
    }

    public void verLista() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Presiona Eliminar para realizar los cambios", null));
        System.out.println("mostrar lista");
    }

    public void guardarLista() {
        if (piezas != null) {
            if (piezas.size() > 0) {
                boolean showMsg = false;
                for (Tblpiezas pz : piezas) {
                    if ((pz.getInventarioUabc() != null)) {
                        if (!pz.getInventarioUabc().trim().equals("")) {
                            showMsg = true;
                            if (pz.getEstatus() != null) {
                                if (pz.getEstatus()) {
                                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                            "No se puede modificar: " + pz.getNombre() + " Inventario UABC: " + pz.getInventarioUabc(), null));
                                } else {
                                    pzFacade.edit(pz);
                                }
                            } else {
                                pz.setEstatus(false);
                                pzFacade.edit(pz);
                            }

                        }
                    }

                }

                if (showMsg) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Cambios guardados con exito.", null));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "no hubo resultados", null));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utiliza el buscador", null));
        }
    }
}
