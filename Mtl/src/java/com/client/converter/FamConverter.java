/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.converter;

import com.client.named.MenuBean;
import com.server.entity.TblTipomaterial;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesConverter("lt")
public class FamConverter implements Converter {

    @Inject
    MenuBean mn;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        }

        try {
            List<TblTipomaterial> lt = mn.getListFamilia();
            for (TblTipomaterial tblTipomaterial : lt) {
                if(tblTipomaterial.getDescripcion().equals(value)){
                    return tblTipomaterial;
                }
            }
        } catch (NullPointerException e) {

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value == null || value.equals("")) {
            return "";
        } else {
            TblTipomaterial mt = (TblTipomaterial) value;
            return mt.getDescripcion();
        }
    }

}
