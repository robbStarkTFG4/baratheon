/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import ejb.TblusuariosFacade;
import entitys.Tbldepartamento;
import entitys.Tblusuarios;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author cristian
 */
@Named("user")
@SessionScoped

public class UsuariosB implements Serializable {
 @EJB TblusuariosFacade uf;   
 private String usuario;
 private String correo;
 private String cargo;
 private String telefono;
 private String password;
 private Tbldepartamento departamento;
 private Tblusuarios usuarioIN ;
private List<Tblusuarios> userlist;
private boolean ingenieria,compras,inventario,produccion,planeacion,empaque,envios;

    public boolean isIngenieria() {
        return ingenieria;
    }

    public void setIngenieria(boolean ingenieria) {
        this.ingenieria = ingenieria;
    }

    public boolean isCompras() {
        return compras;
    }

    public void setCompras(boolean compras) {
        this.compras = compras;
    }

    public boolean isInventario() {
        return inventario;
    }

    public void setInventario(boolean inventario) {
        this.inventario = inventario;
    }

    public boolean isProduccion() {
        return produccion;
    }

    public void setProduccion(boolean produccion) {
        this.produccion = produccion;
    }

    public boolean isPlaneacion() {
        return planeacion;
    }

    public void setPlaneacion(boolean planeacion) {
        this.planeacion = planeacion;
    }

    public boolean isEmpaque() {
        return empaque;
    }

    public void setEmpaque(boolean empaque) {
        this.empaque = empaque;
    }

    public boolean isEnvios() {
        return envios;
    }

    public void setEnvios(boolean envios) {
        this.envios = envios;
    }


    public List<Tblusuarios> getUserlist() {
        userlist=uf.findAll();
        return userlist;
    }

    public void setUserlist(List<Tblusuarios> userlist) {
        this.userlist = userlist;
    }


    public Tblusuarios getUsuarioIN() {
        return usuarioIN;
    }

    public void setUsuarioIN(Tblusuarios usuarioIN) {
        this.usuarioIN = usuarioIN;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tbldepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Tbldepartamento departamento) {
        this.departamento = departamento;
    }
 
public String  login(){
   
 // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Usuario o contraseña invalido"));
    usuarioIN=uf.logIn(usuario, password);
     
    if(usuarioIN!=null){
    switch(usuarioIN.getTblDepartamento().getIdTblDepartamento()){
        case 1:ingenieria=false;compras=true;inventario=true;produccion=true;planeacion=true;empaque=true;envios=true;
         break;
        case 2:ingenieria=true;compras=false;inventario=true;produccion=true;planeacion=true;empaque=true;envios=true;
         break;
        case 3:ingenieria=true;compras=true;inventario=false;produccion=true;planeacion=true;empaque=true;envios=true;
         break;
        case 4:ingenieria=true;compras=true;inventario=true;produccion=false;planeacion=true;empaque=true;envios=true;
         break;
         case 5:ingenieria=true;compras=true;inventario=true;produccion=true;planeacion=false;empaque=true;envios=true;
         break;
        case 6:ingenieria=true;compras=true;inventario=true;produccion=true;planeacion=true;empaque=false;envios=true;
         break;
        case 7:ingenieria=true;compras=true;inventario=true;produccion=true;planeacion=true;empaque=true;envios=false;
         break;
        case 8:ingenieria=false;compras=false;inventario=false;produccion=false;planeacion=false;empaque=false;envios=false;
         break;
        default:ingenieria=false;compras=false;inventario=false;produccion=false;planeacion=false;empaque=false;envios=false;
            break;
                            
    
    }
    usuario="";
    password="";

    return "/panelD.xhtml?faces-redirect=true";
  
    }
    
    else{
    password="";
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR", "Usuario no existente en el sistema"));
    return null;
    }
 
 } 
public void calcularABC(){









}
 public String logout(){
 
 usuarioIN=null;
 usuario="";
 password="";
 return "/login.xhtml?faces-redirect=true";
 }
    
    
}
