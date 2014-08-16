/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.server.entity.beans.TblPrestamo;
import com.server.entity.beans.TblPrestarios;
import com.server.entity.beans.TblTipoprestarios;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cristian
 */
public class PrestarioDTO implements Serializable{
    
 private Integer idPrestario;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String tel;
    private String email;
    private String usuario;
    private String carrera;
    private List<TblPrestamo> tblPrestamoList;
    private TblTipoprestarios idTipoprestarios;

    
      public TblPrestarios convertDTO() {
             
        TblPrestarios us=new TblPrestarios();
        
        us.setNombre(this.getNombre());
        us.setApaterno(this.getApaterno());
        us.setAmaterno(this.getAmaterno());
        us.setEmail(this.getEmail());
        us.setTel(this.getTel());
        us.setUsuario(this.getUsuario());
        us.setCarrera(this.getCarrera());

             return us;
}
    
    
    
    
    public Integer getIdPrestario() {
        return idPrestario;
    }

    public void setIdPrestario(Integer idPrestario) {
        this.idPrestario = idPrestario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<TblPrestamo> getTblPrestamoList() {
        return tblPrestamoList;
    }

    public void setTblPrestamoList(List<TblPrestamo> tblPrestamoList) {
        this.tblPrestamoList = tblPrestamoList;
    }

    public TblTipoprestarios getIdTipoprestarios() {
        return idTipoprestarios;
    }

    public void setIdTipoprestarios(TblTipoprestarios idTipoprestarios) {
        this.idTipoprestarios = idTipoprestarios;
    }
   
    
    
    
    
}
