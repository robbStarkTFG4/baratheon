/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.stateful.NewSessionBean;
import com.server.entity.beans.TblMaterial;
import com.util.MtlDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author NORE
 */
@Named("gd")        // grid de busquedas y carrito
@SessionScoped
public class DataGridSearch implements Serializable {

    private List<TblMaterial> partes;
    private TblMaterial current;

    private int quantity = 0;
    private int cantidad = 0;
    @EJB
    TblMaterialFacade mtl;

    @EJB
    NewSessionBean kart;

    private boolean control = false;

    private List<MtlDTO> list;

    private MtlDTO remove;

    @Inject
    NewClass nm;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addToCart() {  //
        //RequestContext.getCurrentInstance().update(component.getClientId());
        quantity = 0;
        RequestContext.getCurrentInstance().update("form:grid");
        System.out.println(current.getNombre() + "   " + cantidad);
        control = cantidad != 0;
        if (control) {
            if (!kart.add(current, cantidad)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No hay suficiente stock", null));
                cantidad = 0;
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego : " + current.getNombre(), null));
                cantidad = 0;
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Especifica cantidad", null));
        }
    }

    public List<MtlDTO> getList() {
        return list;
    }

    public void removeListener() {/// agregado
        System.out.println("quitar a : " + remove.getNombre());
        kart.removeItem(remove);
        RequestContext.getCurrentInstance().update("form1:table");
    }

    public void openKart() {// este es el carrito

        list = kart.getList();

        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 350);

        RequestContext.getCurrentInstance().openDialog("/dialogo/cart", options, null);
    }

    public void spinnerListener(ValueChangeEvent e) { //AGREGADO
        System.out.println("cambio valor");
        cantidad = (int) e.getNewValue();

    }
    
      public void printList() {
        System.out.println("Lista de piezas en carro");
        list = kart.getList();
        for (MtlDTO dt : list) {
            System.out.println("Nombre: " + dt.getNombre() + " #Parte: " + dt.getNoParte() + " Cantidad: " + dt.getCantidad());
        }
    }
}
