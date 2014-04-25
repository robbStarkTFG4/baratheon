/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

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
    
    public DetailDTO(){
        
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
    
}
