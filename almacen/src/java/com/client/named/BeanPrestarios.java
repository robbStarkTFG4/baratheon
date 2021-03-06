/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblPrestamoFacade;
import com.server.beans.staless.TblPrestariosFacade;
import com.server.entity.beans.TblPrestarios;
import com.util.PrestarioDTO;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named("prest")
@SessionScoped
public class BeanPrestarios implements Serializable {

    @EJB
    TblPrestariosFacade pres;
    TblPrestamoFacade ptmo;
    @Inject
    BeanUsuarios beanuser;
    List<TblPrestarios> list;
    List<PrestarioDTO> listmoroso;
    TblPrestarios prestmodi;
    String status;
    String nombre;
    String apaterno;
    String amaterno;
    String carrera;
    String correo;
    String tel;
    String us;
    String borrar;
    boolean Hregistros = true;

    public List<PrestarioDTO> getListmoroso() {

        this.listmoroso = pres.Morosos();
        return listmoroso;
    }

    public void validarListener() {

        pres.validar("juani");

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHregistros() {
        return Hregistros;
    }

    public void agregarPrestario() {
        boolean existe;
        UIInput compNombre = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:nom");
        UIInput compCarrera = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:carrera");
        UIInput compApat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:ap");
        UIInput compAmat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:am");
        UIInput compCorreo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:correo");
        UIInput compTel = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:tel");
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:us");
        UIInput compTipo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:tipo");
        UIOutput out = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:indicador");
        System.out.println("ENRTROOO");
        System.out.println(compNombre.getValue().toString() + compCarrera.getValue().toString() + compApat.getValue().toString() + compAmat.getValue().toString() + compCorreo.getValue().toString() + compTel.getValue().toString() + compUsuario.getValue().toString() + compTipo.getValue().toString());

        existe = pres.agregar(compNombre.getValue().toString(), compApat.getValue().toString(), compAmat.getValue().toString(), Integer.parseInt(compTipo.getValue().toString()), compTel.getValue().toString(), compCorreo.getValue().toString(), compUsuario.getValue().toString(), compCarrera.getValue().toString());
        if (existe == true) {

            //status="Usuario o Correo ya utilizados";
            //out.setValue(status);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o correo existente"));

        } else {
            borrar = "";
            beanuser.acciones("Prestario Agregado: " + compUsuario.getValue().toString() + ", " + "Tipo: " + compTipo.getValue().toString(), compUsuario.getValue().toString());
            UIOutput cnombre = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:nom");
            UIOutput capaterno = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:ap");
            UIOutput camaterno = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:am");
            UIOutput ccarrera = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:carrera");
            UIOutput ccorreo = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:correo");
            UIOutput ctel = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:tel");
            UIOutput cus = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:aprestario:us");
            cnombre.setValue(borrar);
            camaterno.setValue(borrar);
            capaterno.setValue(borrar);
            ccarrera.setValue(borrar);
            ccorreo.setValue(borrar);
            ctel.setValue(borrar);
            cus.setValue(borrar);
            status = "";

            out.setValue(status);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Usuario " + compUsuario.getValue().toString() + " agregado con éxito"));
        }
    }

    public void eliminarPrestario(ActionEvent actionEvent) {
        borrar = "";
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarprest:usuariop");

        pres.eliminar(compUsuario.getValue().toString());
        beanuser.acciones("Prestario Eliminado: " + compUsuario.getValue().toString(), compUsuario.getValue().toString());

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Usuario " + compUsuario.getValue().toString() + " eliminado con éxito"));

        UIOutput compU = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarprest:usuariop");
        compU.setValue(borrar);
    }

    public List<String> complete(String query) {

        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:usuariop");
        List<String> listaUs = pres.prestarios(compUsuario.getValue().toString());

        return listaUs;
    }

    public List<String> completeEliminar(String query) {

        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarprest:usuariop");
        System.out.println("ELIMINARR CONS");
        System.out.println(compUsuario.getValue().toString());
        List<String> listaUse = pres.prestarios(compUsuario.getValue().toString());

        return listaUse;
    }

    public void searchUModificar() {
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:usuariop");
        prestmodi = pres.consultamodif(compUsuario.getValue().toString());
        Hregistros = false;
        UIOutput cnombre = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:nom");
        UIOutput capaterno = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:ap");
        UIOutput camaterno = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:am");
        UIOutput ccarrera = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:carrera");
        UIOutput ccorreo = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:correo");
        UIOutput ctel = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:tel");
        UIOutput cus = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:us");
        UIOutput ctip = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:tipo");
        UIOutput cAct = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:act");
        if (prestmodi.getNombre() != null) {
            cnombre.setValue(prestmodi.getNombre());
        }
        if (prestmodi.getAmaterno() != null) {
            camaterno.setValue(prestmodi.getAmaterno());
        }
        if (prestmodi.getApaterno() != null) {
            capaterno.setValue(prestmodi.getApaterno());
        }
        if (prestmodi.getCarrera() != null) {
            ccarrera.setValue(prestmodi.getCarrera());
        }
        if (prestmodi.getEmail() != null) {
            ccorreo.setValue(prestmodi.getEmail());
        }
        if (prestmodi.getTel() != null) {
            ctel.setValue(prestmodi.getTel());
        }
        if (prestmodi.getTel() != null) {
            cus.setValue(prestmodi.getUsuario());
        }
        if (prestmodi.getIdTipoprestarios() != null) {
            ctip.setValue(prestmodi.getIdTipoprestarios().getIdTipoprestarios().toString());
        }
        if (prestmodi.getActivo() != null) {
            cAct.setValue(prestmodi.getActivo());
        }

    }

    public void modificarprestario() {
        boolean existe;
        UIInput compNombre = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:nom");
        UIInput compCarrera = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:carrera");
        UIInput compApat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:ap");
        UIInput compAmat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:am");
        UIInput compCorreo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:correo");
        UIInput compTel = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:tel");
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:us");
        UIInput compTipo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:tipo");
        UIOutput cAct = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:act");
        existe = pres.modificar(prestmodi.getIdPrestario(), compNombre.getValue().toString(), compApat.getValue().toString(),
                compAmat.getValue().toString(), Integer.parseInt(compTipo.getValue().toString()), compTel.getValue().toString(),
                compCorreo.getValue().toString(), compUsuario.getValue().toString(), compCarrera.getValue().toString(), Integer.parseInt(cAct.getValue().toString()));

        System.out.println(existe);
        if (existe == true) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "correo ya utilizado"));

        } else {
            Hregistros = true;
            beanuser.acciones("Prestario Modificado: " + compUsuario.getValue().toString() + ", " + "Tipo: " + compTipo.getValue().toString(), compUsuario.getValue().toString());
            borrar = "";
            UIOutput cnombre = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:nom");
            UIOutput capaterno = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:ap");
            UIOutput camaterno = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:am");
            UIOutput ccarrera = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:carrera");
            UIOutput ccorreo = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:correo");
            UIOutput ctel = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:tel");
            UIOutput cus = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:us");
            UIOutput cuBu = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarPrest:usuariop");
            cnombre.setValue(borrar);
            camaterno.setValue(borrar);
            capaterno.setValue(borrar);
            ccarrera.setValue(borrar);
            ccorreo.setValue(borrar);
            ctel.setValue(borrar);
            cus.setValue(borrar);
            cuBu.setValue(borrar);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Prestatario " + compUsuario.getValue().toString() + " modificado con éxito"));
        }

    }

    public String valorModifInicial() {

        Hregistros = true;

        return "ModificarPrest.xhtml?faces-redirect=true";

    }

}
