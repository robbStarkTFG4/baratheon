/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.validator;

import com.server.beans.staless.TblPrestariosFacade;
import java.lang.annotation.Annotation;
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
@FacesValidator("matVal")
public class MatVal implements Validator {

    @EJB
    TblPrestariosFacade pres;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Integer dadas = 0;
        try {
            dadas = Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "inserta matricula valida", "inserta matricula valida"));
        }

        if (!pres.isAvailable(dadas)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "matricula ya registrada", "matricula ya registrada"));
        }
    }

}
