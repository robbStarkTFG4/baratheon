/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NamedBeans;

import SessionBeans.AlmacenFacade;
import SessionBeans.SubfamiliasFacade;
import SessionBeans.TblAreaFacade;
import SessionBeans.TblMaterialFacade;
import SessionBeans.TblTipomaterialFacade;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author cristian
 */
@Named("altas")
@SessionScoped

public class Altas implements Serializable {
    
 private String descripcionArea;
 private String descripcionAlmacen;
 private String nombreSubfam;
 private String descripcionSubfam;
 private String descripcionTipoMat;
 private String AreaTM;
//@EJB TblMaterialFacade mf; 
@EJB AlmacenFacade af;
@EJB SubfamiliasFacade sff;
@EJB TblAreaFacade arf;
@EJB TblTipomaterialFacade tmf;

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
 
 
    
public void dialogArea() {
     Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 120);
        options.put("contentWidth", 370);
        RequestContext.getCurrentInstance().openDialog("/dialogos/addArea.xhtml", options, null);
        
  
     // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");

               }    
public void dialogAl() {
     Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 120);
        options.put("contentWidth", 370);
        RequestContext.getCurrentInstance().openDialog("/dialogos/addAlmacen.xhtml", options, null);
        
  
     // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");

               }    
public void dialogSF() {
     Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
         options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 250);
        options.put("contentWidth", 430);
        RequestContext.getCurrentInstance().openDialog("/dialogos/addSubfam.xhtml", options, null);
        
  
     // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");

               }    
    
    public void dialogTM() {
     Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
         options.put("closable", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 170);
        options.put("contentWidth", 390);
        RequestContext.getCurrentInstance().openDialog("/dialogos/addTipo.xhtml", options, null);
        
  
     // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");

               }    
  public void agregarAl(){
      boolean hecho;
  
  hecho=af.agregar(descripcionAlmacen);
  
  if(hecho==true){
      descripcionAlmacen=null;
System.out.println("creando msj growl");    

     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "El Almacen se ha agregado con exito!!"));
     
   // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
  
  }
  else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));}
 
 
     }  
  public void agregarArea(){
      boolean hecho;
  
  hecho=arf.agregar(descripcionArea);
  
  if(hecho==true){
      descripcionArea=null;
System.out.println("creando msj growl");    

     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "El Area se ha agregado con exito!!"));
     
   // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
  
  }
  else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));}
 
 
     }  
  public void agregarSubfam(){
      boolean hecho;
  
  hecho=sff.agregar(nombreSubfam, descripcionSubfam);
  
  if(hecho==true){
      nombreSubfam=null; descripcionSubfam=null;
System.out.println("creando msj growl");    

     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "Subfamilia se ha agregado con exito!!"));
     
   // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
  
  }
  else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));}
 
 
     }    
    public void agregarTipo(){
      boolean hecho;
  if(AreaTM==null){
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Debe seleccionar area"));
  }
  else{
  hecho=tmf.agregar(descripcionTipoMat, AreaTM);
  
  if(hecho==true){
     descripcionTipoMat=null; AreaTM=null;
System.out.println("creando msj growl");    

     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "Tipo de material se ha agregado con exito!!"));
     
   // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
  
  }
  else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));}
 
  }
     }    
    
    public void cerrar(){
        System.out.println("cerrar");
     ///RequestContext.getCurrentInstance().update("formadatos:tbw1");
    RequestContext.getCurrentInstance().closeDialog(null);

    }
   public void list(){
   
       System.out.println("AJAX");
   } 
}
