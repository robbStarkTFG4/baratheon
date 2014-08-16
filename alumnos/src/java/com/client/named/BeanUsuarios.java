/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.named;

import com.server.beans.staless.TblMaterialFacade;
import com.server.beans.staless.TblUsuariosFacade;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblTipousuarios;
import com.server.entity.beans.TblUsuarios;
import com.util.UsuarioDTO;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.PreRenderViewEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Cristian Ramirez
 */
@Named("user")
@SessionScoped
public class BeanUsuarios implements Serializable {

    @EJB
    TblUsuariosFacade us;
    TblMaterialFacade mat;
    TblUsuarios usuario = null, usmodif = null;
    TblTipousuarios tu = null;
    List<UsuarioDTO> listauss;
    List<TblMaterial> listamat;
    String borrar;
    String status;
    String user;
    String tipous;
    boolean habilita, Hregistros = true;

    public TblUsuarios getUsuario() {
        return usuario;
    }

    boolean habilitaModif;
    String nombre;
    String apaterno;
    String amaterno;
    String email;
    String tel;
    String password;

    public List<TblMaterial> getListamat() {
        this.listamat = mat.findAll();
        return listamat;
    }

    public List<UsuarioDTO> getListauss() {
        this.listauss = us.listausuariosSS();
        return listauss;
    }

    public boolean isHabilitaModif() {
        if (usmodif != null) {
            habilitaModif = false;
        } else {
            habilitaModif = true;
        }
        return habilitaModif;
    }

    public boolean isHregistros() {
        return Hregistros;
    }

    public List<String> complete(String query) {

        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:usuariof");
        List<String> listaUs = us.usuarios(compUsuario.getValue().toString());

        return listaUs;
    }

    public List<String> completeEliminar(String query) {

        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarus:usuariof");
        System.out.println("ELIMINARR CONS");
        System.out.println(compUsuario.getValue().toString());
        List<String> listaUse = us.usuarios(compUsuario.getValue().toString());

        return listaUse;
    }

    public void dialogoModificar() {
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:usuariof");
        usmodif = us.consultamodif(compUsuario.getValue().toString());

        if (usmodif != null) {
            Map<String, Object> options = new HashMap<String, Object>();
            options.put("modal", true);
            options.put("draggable", true);
            options.put("resizable", false);
            options.put("contentHeight", 500);
            //hint: available options are modal, draggable, resizable, width, height, contentWidth and contentHeight        
            RequestContext.getCurrentInstance().openDialog("AmodificarUs.xhtml", options, null);

        }

    }

    public void agregarusuario() {
        boolean existe;
        //String nombre,String clave,String apellidop,String apellidom, String tipous, String email, String tel,String usuario){ 
        UIInput compNombre = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:nomus");
        UIInput compClave = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:pass");
        UIInput compApat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:ap");
        UIInput compAmat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:am");
        UIInput compCorreo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:correo");
        UIInput compTel = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:tel");
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:us");
        UIInput compTipo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:tipo");
        //us.agregar("Juan", "juan123", "Perez", "Marquez", "alms", "juanitopema@gamail.com", "9019876", "juanpm");
        UIOutput out = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:indicador");
        System.out.println("ENRTROOO");
        System.out.println(compNombre.getValue().toString() + compClave.getValue().toString() + compApat.getValue().toString() + compAmat.getValue().toString() + compCorreo.getValue().toString() + compTel.getValue().toString() + compUsuario.getValue().toString() + compTipo.getValue().toString());
        existe = us.agregar(compNombre.getValue().toString(), compClave.getValue().toString(), compApat.getValue().toString(), compAmat.getValue().toString(), compTipo.getValue().toString(), compCorreo.getValue().toString(), compTel.getValue().toString(), compUsuario.getValue().toString());
        System.out.println(existe);

        if (existe == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o correo ya utilizados"));
            /*status="Usuario o Correo ya utilizados";
 
             out.setValue(status);
             System.out.println("Usuario o correo usados");
             */
        } else {
            borrar = "";
            UIOutput compN = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:nomus");
            UIOutput compC = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:pass");
            UIOutput compAp = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:ap");
            UIOutput compAm = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:am");
            UIOutput compCo = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:correo");
            UIOutput compT = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:tel");
            UIOutput compU = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:agreus:us");
            compN.setValue(borrar);
            compC.setValue(borrar);
            compAp.setValue(borrar);
            compAm.setValue(borrar);
            compCo.setValue(borrar);
            compT.setValue(borrar);
            compU.setValue(borrar);
            status = "";

            out.setValue(status);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Usuario " + compUsuario.getValue().toString() + " Agregado con exito"));
        }

    }

    /*public void eliminarusuario(){
     UIInput compUsuario= (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarus:usuariof");
     
     us.eliminar(compUsuario.getValue().toString());
 
     }*/
    public void eliminar() {
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarus:usuariof");
        us.eliminar(compUsuario.getValue().toString());

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Usuario " + compUsuario.getValue().toString() + " Eliminado con exito"));

        UIOutput compU = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:eliminarus:usuariof");
        compU.setValue(borrar);

    }

    public String login() {
        String tipo = null;
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("login:usuario");
        UIInput compClave = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("login:clave");
        usuario = us.logIn(compUsuario.getValue().toString(), compClave.getValue().toString());

        UIOutput out = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("status:indicador");
        if (usuario != null) {
            tipo = usuario.getIdTipousuarios().getIdTipousuarios().toString();
        }
        if (usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(usuario.getUsuario(), "usuario autentificado ?++");

            System.out.println(tipo);

            return "index.xhtml?faces-redirect=true";
        } else {
            System.out.println("USUARIOS NO VALIDOS");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o contraseña invalido"));
            UIOutput compU = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("login:usuario");
            UIOutput compC = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("login:clave");

            compU.setValue("");
            compC.setValue("");
            return null;

        }

    }

    //http://www.java-tutorial.ch/java-server-faces/logout-in-jsf-application
    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext obj = FacesContext.getCurrentInstance();
        ExternalContext xcon = obj.getExternalContext();
        String url2 = xcon.encodeActionURL(obj.getApplication().getViewHandler().getActionURL(obj, "/faces/logIn.xhtml"));
        try {
            usuario = null;
            xcon.redirect(url2);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
//return "/faces/logIn.xhtml?faces-redirect=true";
    }

    public void idleListener() {
        //  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
        //        "Sesion cerrada", "Has estado oculto durante los ultimos 5 segundos"));

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        // return "faces/logIn.xhtml?faces-redirect=true";

        FacesContext ctx = FacesContext.getCurrentInstance();

        ExternalContext extContext = ctx.getExternalContext();
        String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "/logIn.xhtml"));

        try {
            usuario = null;
            extContext.redirect(url);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
//"faces/uicomposition/logIn.xhtml?faces-redirect=true");
        //return "/uicomposition/logIn.xhtml?faces-redirect=true";
        //invalidate session
    }

    public void ocultListener() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Parece que estas ausente", "Tu sesion se cerrara automaticamente en 2 minutos"));
    }

    public void activeListener() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Bienvenido de vuelta", "Fue un largo descanzo "));
    }

    public void redirectA() {
        FacesContext ob = FacesContext.getCurrentInstance();
        ExternalContext extcon = ob.getExternalContext();
        String url3 = extcon.encodeActionURL(ob.getApplication().getViewHandler().getActionURL(ob, "/faces/Admin.xhtml"));
        try {

            extcon.redirect(url3);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
    }

    public void verificar(ComponentSystemEvent e) {

        System.out.println("entro");
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();
        String valor = null;

        try {
            valor = (String) fc.getSessionMap().get(usuario.getUsuario());
        } catch (NullPointerException c) {
        }
        System.out.print("Dato:" + valor);

        if (valor == null) {
            try {

                fc.redirect("index");

            } catch (IOException ex) {
                // Logger.getLogger(redireccion.class.getName()).log(Level.SEVERE,null,ex);

            }
        }

    }

    public String tipo() {
        tipous = String.valueOf(usuario.getIdTipousuarios().getIdTipousuarios());

        return tipous;

    }

    public boolean isHabilita() {
        tipous = String.valueOf(usuario.getIdTipousuarios().getIdTipousuarios());
        if (tipous.equals("admin")) {
            return habilita = false;

        } else {

            return habilita = true;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void mostraslist() {

//us.usuarios();
    }

    public void searchUModificar() {
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:usuariof");
        usmodif = us.consultamodif(compUsuario.getValue().toString());
        Hregistros = false;
        UIOutput compN = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:nomus");
        UIOutput compC = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:pass");
        UIOutput compAp = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:ap");
        UIOutput compAm = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:am");
        UIOutput compCo = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:correo");
        UIOutput compT = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:tel");
        UIOutput compU = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:us");
        UIOutput compTip = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:tipo");
        compN.setValue(usmodif.getNombre());
        compC.setValue(usmodif.getContraseña());
        compAp.setValue(usmodif.getApellidop());
        compAm.setValue(usmodif.getApellidom());
        compCo.setValue(usmodif.getEmail());
        compT.setValue(usmodif.getTel());
        compU.setValue(usmodif.getUsuario());
        compTip.setValue(usmodif.getIdTipousuarios().getIdTipousuarios().toString());
    }

    public void modificarusuario() {

        boolean exist;

        UIInput compNombre = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:nomus");
        UIInput compClave = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:pass");
        UIInput compApat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:ap");
        UIInput compAmat = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:am");
        UIInput compCorreo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:correo");
        UIInput compTel = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:tel");
        UIInput compUsuario = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:us");
        UIInput compTipo = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:tipo");

        exist = us.modificar(usmodif.getIdUsuarios(), compNombre.getValue().toString(), compClave.getValue().toString(), compApat.getValue().toString(), compAmat.getValue().toString(), compTipo.getValue().toString(), compCorreo.getValue().toString(), compTel.getValue().toString(), compUsuario.getValue().toString());
        System.out.println(exist);

        if (exist == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "correo ya utilizado"));

            System.out.println("Usuario o correo usados");

        } else {
            Hregistros = true;
            borrar = "";

            UIOutput compN = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:nomus");
            UIOutput compC = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:pass");
            UIOutput compAp = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:ap");
            UIOutput compAm = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:am");
            UIOutput compCo = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:correo");
            UIOutput compT = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:tel");
            UIOutput compU = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:us");
            UIOutput compBu = (UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("admin:modificarUs:usuariof");
            compN.setValue(borrar);
            compC.setValue(borrar);
            compAp.setValue(borrar);
            compAm.setValue(borrar);
            compCo.setValue(borrar);
            compT.setValue(borrar);
            compU.setValue(borrar);
            compBu.setValue(borrar);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Usuario " + compUsuario.getValue().toString() + " Modificado con exito"));
        }

        System.out.println(compNombre.getValue().toString() + compClave.getValue().toString() + compApat.getValue().toString() + compAmat.getValue().toString() + compCorreo.getValue().toString() + compTel.getValue().toString() + compUsuario.getValue().toString() + compTipo.getValue().toString());

    }

    public String valorModifInicial() {

        Hregistros = true;

        return "ModificarUs.xhtml?faces-redirect=true";

    }

    
}
