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
import entitys.Almacen;
import entitys.Subfamilias;
import entitys.TblArea;
import entitys.TblTipomaterial;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

import org.primefaces.model.UploadedFile;

@Named("mat")
@SessionScoped

public class BeanMateriales implements Serializable {
   
 private String nombre;
 private String noParte;
 private String descripcion;
 private String cantidad;
 private String costo;
 private String unidadmedida;
 private String marca;
 private String serie;
 private String estado;
 private String ubicacion;
 
 private String responsable;
 private String probedor;
 private String noFactura;
 private String ordenDcompra;
 private String zip;
 private String financiamiento;
 private String tipodecompra;
 private String idUABC;
 private String fecharecepcion;
 
 private String area;
 private String tipodematerial;
 private String subfamilia;
 private String almacen;
 
 private boolean disableGuardar=true;
 private boolean disableTab1=false;
 private boolean disableTab2=true;
 private boolean disableTab3=true;
 private String activeIndex;

 
 private UploadedFile file;
    private String imagen;
    private final String ruta = "C:\\imagenes\\";
@EJB  TblMaterialFacade mf; 
@EJB AlmacenFacade af;
@EJB SubfamiliasFacade sff;
@EJB TblAreaFacade arf;
@EJB TblTipomaterialFacade tmf;
    private boolean control = false;
List<TblArea> listArea;
List<Almacen> lalm ;
List<TblTipomaterial> listTM;
List<Subfamilias> listSF;

    public List<TblArea> getListArea() {
        this.listArea=arf.listAr();
        return listArea;
    }

    public void setListArea(List<TblArea> listArea) {
        this.listArea = listArea;
    }

    public List<TblTipomaterial> getListTM() {
        this.listTM=tmf.listAtm();
        return listTM;
    }

    public void setListTM(List<TblTipomaterial> listTM) {
        this.listTM = listTM;
    }

    public List<Subfamilias> getListSF() {
        this.listSF=sff.listAL();
        return listSF;
    }

    public void setListSF(List<Subfamilias> listSF) {
        this.listSF = listSF;
    }

    public List<Almacen> getLalm() {
        this.lalm=af.listAL();
        return lalm;
    }

    public void setLalm(List<Almacen> lalm) {
        this.lalm = lalm;
    }



    public String getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(String activeIndex) {
        this.activeIndex = activeIndex;
    }
    
public void goToTab(int i) {
   if(i==1){
   disableTab2=false;
   }
    if(i==2){
   disableTab3=false;
   }
    String id= Integer.toString(i);
         this.activeIndex = id;
     }
   

    public boolean isDisableTab1() {
        return disableTab1;
    }

    public void setDisableTab1(boolean disableTab1) {
        this.disableTab1 = disableTab1;
    }

    public boolean isDisableTab2() {
        return disableTab2;
    }

    public void setDisableTab2(boolean disableTab2) {
        this.disableTab2 = disableTab2;
    }

    public boolean isDisableTab3() {
        return disableTab3;
    }

    public void setDisableTab3(boolean disableTab3) {
        this.disableTab3 = disableTab3;
    }

    public boolean isDisableGuardar() {
        return disableGuardar;
    }

    public void setDisableGuardar(boolean disableGuardar) {
        this.disableGuardar = disableGuardar;
    }

public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getProbedor() {
        return probedor;
    }

    public void setProbedor(String probedor) {
        this.probedor = probedor;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getOrdenDcompra() {
        return ordenDcompra;
    }

    public void setOrdenDcompra(String ordenDcompra) {
        this.ordenDcompra = ordenDcompra;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    public String getTipodecompra() {
        return tipodecompra;
    }

    public void setTipodecompra(String tipodecompra) {
        this.tipodecompra = tipodecompra;
    }

    public String getIdUABC() {
        return idUABC;
    }

    public void setIdUABC(String idUABC) {
        this.idUABC = idUABC;
    }

    public String getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(String fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipodematerial() {
        return tipodematerial;
    }

    public void setTipodematerial(String tipodematerial) {
        this.tipodematerial = tipodematerial;
    }

    public String getSubfamilia() {
        return subfamilia;
    }

    public void setSubfamilia(String subfamilia) {
        this.subfamilia = subfamilia;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
 
    
 
    public void agregar(){
        
 /*nombre+noParte+descripcion+cantidad+costo+unidadmedida+marca+serie+estado+ubicacion+responsable+probedor+noFactura;
 +ordenDcompra+zip+financiamiento+tipodecompra+idUABC+fecharecepcion+area+tipodematerial+subfamilia+almacen+imagen;
   */
       
 System.out.println(nombre+noParte+descripcion+cantidad+costo+unidadmedida+marca+serie+estado+ubicacion+responsable+probedor+noFactura
 +ordenDcompra+zip+financiamiento+tipodecompra+idUABC+fecharecepcion+area+tipodematerial+subfamilia+almacen+imagen); 
    
  
    
    }
    public String cancelar(){
activeIndex="0";
nombre=null;noParte=null; descripcion=null; cantidad=null; costo=null; unidadmedida=null; marca=null;serie=null; estado=null;ubicacion=null; responsable=null; probedor=null; noFactura=null; ordenDcompra=null; zip=null; financiamiento=null; tipodecompra=null; idUABC=null ;fecharecepcion=null; area=null;tipodematerial=null; subfamilia=null; almacen=null;imagen=null;   
disableTab1=false;
disableTab2=true;
disableTab3=true;
disableGuardar=true;
return "index.xhtml?faces-redirect=true";
    
    
    }
     public void agregarmat(){
      boolean hecho;
  if(area==null||tipodematerial==null|| subfamilia==null|| almacen==null){
     String er = null; 
      if(area==null){er=er+" Area,";}if(tipodematerial==null){er=er+" Tipo,";}if(subfamilia==null){er=er+" subfamilia,";}if(almacen==null){er=er+" almacen";}
      
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Debe seleccionar: "+er));
  }
  else{
  hecho=mf.agregar11(nombre, noParte, descripcion, cantidad, costo, unidadmedida, marca, serie, estado, ubicacion, responsable, probedor, noFactura, ordenDcompra, zip, financiamiento, tipodecompra, idUABC, fecharecepcion, area, tipodematerial, subfamilia, almacen, imagen);
  
  if(hecho==true){
nombre=null;noParte=null; descripcion=null; cantidad=null; costo=null; unidadmedida=null; marca=null;serie=null; estado=null;ubicacion=null; responsable=null; probedor=null; noFactura=null; ordenDcompra=null; zip=null; financiamiento=null; tipodecompra=null; idUABC=null ;fecharecepcion=null; area=null;tipodematerial=null; subfamilia=null; almacen=null;imagen=null;
      System.out.println("creando msj growl");    
disableTab1=false;
disableTab2=true;
disableTab3=true;
disableGuardar=true;
activeIndex="0";
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado!", "El material se ha agregado con exito!!"));
     
   // RequestContext.getCurrentInstance().update("menu:f2:growlcq");
  
  }
  else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Existen parametros unicos ya existentes en la base de datos"));}
 
  }
     }
     
     public void imprimir(){
     
        // RequestContext.getCurrentInstance().update("formadatos:tbw1");
         System.out.println("almace:"+almacen+" subfa:"+subfamilia+" area:"+area+" tipo:"+tipodematerial);
     }


 public void handleFileUpload(FileUploadEvent event) {
     imagen=event.getFile().getFileName();
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
  public void upload() {
        if (file != null) {
            //FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + "is uploaded");
            //FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                guardarImagen(file.getFileName(), file.getInputstream());
                System.out.println(file.getFileName());
               //  RequestContext.getCurrentInstance().update("formadatos:tbw1");
               if(file.getFileName().equals("")){System.out.println("no img");}
               else{
                disableGuardar=false;
                RequestContext.getCurrentInstance().update("formadatos:tbw1");
                RequestContext.getCurrentInstance().closeDialog(null);}
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
public void dialogimagen() {
     Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 150);
        options.put("contentWidth", 400);
        RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml", options, null);
        
  
     // RequestContext.getCurrentInstance().openDialog("/Imagen.xhtml");

               }
    
    
    
    
    
    
    
    
    
}
