/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblPrestariosFacade;
import com.server.entity.beans.TblPrestarios;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author NORE
 */
@Named("pres")
@SessionScoped
public class Prestamos implements Serializable { //clase para manejar los prestamos

    @EJB
    TblPrestariosFacade usr;

    private String nombre;
    private String correo;
    private String carrera;
    private String telefono;
    private String matricula;
    private TblPrestarios us;

    public Prestamos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TblPrestarios getUs() {
        return us;
    }

    public void setUs(TblPrestarios us) {
        this.us = us;
    }

    public void findPres() {
        us = usr.getPres(matricula);
        if (us != null) {
            this.carrera = us.getCarrera();
            this.correo = us.getEmail();
            this.nombre = us.getNombre();
            this.telefono = us.getTel();
            System.out.println("me llamo: " + us.getEmail());
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("error", "no se encontro ningun prestario "));
        }
    }
}
