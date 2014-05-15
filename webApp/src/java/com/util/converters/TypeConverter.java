/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.converters;

import com.client.named.Catalog;
import com.server.entity.beans.TblTipomaterial;
import com.util.TipoDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesConverter("type")
public class TypeConverter implements Converter {

    @Inject Catalog catalog;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value == null || value.trim().equals("")) {
            return null;
        }
        try {
            for (TipoDTO li : catalog.getTipos()) {
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
             TipoDTO type = (TipoDTO) value;
            return type.getNombre();
        }
    }
    
}
