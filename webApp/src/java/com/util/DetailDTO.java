/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.server.entity.beans.TblDetalleprestamo;
import com.server.entity.beans.TblMaterial;
import com.server.entity.beans.TblPrestamo;
import java.io.Serializable;

/**
 *
 * @author NORE
 */
public class DetailDTO implements Serializable{
   //                                   x        x                  x                 x  
    //SELECT k.noParte, k.nombre , c.cantidad,c.fecharetorno, c.horaretorno , c.idDetalleprestamo 
    
    private Integer idDetalleprestamo;
    private int cantidad;
   
    private String fecharetorno;
  
    private String horaretorno;
    
    private String noParte;
   
    private String nombre;
    
    private int idMaterial=0;
    
    private int idPres=0;
    
    public DetailDTO(){
        
    }

    public TblDetalleprestamo convertDTO(){
        TblDetalleprestamo dtl=new TblDetalleprestamo();
        dtl.setIdDetalleprestamo(this.getIdDetalleprestamo());
        dtl.setCantidad(this.getCantidad());
        dtl.setFecharetorno(this.getFecharetorno());
        dtl.setHoraretorno(this.getHoraretorno());
        dtl.setIdMaterial(new  TblMaterial(this.getIdMaterial()));
        dtl.setIdPrestamo(new TblPrestamo(this.getIdPres()));
        
        return dtl;
    }
    public Integer getIdDetalleprestamo() {
        return idDetalleprestamo;
    }

    public void setIdDetalleprestamo(Integer idDetalleprestamo) {
        this.idDetalleprestamo = idDetalleprestamo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecharetorno() {
        return fecharetorno;
    }

    public void setFecharetorno(String fecharetorno) {
        this.fecharetorno = fecharetorno;
    }

    public String getHoraretorno() {
        return horaretorno;
    }

    public void setHoraretorno(String horaretorno) {
        this.horaretorno = horaretorno;
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdPres() {
        return idPres;
    }

    public void setIdPres(int idPres) {
        this.idPres = idPres;
    }
    
}
