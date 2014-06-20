/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author NORE
 */
@FacesValidator("cantidad")
public class Quantity implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //Object oldValue = ((UIInput) component).getValue();// permite obtener el valor viejo en un mismo componente
        //System.out.println("Valor viejo: " + oldValue);

        int valor = (int) component.getAttributes().get("valor");  //obteniendo valor de otro componente agreandolo a loas parametros de otro.
        System.out.println("Valor prestada: " + valor);
        System.out.println("Valor a entregar: " + value);

        int newVal = 0;
        try {
            newVal = Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage());
        }

        if (newVal > valor) {
            throw new ValidatorException(new FacesMessage());
        }
    }

}
