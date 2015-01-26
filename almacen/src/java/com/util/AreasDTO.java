/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.util.interfaces.Areas;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NORE
 */
public class AreasDTO implements Areas,Serializable{
    
    private Integer id;
    private String nombre;
    private List<TipoDTO> tipo;
    
    public AreasDTO(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TipoDTO> getTipo() {
        return tipo;
    }

    public void setTipo(List<TipoDTO> tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public String whatIam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
