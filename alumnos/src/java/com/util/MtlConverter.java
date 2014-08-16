/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;



import com.client.named.NewClass;
import com.server.entity.beans.TblMaterial;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;


/**
 *
 * @author NORE
 */
@FacesConverter("mtl")
public class MtlConverter implements Converter {

    @Inject
    NewClass nm;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        }
        try {
            String noParte = value;
            List<TblMaterial> tags = nm.getResults();
            for (TblMaterial t : tags) {
                if (t.getNoParte().equals(noParte)) {
                    return t;
                }
            }
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, " Error", null));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            TblMaterial mt = (TblMaterial) value;
            return mt.getNoParte();
        }
    }

}
