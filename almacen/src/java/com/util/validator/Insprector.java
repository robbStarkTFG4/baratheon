/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.validator;

import com.server.beans.staless.TblMaterialFacade;
import com.util.DetailDTO;
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
@FacesValidator("inspector")
public class Insprector implements Validator {

    @EJB
    TblMaterialFacade mtl;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        int quantity = 0;
        try {
            quantity = Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage());
        }
        try {
            System.out.println("HOLAAAAAAAAAAAAAA DEL VALIDADOR");
            DetailDTO dl = (DetailDTO) component.getAttributes().get("obj");
            System.out.println(dl.getNombre() + " " + quantity);

            if (!mtl.checkStock(dl.getNoParte(), quantity)) {
                System.out.println("NO HAY SUFICIENTE STOCK PARA ASIGNAR ESA CANTIDAD");
                throw new ValidatorException(new FacesMessage());
            }
        } catch (NullPointerException e) {
            System.out.println("NO SALIO EL PARAMETRO");
        }
    }

}
