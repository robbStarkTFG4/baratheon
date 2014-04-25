/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblDetalleprestamoFacade;
import com.server.beans.staless.TblPrestamoFacade;
import com.server.beans.staless.TblPrestariosFacade;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblPrestarios;
import com.util.DetailDTO;
import com.util.PresDTO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author NORE
 */
@Named("pres")
@SessionScoped
public class Prestamos implements Serializable { //clase para manejar los prestamos
    // clase para ver historial de prestamos y deudas actuales

    @EJB
    TblPrestariosFacade usr;

    @EJB
    TblDetalleprestamoFacade dtl;

    @EJB
    TblPrestamoFacade pres;

    private String nombre;
    private String correo;
    private String carrera;
    private String telefono;
    private String matricula;
    private List<TblPrestamo> list;
    private TblPrestarios us;
    private List<PresDTO> res;
    private List<DetailDTO> dtlPres;
    Map<Integer, List<DetailDTO>> details = new HashMap<>();
    static int pos = 0;

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

    public List<PresDTO> getRes() {

        return res;

    }

    public void setRes(List<PresDTO> res) {
        this.res = res;
    }

    public List<DetailDTO> getDtlPres() {

        return dtlPres;
    }

    public void findPres() {
        us = usr.getPres(matricula);
        if (us != null) {
            this.carrera = us.getCarrera();
            this.correo = us.getEmail();
            this.nombre = us.getNombre();
            this.telefono = us.getTel();
            //this.list=us.getTblPrestamoList();

            System.out.println("datos del prestamo");

            res = pres.getLoanByPresDebts(us.getIdPrestario());

            /*  for (PresDTO obj : res) {
             System.out.println(obj.getIdPrestamo());
             System.out.println(obj.getFechaprestamo());
             System.out.println(obj.getFecharetorno());
             System.out.println(obj.getIdUsuarios());
             System.out.println(obj.getStatusprestamo());
            
             //       dtlPres=obj.getTblDetalleprestamoList();
             System.out.println("detalles del prestamo");
             for (DetailDTO det : dtlPres) {
             System.out.println(det.getNoParte());
             System.out.println(det.getNombre());
             System.out.println(det.getCantidad());
             System.out.println(det.getIdDetalleprestamo());
             System.out.println(det.getFecharetorno());
             System.out.println(det.getHoraretorno());
             }
             }*/
            RequestContext.getCurrentInstance().update("forma:tabView:debts");

        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("error", "no se encontro ningun prestario "));
        }
    }

    public String action() {
        Date dateNow = new Date();


        SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
        String date_to_string = dateformatyyyyMMdd.format(dateNow);
        System.out.println("date into yyyyMMdd format: " + date_to_string);
        return null;
    }
}
