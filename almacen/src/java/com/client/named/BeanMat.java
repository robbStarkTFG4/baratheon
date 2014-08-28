/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;


import com.server.beans.staless.TblMaterialFacade;
import com.server.entity.beans.TblMaterial;
import com.util.materialBusqueda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author cristian
 */
@Named("material")
@SessionScoped
public class BeanMat implements Serializable {

    @EJB
    TblMaterialFacade mat;
    TblMaterial matencontrado;
    List<TblMaterial> listamat;
    String noparte;
    List<materialBusqueda> listaEtiquetas;
    List<String> lista = new ArrayList<>();



    public List<materialBusqueda> getListaEtiquetas() {
        
        return listaEtiquetas;
    }

    public void setListaEtiquetas(List<materialBusqueda> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

   

    public TblMaterial getMatencontrado() {
        return matencontrado;
    }

    public void setMatencontrado(TblMaterial matencontrado) {
        this.matencontrado = matencontrado;
    }


    public TblMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TblMaterial material) {
        this.material = material;
    }
    
TblMaterial material;

    public String getNoparte() {
        return noparte;
    }

    public void setNoparte(String noparte) {
        this.noparte = noparte;
    }

    public List<TblMaterial> getListamat() {
        this.listamat = mat.listafull();
        return listamat;
    }

    public void probar() {
        mat.listafull();

    }
    
public void busqueda(){
    
matencontrado=mat.bpormat(material.getNoParte());
if(matencontrado!=null){
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Encontrado!", "Material encontrado!!"));
listaEtiquetas=getList();
 material=null;
}
else{
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Material no existente"));
listaEtiquetas=null;
material=null;
}


}
public void prueba2(){
       /* lista.add("Numero de parte:");
        lista.add("Nombre:");
        lista.add("Descripcion:");
        lista.add("Stock:");
        lista.add("Ubicacion actual:");
        lista.add("Marca:");
        lista.add("Responsable:");
        lista.add("Almacen:");
        lista.add("Area:");
        lista.add("Tipo de material:");
        lista.add("Subfamilia:");  */
listaEtiquetas=getList();
    System.out.println(listaEtiquetas);
}

 public List<materialBusqueda> getList(){
   List<materialBusqueda> list=new ArrayList<>();
    
  //public Productos(String numPart, String nombre, String descripcion, String marca)  
    list.add(new materialBusqueda("Numero de parte:",matencontrado.getNoParte()));
    list.add(new materialBusqueda("Nombre:",matencontrado.getNombre()));
    list.add(new materialBusqueda("Descripcion:",matencontrado.getDescripcion()));
    list.add(new materialBusqueda("Stock:",matencontrado.getStock().toString()));
    list.add(new materialBusqueda("Ubicacion actual:",matencontrado.getUbicacionActual()));
    list.add(new materialBusqueda("Marca:",matencontrado.getMarca()));
    list.add(new materialBusqueda("Responsable:",matencontrado.getResponsable()));
    list.add(new materialBusqueda("Almacen:",matencontrado.getAlmacenIdalmacen().getDescripcion()));
    list.add(new materialBusqueda("Area:",matencontrado.getIdArea().getDescripcion()));
    list.add(new materialBusqueda("Tipo de material:",matencontrado.getIdTipomaterial().getDescripcion()));
    list.add(new materialBusqueda("Subfamilia",matencontrado.getSubFamiliasidsubFam().getNombre()));
   
    return list;
    }
}
