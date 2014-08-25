/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author NORE
 */
@FacesValidator("up")
public class UploadValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        UploadedFile valor = (UploadedFile) value;

        if (valor.getFileName().isEmpty()) {
            throw new ValidatorException(new FacesMessage(null, "selecciona una imagen", null));
        }
        
        if (valor.getContentType().startsWith("image")) {

        } else {
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "solo imagenes   ", "dimension 100 x"
                    + " 100 pixeles peso maximo 5kb"));
        }
        
       

        if (valor.getSize() >= 5000) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "solo imagenes  , ", "dimension 100 x"
                    + " 100 pixeles peso maximo 5kb"));
        }

    }

}
