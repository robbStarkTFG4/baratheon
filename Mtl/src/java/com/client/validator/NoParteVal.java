/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.client.validator;

import com.server.stateless.TblMaterialFacade;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author NORE
 */
@FacesValidator("check")
public class NoParteVal implements Validator{

    @EJB TblMaterialFacade mtl;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      String dato= (String) value;
      if(dato.length()<=2){
          throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "se necesitan mas de 3 caracteres", null));
      }
      
      boolean isAv=mtl.isAvailable(dato);
      if(isAv){
          System.out.println("si entro");
          throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Una pieza con ese numero de parte ya existe", null));
      }
      
      
    }
    
}
