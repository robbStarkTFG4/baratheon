/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblPrestamoFacade;
import com.server.beans.staless.TblPrestariosFacade;
import com.server.beans.staless.TblUsuariosFacade;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblUsuarios;
import com.util.DetailDTO;
import com.util.PresDTO;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author NORE
 */
@Named("pres")
@SessionScoped
public class Prestamos implements Serializable { //clase para manejar los prestamos
    // clase para ver historial de prestamos y deudas actualesdsfsd

    @EJB
    TblPrestariosFacade usr;

    @EJB
    TblPrestamoFacade pr;

    @EJB
    TblUsuariosFacade usrFacade;

    @EJB
    TblMaterialFacade mtl;

    private String nombre;
    private String correo;
    private String carrera;
    private String telefono;
    private String matricula;
    private TblPrestarios us;

    private List<PresDTO> listLoans;

    private List<PresDTO> freeds;

    private DetailDTO currentDtl;

    private DetailDTO showInfo;

    private List<DetailDTO> dtls;

    private PresDTO currentPres;

    private String idUsuario;

    private TblUsuarios usuario;

    private TblMaterial currentView;

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

    public List<PresDTO> getListLoans() {
        return listLoans;
    }

    public void setListLoans(List<PresDTO> listLoans) {
        this.listLoans = listLoans;
    }

    public DetailDTO getCurrentDtl() {
        return currentDtl;
    }

    public void setCurrentDtl(DetailDTO currentDtl) {
        this.currentDtl = currentDtl;
    }

    public void updateDebts() {
        listLoans=null;
        listLoans = pr.getLoansByDebts(us.getIdPrestario());
        RequestContext.getCurrentInstance().update("forma:tabView:debts");
    }

    public void findPres() {
        us = usr.getPres(matricula);
        if (us != null) {
            this.carrera = us.getCarrera();
            this.correo = us.getEmail();
            this.nombre = us.getNombre();
            this.telefono = us.getTel();
            System.out.println("me llamo: " + us.getEmail());

            listLoans = pr.getLoansByDebts(us.getIdPrestario());

            if (listLoans != null) {
                for (PresDTO dt : listLoans) {
                    System.out.println("Datos Prestamo: ");
                    System.out.println(dt.getIdPrestamo());
                    System.out.println(dt.getFechaprestamo());
                    System.out.println(dt.getHoraprestamo());
                    System.out.println("el estatus" + dt.getStatusprestamo());

                    for (DetailDTO dtl : dt.getTblDetalleprestamoList()) {
                        System.out.println("Nombre Pieza: " + dtl.getNombre());
                        System.out.println("Cantidad: " + dtl.getCantidad());
                    }

                }

                RequestContext.getCurrentInstance().update("forma:tabView:debts");
                RequestContext.getCurrentInstance().update("forma:grid:log");
            }

            freeds = pr.getLoansByFreeds(us.getIdPrestario());

        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("error", "no se encontro ningun prestario "));
            RequestContext.getCurrentInstance().update("forma:notify");
        }
    }

    public String checkDtl() {
        System.out.println("INFO DEL DETALLE");

        String[] date = currentDate();
        if (currentDtl.getFecharetorno() != null) {
            if (currentDtl.getFecharetorno().equals("")) {
                currentDtl.setFecharetorno(date[0]);
                currentDtl.setHoraretorno(date[1]);
            } else {
                currentDtl.setFecharetorno("");
                currentDtl.setHoraretorno("");
            }
        } else {
            currentDtl.setFecharetorno(date[0]);
            currentDtl.setHoraretorno(date[1]);
        }
        System.out.println("nombre de la pieza: " + currentDtl.getNombre());
        System.out.println("fecha retorno: " + currentDtl.getFecharetorno() + "  hora retorno: " + currentDtl.getHoraretorno());

        return null;
    }

    public void onRowToggle(ToggleEvent event) {//fdsfsd
        System.out.println(event.getComponent().getClientId());
    }

    public void listenPartNumber() {
        System.out.println(this.showInfo.getNoParte()); // DETALLE
        if (currentView != null) {
            if (currentView.getNoParte().equals(this.showInfo.getNoParte())) {
                openPartBasicInfo();
                return;
            }

        }
        currentView = null;

        currentView = mtl.getBasicInfo(this.showInfo.getNoParte());
        if (currentView != null) {
            openPartBasicInfo();
        }
    }

    public String[] currentDate() {
        String[] datos = new String[2];

        String DATE_FORMAT_NOW = "yyyy/MM/dd";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String stringDate = sdf.format(date);
        datos[0] = stringDate;
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date 
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        //calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);

        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String currentTime = hora.format(date.getTime());
        datos[1] = currentTime;
        System.out.println("HORA: " + currentTime);
        System.out.println("hora: " + System.currentTimeMillis());
        System.out.println("Current Date: " + stringDate);
        //Date date2 = sdf.parse(stringDate);
        return datos;
    }

    public void resetListener() {
        for (DetailDTO dl : dtls) {
            dl.setFecharetorno("");
            dl.setHoraretorno("");
        }
    }

    public void setDtls(List<DetailDTO> dtls) {
        this.dtls = dtls;
    }

    public List<DetailDTO> getDtls() {
        return dtls;
    }

    public PresDTO getCurrentPres() {
        return currentPres;
    }

    public void setCurrentPres(PresDTO currentPres) {
        this.currentPres = currentPres;
    }

    public void savePres() {

        if (pr.updatePres(currentPres, listLoans)) {
            
            updateDebts();
            FacesContext context = FacesContext.getCurrentInstance();
   
            context.addMessage(null, new FacesMessage("exito", "cambios guardados "));
            RequestContext.getCurrentInstance().update("forma:tabView:debts");
            RequestContext.getCurrentInstance().update("forma:notify");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("error", "hubo alguna falla "));
            RequestContext.getCurrentInstance().update("forma:notify");
        }
    }

    public List<PresDTO> getFreeds() {
        return freeds;
    }

    public void setFreeds(List<PresDTO> freeds) {
        this.freeds = freeds;
    }

    public void onTabChange(TabChangeEvent event) {
        if (event.getTab().getTitle().equals("liberados")) {
            RequestContext.getCurrentInstance().update("forma:tabView:freed");
        }

        if (event.getTab().getTitle().equals("adeudos")) {
            RequestContext.getCurrentInstance().update("forma:tabView:debts");
        }
    }

    public void showUser() { // action para mostrar dialogo con informacion del usuario
        System.out.println("el id del usuario es: " + this.idUsuario);

        if (usuario != null) {
            if (usuario.getUsuario().equals(this.idUsuario)) {
                openDialog();
                return;
            }
        }
        usuario = null;

        usuario = usrFacade.findBasicInfo(this.idUsuario);
        if (usuario != null) {
            openDialog();
        }
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TblUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(TblUsuarios usuario) {
        this.usuario = usuario;
    }

    private void openDialog() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 300);

        RequestContext.getCurrentInstance().openDialog("/dialogo/UserBasicInfo", options, null);
    }

    public void setShowInfo(DetailDTO showInfo) {
        this.showInfo = showInfo;
    }

    public DetailDTO getShowInfo() {
        return showInfo;
    }

    public TblMaterial getCurrentView() {
        return currentView;
    }

    public void setCurrentView(TblMaterial currentView) {
        this.currentView = currentView;
    }

    private void openPartBasicInfo() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 300);

        RequestContext.getCurrentInstance().openDialog("/dialogo/PartBasicInfo", options, null);
    }

    public void logOut() {
        /* private String nombre;
         private String correo;
         private String carrera;
         private String telefono;
         private String matricula;
         private TblPrestarios us;

         private List<PresDTO> listLoans;

         private List<PresDTO> freeds;*/

        this.nombre = null;
        this.correo = null;
        this.carrera = null;
        this.telefono = null;
        this.matricula = null;
        this.us = null;
        this.listLoans = null;
        this.freeds = null;
        RequestContext.getCurrentInstance().update("forma:tabView:freed");
        RequestContext.getCurrentInstance().update("forma:tabView:debts");
    }
}
