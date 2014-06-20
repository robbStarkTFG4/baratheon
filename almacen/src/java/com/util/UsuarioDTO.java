/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblTipousuarios;
import com.server.entity.beans.TblUsuarios;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cristian
 */
public class UsuarioDTO implements Serializable {
    
   private Integer idUsuarios;
    
    private String nombre;
    
    private String contraseña;
    private String apellidop;
    private String apellidom;
    private String email;
    private TblTipousuarios idTipousuarios;
    private String tel;
    private String usuario;
    private List<TblPrestamo> tblPrestamoList;   
    
     public TblUsuarios convertDTO() {
             
        TblUsuarios us=new TblUsuarios();
        
        us.setNombre(this.getNombre());
        us.setApellidop(this.getApellidop());
        us.setApellidom(this.getApellidom());
        us.setEmail(this.getEmail());
        us.setTel(this.getTel());
        us.setUsuario(this.getUsuario());
        
             
             
             
             return us;
}

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TblTipousuarios getIdTipousuarios() {
        return idTipousuarios;
    }

    public void setIdTipousuarios(TblTipousuarios idTipousuarios) {
        this.idTipousuarios = idTipousuarios;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<TblPrestamo> getTblPrestamoList() {
        return tblPrestamoList;
    }

    public void setTblPrestamoList(List<TblPrestamo> tblPrestamoList) {
        this.tblPrestamoList = tblPrestamoList;
    }
    
}
