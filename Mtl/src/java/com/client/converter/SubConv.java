/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.client.converter;

import com.client.named.MenuBean;
import com.server.entity.Subfamilias;
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
@FacesConverter("sub")
public class SubConv implements Converter {

    @Inject MenuBean mn;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value == null || value.trim().equals("")) {
            return null;
        }
         try{
             List<Subfamilias> subs= mn.getListSubs();
             for (Subfamilias object : subs) {
                 if(object.getNombre().equals(value)){
                     return object;
                 }
             }
         }catch( NullPointerException e){
             System.out.println("valor nulo del sub converter");
         }
         
         return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if (value == null || value.equals("")) {
            return "";
        } else {
            Subfamilias mt = (Subfamilias) value;
            return mt.getNombre();
        }
    }
    
}
