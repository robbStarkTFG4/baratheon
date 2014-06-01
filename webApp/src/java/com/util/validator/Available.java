/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util.validator;

import com.client.named.DataGridSearch;
import com.server.beans.staless.TblMaterialFacade;
import com.sun.xml.ws.security.soap12.Faultreason;
import com.util.MtlDTO;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 *
 * @author NORE
 */
@FacesValidator("check")
public class Available implements Validator{

    @EJB
    TblMaterialFacade mat;
    
    @Inject DataGridSearch dg;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println("SE ACTIVO EL VALIDADOR");
        String val=value.toString();
        int cantidad=0;
          if (val == null || val.trim().equals("")) {
              System.out.println("VALOOOORRRRRRRRRRRRR NULOOOOOOOOOO");
              throw new ValidatorException(new FacesMessage("valor nulo"));
        }
          
        try{
            cantidad=Integer.parseInt(val);
        }catch(NumberFormatException e){
            System.out.println("NO EEEEEEEEEES UUUUUUUUUN NUMERO");
            throw new ValidatorException(new FacesMessage("no es un numero"));
        }
          
        MtlDTO mtl=  dg.getRemove();
        if(mtl==null){
            throw new ValidatorException(new FacesMessage("no llego el parametro"));
        }
        
        if(!mat.checkStock(mtl.getNoParte(), 233)){
            System.out.println("NO HAAAAAAAAAAAAAAYYYYYYY STOOOOOOOOOOOOOOCK");
            throw new ValidatorException(new FacesMessage("no hay stock"));
        }
          
    }
    
}
