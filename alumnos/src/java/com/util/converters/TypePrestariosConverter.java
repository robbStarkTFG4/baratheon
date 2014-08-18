/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.converters;

import com.client.named.RegisterPrestario;
import com.util.TipoPrestarioDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesConverter("stype")
public class TypePrestariosConverter implements Converter {

    @Inject
    RegisterPrestario reg;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        }
        try {
            for (TipoPrestarioDTO li : reg.getTypes()) {
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
            TipoPrestarioDTO type = (TipoPrestarioDTO) value;
            return type.getDescripcion();
        }
    }

}
