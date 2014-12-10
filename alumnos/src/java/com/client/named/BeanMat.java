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
    List<TblMaterial> listamat;

    public List<TblMaterial> getListamat() {
        this.listamat = mat.listafull();
        return listamat;
    }

    public void probar() {
        mat.listafull();

    }

}
