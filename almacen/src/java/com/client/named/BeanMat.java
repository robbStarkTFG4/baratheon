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
material=null;
}
else{
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Material no existente"));
material=null;
}


}
}
