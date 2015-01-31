/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.server.beans.staless.TblDetalleprestamoFacade;
import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblPrestamoFacade;
import com.server.beans.staless.TblPrestariosFacade;
import com.server.beans.staless.TblUsuariosFacade;
import com.server.beans.staless.TblpiezasFacade;
import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblUsuarios;
import com.server.entity.beans.Tblpiezas;
import com.util.DataObject1;
import com.util.DetailDTO;
import com.util.PresDTO;
import java.io.Serializable;
import java.lang.reflect.Type;
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
import javax.inject.Inject;
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

    @EJB
    TblpiezasFacade tblPiezasFacade;

    @Inject
    BeanUsuarios beanUs;

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

    private DetailDTO forInfo;

    private List<DataObject1> listForInfo;

    private DataObject1 newForInfo = new DataObject1();

    private DataObject1 optional;

    private Tblpiezas pzs;

    private List<Tblpiezas> available;

    private boolean dummy = false;
    private int amountOFAllowed;

    public Prestamos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDummy() {
        return dummy;
    }

    public void setDummy(boolean dummy) {
        this.dummy = dummy;
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

    public Tblpiezas getPzs() {
        return pzs;
    }

    public void setPzs(Tblpiezas pzs) {
        this.pzs = pzs;
    }

    public List<Tblpiezas> getAvailable() {
        return available;
    }

    public void setAvailable(List<Tblpiezas> available) {
        this.available = available;
    }

    public void findPres() {
        us = usr.getPres(matricula);
        if (us != null) {
            this.carrera = us.getCarrera();
            this.correo = us.getEmail();
            this.nombre = us.getNombre();
            this.telefono = us.getTel();
            this.activo = us.getActivo();
            //  System.out.println("me llamo: " + us.getEmail());

            listLoans = pr.getLoansByDebts(us.getIdPrestario());

            if (listLoans != null) {
                for (PresDTO dt : listLoans) {
                    /*     System.out.println("Datos Prestamo: ");
                     System.out.println(dt.getIdPrestamo());
                     System.out.println(dt.getFechaprestamo());
                     System.out.println(dt.getHoraprestamo());
                     System.out.println("el estatus" + dt.getStatusprestamo());*/

                    for (DetailDTO dtl : dt.getTblDetalleprestamoList()) {
                        //  System.out.println("Nombre Pieza: " + dtl.getNombre());
                        //  System.out.println("Cantidad: " + dtl.getCantidad());
                    }

                }

                RequestContext.getCurrentInstance().update("forma:tabView:debts");
                RequestContext.getCurrentInstance().update("forma:tabView:freed");

                RequestContext.getCurrentInstance().update("forma:grid:log");
            }

            freeds = pr.getLoansByFreeds(us.getIdPrestario());
            ListSol = pr.getInquerys(us.getIdPrestario());
            RequestContext.getCurrentInstance().update("forma:tabView:soles");

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "No se encontró ningún prestatario "));
            RequestContext.getCurrentInstance().update("forma:notify");
        }
    }

    public String checkDtl() {
        //System.out.println("INFO DEL DETALLE");

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
        //System.out.println("nombre de la pieza: " + currentDtl.getNombre());
        //System.out.println("Fecha retorno: " + currentDtl.getFecharetorno() + ", hora retorno: " + currentDtl.getHoraretorno());
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
        // System.out.println("HORA: " + currentTime);
        //System.out.println("hora: " + System.currentTimeMillis());
        //System.out.println("Current Date: " + stringDate);
        //Date date2 = sdf.parse(stringDate);
        return datos;
    }

    public void resetListener() {
        for (DetailDTO dl : dtls) {
            dl.setActivated(false);
            //  dl.setHoraretorno();
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

    public List<DataObject1> getListForInfo() {
        return listForInfo;
    }

    public void setListForInfo(List<DataObject1> listForInfo) {
        this.listForInfo = listForInfo;
    }

    public DataObject1 getNewForInfo() {
        return newForInfo;
    }

    public void setNewForInfo(DataObject1 newForInfo) {
        this.newForInfo = newForInfo;
    }

    public void savePres() throws ParseException {

        persistInquery();

    }

    private void persistInquery() throws ParseException {
        if (pr.updatePres(currentPres, listLoans, this.getUs())) {

            Gson gson = new Gson();
            // List<DataObject1> list=currentPres.g
            List<DetailDTO> list = currentPres.getTblDetalleprestamoList();
            for (DetailDTO ls : list) {
                if (ls.isInventariable()) {
                    System.out.println("uno va a liberarse");
                    tblPiezasFacade.setUnAvailable(ls.getInfoAdd(), false);

                }
            }

            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Éxito", "Cambios guardados "));
            listLoans = null;
            freeds = null;
            listLoans = pr.getLoansByDebts(us.getIdPrestario());
            freeds = pr.getLoansByFreeds(us.getIdPrestario());
            us = usr.getPres(us.getUsuario());
            dummy = false;
            RequestContext.getCurrentInstance().update("forma:tabView:soles");
            RequestContext.getCurrentInstance().update("forma:tabView:debts");
            RequestContext.getCurrentInstance().update("forma:notify");

        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("ERROR", "Ocurrió un problema "));
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

        if (event.getTab().getTitle().equals("solicitudes")) {
            RequestContext.getCurrentInstance().update("forma:tabView:soles");
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

    public DataObject1 getOptional() {
        return optional;
    }

    public void setOptional(DataObject1 optional) {
        this.optional = optional;
    }

    private void openDialog() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
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

    public DetailDTO getForInfo() {
        return forInfo;
    }

    public void setForInfo(DetailDTO forInfo) {
        this.forInfo = forInfo;
    }

    private void openPartBasicInfo() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
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
        this.ListSol = null;
        this.activo = 9;
        RequestContext.getCurrentInstance().update("forma:tabView:soles");
        RequestContext.getCurrentInstance().update("forma:tabView:freed");
        RequestContext.getCurrentInstance().update("forma:tabView:debts");
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
        //System.out.println("VALOR VIEJO " + valor);
        //System.out.println("VALOR NUEVO " + e.getNewValue());
        // System.out.println("ME LLAMAN , EDGE OF TOMORROW");
    }

    public void saveSelected() throws ParseException {
        int estado = us.getActivo();
        if (!((estado == 0) || (estado == 2))) {
            acceptInquery();
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El Prestario tiene deudas "));
            RequestContext.getCurrentInstance().update("forma:notify");
        }

    }

    private void acceptInquery() throws ParseException {
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

        boolean invi = false;

        for (DetailDTO act : activated) {
            // if (act.isInventariable() != null) {
            if (act.isInventariable()) {
                try {
                    if (act.getInfoAdd() == null || act.getInfoAdd().trim().equals("")) {
                        invi = true;
                    }
                } catch (NullPointerException e) {
                    invi = true;
                }
            }
            // }
        }

        if (!invi) {
            for (DetailDTO ac : activated) {
                if (ac.getInfoAdd() != null) {
                    if (!ac.getInfoAdd().trim().equals("")) {
                        tblPiezasFacade.setUnAvailable(ac.getInfoAdd(), true);
                    }
                }

            }
            persistAcceptedLoan(activated, nonActivated);
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Datos insuficientes"));
            RequestContext.getCurrentInstance().update("forma:notify");
        }
    }

    private void persistAcceptedLoan(List<DetailDTO> activated, List<DetailDTO> nonActivated) throws ParseException {
        if (!activated.isEmpty() && ((currentPres.isDateAdded()))) {

            //for (DetailDTO ac : activated) {
            //    System.out.println(ac);
            //}
            currentPres.getTblDetalleprestamoList().clear();
            currentPres.setTblDetalleprestamoList(null);
            currentPres.setTblDetalleprestamoList(activated);
            dets.deleteDetails(nonActivated);
            pr.updatInquery(currentPres, beanUs.getUsuario(), activated);

            ListSol.remove(currentPres);
            RequestContext.getCurrentInstance().update("forma:tabView:soles");
            //currentPres.setStatusprestamo(1);
            listLoans.clear();
            listLoans = pr.getLoansByDebts(us.getIdPrestario());
            currentPres = null;
            RequestContext.getCurrentInstance().update("forma:tabView:debts");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Datos insuficientes"));

            RequestContext.getCurrentInstance().update("forma:notify");
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

    public void checkBox2(ValueChangeEvent e) {

        // System.out.println("si me llaman desde el checkbox");
        Tblpiezas dl = (Tblpiezas) e.getComponent().getAttributes().get("obj2");
        if (((org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox) e.getComponent()).isSelected()) {
            dl.setEstatus(true);
            //   System.out.println("chekado pz");
        } else {
            dl.setEstatus(false);
            // System.out.println("no chekado pz");
        }

    }

    public void updateDebts() {
        freeds = null;
        ListSol = null;
        freeds = pr.getLoansByFreeds(us.getIdPrestario());
        ListSol = pr.getInquerys(us.getIdPrestario());
        RequestContext.getCurrentInstance().update("forma:tabView:soles");

        listLoans = null;
        listLoans = pr.getLoansByDebts(us.getIdPrestario());
        RequestContext.getCurrentInstance().update("forma:tabView:debts");

    }

    public void dateListener(SelectEvent e) {

        PresDTO temp = (PresDTO) e.getComponent().getAttributes().get("prestamito");

        temp.setDateAdded(true);
    }

    public void infoAction() {

        Gson gson = new Gson();
        // System.out.println("korrasami infoLab");
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("closable", false);
        options.put("resizable", true);
        options.put("contentHeight", 400);
        options.put("contentWidth", 800);

        if (!(forInfo.getInfoAdd() == null || forInfo.getInfoAdd().trim().equals(""))) {
            // OPTIMIZE GUI
            //System.out.println("entre donde no debia porque yolo " + forInfo.getInfoAdd());
            Type type = new TypeToken<List<DataObject1>>() {
            }.getType();
            available = new Gson().fromJson(forInfo.getInfoAdd(), type);
        } else {
            available = new ArrayList<>();
        }

        amountOFAllowed = forInfo.getCantidad();
        //System.out.println("amountOFAllowed: " + amountOFAllowed);
        available = tblPiezasFacade.findItems(forInfo.getNoParte(), false);
        // for (Tblpiezas pzs : available) {
        //    System.out.println("IDS: " + pzs.getIdtblpiezas());
        //}
        RequestContext.getCurrentInstance().openDialog("/dialogo/infoLab", options, null);

    }

    public void addForInfo() {
        //  System.out.println("agregalo");
        //System.out.println(newForInfo.getResponsable());
        // listForInfo.add(new DataObject1(newForInfo.getClave1(), newForInfo.getClave2(), newForInfo.getResponsable(), newForInfo.getComentario(), newForInfo.getNombreObjeto(), newForInfo.getSerie()));
        // newForInfo = null;
        RequestContext.getCurrentInstance().update("infoDialog:infoTable");
        // newForInfo=new DataObject1();
        newForInfo.setClave1("");
        newForInfo.setClave2("");
        newForInfo.setComentario("");
        newForInfo.setNombreObjeto("");
        newForInfo.setResponsable("");
        newForInfo.setSerie("");
        List<String> lista = new ArrayList<String>();
        lista.add("infoDialog:clv1");
        lista.add("infoDialog:clv2");
        lista.add("infoDialog:res");
        lista.add("infoDialog:areaText");
        lista.add("infoDialog:serie");
        lista.add("infoDialog:nombreEquipo");

        RequestContext.getCurrentInstance().update(lista);
    }

    public void addForInfoFinalizar() {
        System.out.println("amountOFAllowed: " + amountOFAllowed);
        int qt = 0;
        List<Tblpiezas> filter = new ArrayList<>();
        for (Tblpiezas el : available) {
            if (el.getEstatus()) {
                filter.add(el);
                qt++;
            }
        }

        if ((qt == amountOFAllowed)) {
            System.out.println("Persist Data");

            List<DataObject1> pers = new ArrayList<>();
            for (Tblpiezas fl : filter) {
                System.out.println("se va a guardar el id: " + fl.getIdtblpiezas());
                DataObject1 obj = new DataObject1(fl.getIdtblpiezas().intValue(), fl.getInventarioUabc(), fl.getClave2(),
                        us.getNombre() + " " + us.getApaterno() + " " + us.getAmaterno(), fl.getComentario(), fl.getNombre(), fl.getSerie());
                pers.add(obj);
            }
            Gson gson = new Gson();

            forInfo.setInfoAdd(gson.toJson(pers));
            System.out.println(forInfo.getInfoAdd());
            RequestContext.getCurrentInstance().closeDialog(null);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Info", "Solo puedes seleccionar " + "cantidad(" + amountOFAllowed + ")"));
            RequestContext.getCurrentInstance().update("infoDialog:infoLabMsgs");
        }
    }

    public void closeAddDialog() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }

    public void quitarAddInfo() {
        System.out.println("wooooow " + optional.getNombreObjeto());
        listForInfo.remove(optional);
        RequestContext.getCurrentInstance().update("infoDialog:infoTable");
    }

    public void updating() {
        ListSol = null;

        ListSol = pr.getInquerys(us.getIdPrestario());
        RequestContext.getCurrentInstance().update("formazad:tabView");
        RequestContext.getCurrentInstance().update(":formazad:tabView:soles");
    }

    public void shoInfoAdd() {

        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 400);
        options.put("contentWidth", 800);

        if (!(forInfo.getInfoAdd() == null || forInfo.getInfoAdd().trim().equals(""))) {
            System.out.println("entre donde no debia porque yolo " + forInfo.getInfoAdd());
            Type type = new TypeToken<List<DataObject1>>() {
            }.getType();
            listForInfo = new Gson().fromJson(forInfo.getInfoAdd(), type);
        } else {
            listForInfo = new ArrayList<>();
        }
        // RequestContext.getCurrentInstance().update("infoDialog:infoTable");
        //System.out.println("lo que tiene: " + forInfo.getInfoAdd());
        RequestContext.getCurrentInstance().openDialog("/dialogo/showInfoAdd", options, null);
    }
}
