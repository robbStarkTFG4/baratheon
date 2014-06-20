/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.converters;

import com.client.named.Catalog;
import com.client.named.DataGridSearch;
import com.util.SubFamDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesConverter("sub")
public class SubFamsConverter implements Converter{

    @Inject DataGridSearch sh;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value == null || value.trim().equals("")) {
            return null;
        }
        try {
            for (SubFamDTO li : sh.getFamsList()) {
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
             SubFamDTO type = (SubFamDTO) value;
            return type.getNombre();
        }
    }
    
}
