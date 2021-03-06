/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.converters;

import com.client.named.BeanMat;
import com.client.named.BeanMateriales;
import com.server.entity.beans.Subfamilias;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesConverter("ModSubConv")
public class ModSubConv implements Converter {

    @Inject
    BeanMat mat;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        }
        try {
            for (Subfamilias li : mat.getListSF()) {
                if (li.getNombre().equals(value)) {
                    return li;
                }
            }
        } catch (NullPointerException ne) {

        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
          if (value == null || value.equals("")) {
            return "";
        } else {
            Subfamilias type = (Subfamilias) value;
            return type.getNombre();
        }
    }

}
