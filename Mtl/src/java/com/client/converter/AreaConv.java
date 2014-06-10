/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.converter;

import com.client.named.MenuBean;
import com.server.entity.TblArea;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesConverter("pl")
public class AreaConv implements Converter {

    @Inject
    MenuBean mn;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        }
        try {
            for (TblArea li : mn.getListArea()) {
                if (li.getDescripcion().equals(value)) {
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
            TblArea mt = (TblArea) value;
            return mt.getDescripcion();
        }
    }

}
