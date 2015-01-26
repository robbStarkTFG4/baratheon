/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.stateful.NewSessionBean;
import com.server.entity.beans.TblMaterial;
import com.util.AreasDTO;
import com.util.MtlDTO;
import com.util.SubFamDTO;
import com.util.TipoDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.component.growl.Growl;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

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

    @EJB
    NewSessionBean kart;//*

    private boolean control = false;

    private List<MtlDTO> list;//*

    private MtlDTO remove;//*

    private TipoDTO selectedType;

    private SubFamDTO selectedFam;

    private List<TipoDTO> tipos;

    private List<AreasDTO> areas;

    private AreasDTO selectedArea;

    @Inject
    NewClass nm;

    @Inject
    Catalog catalog;

    @Inject
    Prestamos pres;

    /*  @PersistenceContext(unitName = "webAppPU")
     private EntityManager em;
    
     @Resource
     private javax.transaction.UserTransaction utx;*/
    private int quantity;
    private int cantidad;

    private List<SubFamDTO> subs;

    private boolean dis = false;
    private boolean skip = true;

    @PostConstruct
    private void init() {
        System.out.println("EL VALOR DEL NAMED: " + nm.getTypeOfSearch());
        performQuery(nm.getTypeOfSearch());
    }

    public DataGridSearch() {

    }

    public List<TblMaterial> getPartes() {
        return partes;
    }

    public void openPopUp() {

        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("contentHeight", 350);

        RequestContext.getCurrentInstance().openDialog("/dialogo/popUp", options, null);
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
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agregó : " + current.getNombre(), null));
                cantidad = 0;
                nm.setKarControl(false);
                RequestContext.getCurrentInstance().update("formass:iconOnly");
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Especificar cantidad", null));
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
        options.put("draggable", true);
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
    public void performQuery(int search) {
        switch (search) {
            case 1:
                System.out.println("ENTRE CASO UNO DE BUSQUEDA");
                searchBoxQuery();
                break;
            case 2:
                break;
        }

    }

    public MtlDTO getRemove() {
        return remove;
    }

    public void setRemove(MtlDTO remove) {
        this.remove = remove;
    }

    public void clearList() {
        kart.clearList();
        RequestContext.getCurrentInstance().update("form1:table");
    }

    public void persistPres() {
        if (pres.getUs() != null) {
            int estado = pres.getUs().getActivo();
            if (!((estado == 0) || (estado == 2))) {
                persistLoanTODB();
            } else {
                FacesContext context = FacesContext.getCurrentInstance();

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El Prestario tiene deudas "));
                RequestContext.getCurrentInstance().update("form1:msg");
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Inicia sesion "));
            RequestContext.getCurrentInstance().update("form1:msg");
        }
    }

    private void persistLoanTODB() {
        //#21312

        if (kart.persistLoan(pres.getUs())) {
            RequestContext.getCurrentInstance().closeDialog(null);
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Éxito", "Prestamo guardado"));

            RequestContext.getCurrentInstance().update("formass:not");
            pres.updateDebts();
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ocurrió un problema"));
            RequestContext.getCurrentInstance().update("formass:not");
        }
    }

    public void areasListener(ValueChangeEvent e) {
        if (e != null) {

            if (e.getNewValue() != null) {
                System.out.println(e.getNewValue().toString());
                this.selectedArea = (AreasDTO) e.getNewValue(); // comprobar que nosea nulo antes de seguir
//                System.out.println(this.selectedType);
//                tipos.clear();
                tipos = catalog.getDynamicTypes().get(this.selectedArea.toString());
                this.selectedFam = null;

            } else {
                tipos = null;
                subs = null;
                this.selectedFam = null;
                this.selectedType = null;
            }
            RequestContext.getCurrentInstance().update("form:subFam");
        }
    }

    public void typesListener(ValueChangeEvent e) {
        if (e != null) {

            if (e.getNewValue() != null) {
                System.out.println(e.getNewValue().toString());
                this.selectedType = (TipoDTO) e.getNewValue(); // comprobar que nosea nulo antes de seguir
                System.out.println(this.selectedType);
                subs = catalog.getDynamicSubs().get(this.selectedType.toString());
                this.selectedFam = null;
                for (SubFamDTO sub : subs) {
                    System.out.println(sub.getNombre());
                }
            } else {
                subs = null;
                this.selectedFam = null;
            }
            RequestContext.getCurrentInstance().update("form:subFam");
        }
    }

    public void subFamsListener(ValueChangeEvent e) {
        if (e != null) {
            if (e.getNewValue() != null) {
                this.selectedFam = ((SubFamDTO) e.getNewValue());
                System.out.println("escogiste: " + this.selectedFam.getNombre());
            } else {
                this.selectedFam = null;
            }
        }
    }

    public void filter() {
        System.out.println("SOY EL FILTRO");
        if (nm.getCaja() == null) {  // busqueda cuando se viene del catalogo
            if (this.selectedFam != null) {
                partes = mtl.catalogFindBySubFam(this.selectedFam.getId());
                for (TblMaterial tblMaterial : partes) {
                    System.out.println(tblMaterial.getNombre());
                }
                RequestContext.getCurrentInstance().update("form:grid");
                return;
            }

            if (this.selectedType != null) {
                partes = mtl.catalogFindByType(this.selectedType.getId());
                RequestContext.getCurrentInstance().update("form:grid");
                return;
            }

            if (this.selectedArea != null) {
                partes = mtl.catalogFindByArea(this.selectedArea.getId());
                RequestContext.getCurrentInstance().update("form:grid");
            }

        } else {
            if (nm.getCaja().getNombre().equals("Buscar: ")) {  // busqueda con patron nombre
                if (this.selectedFam != null) {
                    System.out.println("entre al primer metodito");
                    partes = mtl.catalogFindBySubFam(this.selectedFam.getId(), nm.getCaja().getNoParte());

                    RequestContext.getCurrentInstance().update("form:grid");
                    return;
                }

                if (this.selectedType != null) {
                    System.out.println("entro aqui HOLAAAAAAAAAAAA");
                    partes = mtl.catalogFindByType(this.selectedType.getId(), nm.getCaja().getNoParte());
                    RequestContext.getCurrentInstance().update("form:grid");
                    return;
                }

                if (this.selectedArea != null) {
                    partes = mtl.catalogFindByArea(this.selectedArea.getId(), nm.getCaja().getNoParte());
                    RequestContext.getCurrentInstance().update("form:grid");
                }

            } else if (nm.getCaja().getNombre().equals("noParte")) { // busqueda patron #parte

                if (this.selectedFam != null) {
                    System.out.println("entre al primer metodito");
                    partes = mtl.catalogFindBySubFam(this.selectedFam.getId(), nm.getCaja().getNoParte(), 2);

                    RequestContext.getCurrentInstance().update("form:grid");
                    return;
                }

                if (this.selectedType != null) {
                    System.out.println("entro aqui HOLAAAAAAAAAAAA");
                    partes = mtl.catalogFindByType(this.selectedType.getId(), nm.getCaja().getNoParte(), 5);
                    RequestContext.getCurrentInstance().update("form:grid");
                    return;
                }

                if (this.selectedArea != null) {
                    partes = mtl.catalogFindByArea(this.selectedArea.getId(), nm.getCaja().getNoParte(), 5);
                    RequestContext.getCurrentInstance().update("form:grid");
                }

            } else {
                partes = null;
                RequestContext.getCurrentInstance().update("form:grid");
            }

        }
    }

    public TipoDTO getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(TipoDTO selectedType) {
        this.selectedType = selectedType;
    }

    public SubFamDTO getSelectedFam() {
        return selectedFam;
    }

    public void setSelectedFam(SubFamDTO selectedFam) {
        this.selectedFam = selectedFam;
    }

    public List<TipoDTO> getTypesList() {
        return tipos;
    }

    public void setTypesList(List<TipoDTO> types) {
        this.tipos = types;
    }

    public List<SubFamDTO> getFamsList() {
        return subs;
    }

    public void setFamsList(List<SubFamDTO> list) {
        subs = list;
    }

    public boolean isDis() {
        return dis;
    }

    public void setDis(boolean dis) {
        this.dis = dis;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public List<AreasDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreasDTO> areas) {
        this.areas = areas;
    }

    public AreasDTO getSelectedArea() {
        return selectedArea;
    }

    public void setSelectedArea(AreasDTO selectedArea) {
        this.selectedArea = selectedArea;
    }

    private void searchBoxQuery() {
        if (nm != null) {
            TblMaterial tbl = nm.getCaja();

            if (tbl.getNombre().equals("Buscar: ")) {
                System.out.println("busqueda de patron custom");
                partes = mtl.find(tbl.getNoParte(), false);
            } else if (tbl.getNombre().equals("noParte")) {
                partes = mtl.find(tbl.getNoParte(), false, 1);
            } else {
                System.out.println("busqueda normal");
                partes = mtl.find(tbl.getNoParte());
            }
        }
        ;
    }

    public void onRowCancel(RowEditEvent event) {
        // FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEdit(RowEditEvent event) {
        findErrors();
    }

    private void findErrors() {
        List<MtlDTO> parts = kart.getList();
        String tp = null;
        List<String> msgs = new ArrayList<>();
        if (!parts.isEmpty()) {
            for (MtlDTO mtlDTO : parts) {
                if (!mtl.checkStock(mtlDTO.getNoParte(), mtlDTO.getCantidad())) {
                    System.out.println("NO HAAAAAAAAAAAAAAYYYYYYY STOOOOOOOOOOOOOOCK");

                    tp = mtlDTO.getNombre() + " " + "no hay suficiente stock";
                    msgs.add(tp);
                }
            }
        }
        if (!msgs.isEmpty()) {
            dis = true;
            for (String string : msgs) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(string));
            }
            return;
        }
        dis = false;

    }

    public void checkMsg() {
        if (skip) {
            findErrors();
            RequestContext.getCurrentInstance().update(":form1:msg");
            skip = false;
        }
    }
}
