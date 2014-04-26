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
<<<<<<< HEAD
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
>>>>>>> 471ac71a155ada97611164a2333bc6502923c094
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.context.RequestContext;
=======
>>>>>>> 471ac71a155ada97611164a2333bc6502923c094

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

<<<<<<< HEAD
    @EJB
    NewSessionBean kart;//*

    private boolean control = false;

    private List<MtlDTO> list;//*

    private MtlDTO remove;//*

    @Inject
    NewClass nm;

    /*  @PersistenceContext(unitName = "webAppPU")
     private EntityManager em;
    
     @Resource
     private javax.transaction.UserTransaction utx;*/
=======
    @Inject
    NewClass nm;

    private boolean control = false;

>>>>>>> 471ac71a155ada97611164a2333bc6502923c094
    @PostConstruct
    private void init() {
        performQuery();
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

<<<<<<< HEAD
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addToCart() {  //*
        //RequestContext.getCurrentInstance().update(component.getClientId());
        quantity = 0;
        RequestContext.getCurrentInstance().update("form:grid");//form
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
                nm.setKarControl(false);
                RequestContext.getCurrentInstance().update("formass:iconOnly");
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Especifica cantidad", null));
        }
    }

    public List<MtlDTO> getList() {//*
        return list;
    }

    public void removeListener() {/// agregado    //*
        System.out.println("quitar a : " + remove.getNombre());
        kart.removeItem(remove);
        RequestContext.getCurrentInstance().update("form1:table");
    }

    public void openKart() {// este es el carrito  //*

        list = kart.getList();

        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 350);

        RequestContext.getCurrentInstance().openDialog("/dialogo/cart", options, null);
    }

    public void spinnerListener(ValueChangeEvent e) { //AGREGADO  //*
        System.out.println("cambio valor");
        cantidad = (int) e.getNewValue();

    }

    public void printList() {//*
        System.out.println("Lista de piezas en carro");
        list = kart.getList();
        for (MtlDTO dt : list) {
            System.out.println("Nombre: " + dt.getNombre() + " #Parte: " + dt.getNoParte() + " Cantidad: " + dt.getCantidad());
        }
    }

    /*   public void persist(Object object) {
     try {
     utx.begin();
     em.persist(object);
     utx.commit();
     } catch (Exception e) {
     Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
     throw new RuntimeException(e);
     }
     }*/
    public void performQuery() {
        TblMaterial tbl = nm.getCaja();
        if (tbl.getNombre().equals("Buscar: ")) {
            System.out.println("busqueda de patron custom");
            partes = mtl.find(tbl.getNoParte(), false);
        } else {
            System.out.println("busqueda normal");
            partes = mtl.find(tbl.getNoParte());
        }
    }

    public MtlDTO getRemove() {
        return remove;
    }

    public void setRemove(MtlDTO remove) {
        this.remove = remove;
    }

=======
>>>>>>> 471ac71a155ada97611164a2333bc6502923c094
}
