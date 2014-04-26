/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblMaterialFacade;
import com.server.entity.beans.TblMaterial;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author NORE
 */
@Named("nm")
@SessionScoped                   // usar este bean solo para cosas propias del template " como buscador , navegacion, etc.".
public class NewClass implements Serializable {

    private TblMaterial caja;
    private List<TblMaterial> results;
    @EJB
    TblMaterialFacade mtl;

    @Inject
    DataGridSearch data;

    private boolean karControl = true;

    public NewClass() {

    }

    public TblMaterial getCaja() {
        return caja;
    }

    public List<TblMaterial> getResults() {
        return results;
    }

    public void setCaja(TblMaterial caja) {
        this.caja = caja;
    }

    public List<TblMaterial> autoComplete(String patron) { // metodo del buscador 
        System.out.println("sigo funcionando autoComplete METODO");
        if (patron.matches("^[a-zA-Z0]*$")) {
            results = mtl.autoQueryName(patron);
        } else {
            results = mtl.autoQueryPartNumber(patron);
        }

        // System.out.println(patron);
        return results;
    }

    //dfsfdsdsadas
    public String processQuery() {
        System.out.println("sigo funcionando BUSCADOR commandButton");

       // FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "logIn.xhtml");
        //com.setValue(new TblMaterial);
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
        // returns something like "/myapplication/home.faces"
        String fullURI = servletRequest.getRequestURI();

        System.out.println("estoy en: " + fullURI);

        if (!fullURI.equals("/webApp/faces/grid.xhtml")) {
            System.out.println("entre en el redirect");
            return "/grid.xhtml?faces-redirect=true";
        } else {
            System.out.println("estoy en el ajax");
            data.performQuery();
            RequestContext.getCurrentInstance().update("form:grid");
            return null;
        }

    }

    public boolean isKarControl() {
        return karControl;
    }

    public void setKarControl(boolean karControl) {
        this.karControl = karControl;
    }

}
