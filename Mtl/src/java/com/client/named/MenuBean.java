package com.client.named;

import com.server.entity.MapF;
import com.server.entity.Subfamilias;
import com.server.entity.TblArea;
import com.server.entity.TblTipomaterial;
import com.server.stateless.MapFacade;
import com.server.stateless.TblAreaFacade;
import com.server.stateless.TblMaterialFacade;
import com.server.stateless.TblTipomaterialFacade;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author seven
 */
@SessionScoped
@Named("Menu")

public class MenuBean implements Serializable {

    private List<TblArea> listArea;
    private List<TblTipomaterial> listFamilia;
    private List<Subfamilias> listSubs;

    private TblArea selectArea;
    private TblTipomaterial selectFam;
    private Subfamilias selectSub;

    private String nombre;
    private String cantidad;
    private String precio;
    private String noParte;
    private String descripcion;

    private UploadedFile file;
    private String imagen;
    private final String ruta = "C:\\imagenes\\";

    private boolean control = false;

    @EJB
    TblAreaFacade ar;

    @EJB
    MapFacade mp;

    @EJB
    TblMaterialFacade mtl;

    @EJB
    TblTipomaterialFacade type;

    @PostConstruct
    private void init() {
        // System.out.println("se invoca el post");
        listArea = ar.list();  // cambiar este metodo por uno que omita la lista de materiales
        listArea.size();

        /* for (TblArea tblArea : listArea) {
         System.out.println(tblArea.getDescripcion());
         }*/
        UIInput caja = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("forma:nomb");

    }

    public void Listener(ValueChangeEvent e) {
        // System.out.println("listener1  si llegooooo");
        TblArea tb = (TblArea) e.getNewValue();
//        System.out.println(tb.getDescripcion());
        try {
            listFamilia = type.getTypes(tb.getIdArea()); //implementar un metodo custom que omita la lista de materiales

        } catch (NullPointerException ds) {
            selectArea = null;
            listFamilia = null;
            listSubs = null;
            selectFam = null;
            //  selectSub = null;

        }
        //System.out.println(listFamilia.get(0).getDescripcion());
    }

    public void Listener2(ValueChangeEvent e) {
        //System.out.println("listener2");
        selectFam = (TblTipomaterial) e.getNewValue();
        //  List<MapF> mp= type.getMapList();

        //System.out.println("la categoria es: " + type.getTblAreaIdArea().getIdArea() + " el tipo es: " + type.getIdTipomaterial());
        listSubs = mp.getSubs(selectFam.getIdTipomaterial());

    }

    public String m() {

        FacesContext context = FacesContext.getCurrentInstance();
        //create(String nombre, String noParte, String descripcion, String stock, String costo, String imagen, Subfamilias sub, TblTipomaterial fam, TblArea area)
        boolean op = mtl.create(nombre, noParte, descripcion, cantidad, precio, imagen, selectSub, selectFam, selectArea);
        if (op) {
            context.addMessage(null, new FacesMessage("Mensaje", "INFORMACION GUARDADA"));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "HUBO ALGUN ERROR"));
        }

        selectArea = null;
        selectFam = null;
        selectSub = null;

        listFamilia = null;
        listSubs = null;

        nombre = null;
        cantidad = null;
        precio = null;
        noParte = null;
        descripcion = null;
        RequestContext.getCurrentInstance().update("forma:combo1");
        RequestContext.getCurrentInstance().update("forma:combo2");
        RequestContext.getCurrentInstance().update("forma:combo3");

        RequestContext.getCurrentInstance().update("forma:nom");
        RequestContext.getCurrentInstance().update("forma:cant");
        RequestContext.getCurrentInstance().update("forma:cost");
        return "index";
    }

    public void upload() {
        if (file != null) {
            //FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + "is uploaded");
            //FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                guardarImagen(file.getFileName(), file.getInputstream());
            } catch (IOException ex) {
                //Logger.getLogger(Image.class.getName()).log(Level.SEVERE,null,ex));
            }
        }
    }

    public void guardarImagen(String nombre, InputStream in) {
        imagen = nombre;
        try {
            OutputStream out = new FileOutputStream(new File(ruta + nombre));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
            System.out.println("Archivo Guardado");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

//getters and setters
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

//dasdsa
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public List<TblArea> getListArea() {
        return listArea;
    }

    public TblArea getSelectArea() {
        return selectArea;
    }

    public void setSelectArea(TblArea selectArea) {
        this.selectArea = selectArea;
    }

    public List<TblTipomaterial> getListFamilia() {
        return listFamilia;
    }

    public TblTipomaterial getSelectFam() {
        return selectFam;
    }

    public void setSelectFam(TblTipomaterial selectFam) {
        this.selectFam = selectFam;
    }

    public List<Subfamilias> getListSubs() {
        return listSubs;
    }

    public Subfamilias getSelectSub() {

        return selectSub;
    }

    public void setSelectSub(Subfamilias selectSub) {
        this.selectSub = selectSub;
    }

    public void forward(ValueChangeEvent e) {
        System.out.println("si salgo subss");
        Subfamilias se = (Subfamilias) e.getNewValue();
        System.out.println(se.getNombre());
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isControl() {
        return control;
    }

    public void checkAvaliability(ValueChangeEvent e) {
        System.out.println(e.getNewValue().toString());
    }

}
