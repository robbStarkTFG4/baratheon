/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.client.named.NewClass;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author NORE
 */
@FacesValidator("vl")
public class SpinnerVal implements Validator {

    @Inject
    NewClass nm;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println("id: "+ component.getClientId());
     //   nm.setQuantity(0);
      //  RequestContext.getCurrentInstance().update(component.getClientId());
       //  RequestContext.getCurrentInstance().update("form:grid");
    }

}
