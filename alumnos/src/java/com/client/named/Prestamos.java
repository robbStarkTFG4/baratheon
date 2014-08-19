/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblDetalleprestamoFacade;
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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
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

    @EJB
    TblDetalleprestamoFacade dets;

    private String nombre;
    private String correo;
    private String carrera;
    private String telefono;
    private String matricula;
    private TblPrestarios us;

    private List<PresDTO> listLoans;

    private List<PresDTO> freeds;

    private List<PresDTO> ListSol;

    private DetailDTO currentDtl;

    private DetailDTO showInfo;

    private List<DetailDTO> dtls;

    private PresDTO currentPres;

    private String idUsuario;

    private TblUsuarios usuario;

    private TblMaterial currentView;

    private List<DetailDTO> solicitudes;

    private int activo;

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

    public List<PresDTO> getListSol() {
        return ListSol;
    }

    public List<DetailDTO> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<DetailDTO> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void findPres() {
        us=null;
        us = usr.getPres(matricula);
        if (us != null) {
            this.carrera = us.getCarrera();
            this.correo = us.getEmail();
            this.nombre = us.getNombre();
            this.telefono = us.getTel();
            this.activo = us.getActivo();
            System.out.println("EL PRESTARIO INT ACTIVO ES : " + us.getActivo());

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

                RequestContext.getCurrentInstance().update("formazad:tabView:debts");
                RequestContext.getCurrentInstance().update("formazad:grid:log");
            }

            freeds = pr.getLoansByFreeds(us.getIdPrestario());
            ListSol = pr.getInquerys(us.getIdPrestario());
            RequestContext.getCurrentInstance().update("formazad:tabView:soles");

        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("error", "no se encontro ningun prestario "));
            RequestContext.getCurrentInstance().update("formazad:notify");
        }
    }

    public String checkDtl() {
        System.out.println("INFO DEL DETALLE");

        String[] date = currentDate();

        if (currentDtl.getRegresados() != 0) {
            if (currentDtl.getFecharetorno() == null || currentDtl.getFecharetorno().trim().equals("")) {
                currentDtl.setFecharetorno(date[0]);
                currentDtl.setHoraretorno(date[1]);
            }
        } else {
            currentDtl.setFecharetorno("");
            currentDtl.setHoraretorno("");
        }

        /* if (currentDtl.getFecharetorno() != null) {
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
         }*/
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public void savePres() throws ParseException {

        if (pr.updatePres(currentPres, listLoans)) {

            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("exito", "cambios guardados "));
            listLoans = null;
            freeds = null;
            listLoans = pr.getLoansByDebts(us.getIdPrestario());
            freeds = pr.getLoansByFreeds(us.getIdPrestario());
            RequestContext.getCurrentInstance().update("formazad:tabView:debts");
            RequestContext.getCurrentInstance().update("formazad:notify");

        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("error", "hubo alguna falla "));
            RequestContext.getCurrentInstance().update("formazad:notify");
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
            RequestContext.getCurrentInstance().update("formazad:tabView:freed");
        }

        if (event.getTab().getTitle().equals("adeudos")) {
            RequestContext.getCurrentInstance().update("formazad:tabView:debts");
        }

        if (event.getTab().getTitle().equals("solicitudes")) {
            RequestContext.getCurrentInstance().update("formazad:tabView:soles");
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

    public String logOut() {
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
        this.ListSol = null;
        RequestContext.getCurrentInstance().update("formazad:tabView:soles");
        RequestContext.getCurrentInstance().update("formazad:tabView:freed");
        RequestContext.getCurrentInstance().update("formazad:tabView:debts");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent event) {
        System.out.println("YAAAAAAA MODIFIQUEEEEEEEEEEEE");

        currentDtl = (DetailDTO) event.getObject();
        System.out.println(currentDtl.getNombre());

        checkDtl();

    }

    public void onRowCancel(RowEditEvent event) {
        // FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void cantidadListener(ValueChangeEvent e) {//423423
        //   System.out.println("VALOR VIEJO "+);
        int valor = (int) e.getComponent().getAttributes().get("valor");
        System.out.println("VALOR VIEJO " + valor);
        System.out.println("VALOR NUEVO " + e.getNewValue());
        System.out.println("ME LLAMAN , EDGE OF TOMORROW");
    }

    public void saveSelected() throws ParseException {

        // currentPres.getTblDetalleprestamoList().clear();
        //currentPres.setTblDetalleprestamoList(dtls);
        List<DetailDTO> activated = new ArrayList<>();
        List<DetailDTO> nonActivated = new ArrayList<>();

        for (DetailDTO dl : currentPres.getTblDetalleprestamoList()) {

            if (!dl.isActivated()) {
                nonActivated.add(dl);
            } else {
                activated.add(dl);
            }
        };

        if (!activated.isEmpty() && ((currentPres.isDateAdded()))) {
            currentPres.getTblDetalleprestamoList().clear();
            currentPres.setTblDetalleprestamoList(null);
            currentPres.setTblDetalleprestamoList(activated);

            pr.updatInquery(currentPres);
            dets.deleteDetails(nonActivated);
            ListSol.remove(currentPres);
            RequestContext.getCurrentInstance().update("formazad:tabView:soles");
            currentPres.setStatusprestamo(1);
            listLoans.clear();
            listLoans = pr.getLoansByDebts(us.getIdPrestario());
            RequestContext.getCurrentInstance().update("formazad:tabView:debts");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "error", "proporciona los datos nesecesarios"));

            RequestContext.getCurrentInstance().update("formazad:notify");
        }
    }

    public void checkBox(ValueChangeEvent e) {
        System.out.println("si me llaman desde el checkbox");
        DetailDTO dl = (DetailDTO) e.getComponent().getAttributes().get("obj");
        if (((org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox) e.getComponent()).isSelected()) {
            dl.setActivated(true);
            System.out.println("chekado");
        } else {
            dl.setActivated(false);
            System.out.println("no chekado");
        }

    }

    public void updateDebts() {
        freeds = null;
        ListSol = null;
        freeds = pr.getLoansByFreeds(us.getIdPrestario());
        ListSol = pr.getInquerys(us.getIdPrestario());
        RequestContext.getCurrentInstance().update("formazad:tabView");
        RequestContext.getCurrentInstance().update("formazad:tabView:soles");

        listLoans = null;
        listLoans = pr.getLoansByDebts(us.getIdPrestario());
        RequestContext.getCurrentInstance().update("formazad:tabView:debts");

    }

    public void dateListener(SelectEvent e) {

        PresDTO temp = (PresDTO) e.getComponent().getAttributes().get("prestamito");

        temp.setDateAdded(true);
    }
}
