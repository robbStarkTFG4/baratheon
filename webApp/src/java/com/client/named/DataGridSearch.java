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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("gd")        // grid de busquedas y carrito
@SessionScoped
public class DataGridSearch implements Serializable {

    private List<TblMaterial> partes;
    private TblMaterial current;

    @EJB
    TblMaterialFacade mtl;

    @Inject
    NewClass nm;

    private boolean control = false;

    @PostConstruct
    private void init() {
        TblMaterial tbl = nm.getCaja();
        if (tbl.getNombre().equals("Buscar: ")) {
            System.out.println("busqueda de patron custom");
            partes = mtl.find(tbl.getNoParte(), false);
        } else {
            System.out.println("busqueda normal");
            partes = mtl.find(tbl.getNoParte());
        }
    }

    public DataGridSearch() {

    }

    public List<TblMaterial> getPartes() {
        return partes;
    }

    public void openPopUp() {

    }

    public void setPartes(List<TblMaterial> partes) {
        this.partes = partes;
    }

    public TblMaterial getCurrent() {
        return current;
    }

    public void setCurrent(TblMaterial current) {
        this.current = current;
    }

}
