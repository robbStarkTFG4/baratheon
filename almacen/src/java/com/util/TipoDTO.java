/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.util.interfaces.Tipos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NORE
 */
public class TipoDTO implements Tipos,Serializable {
    
    private int id;
    private String nombre;
    private List<SubFamDTO> fams;
    
    public TipoDTO(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SubFamDTO> getFams() {
        return fams;
    }

    public void setFams(List<SubFamDTO> fams) {
        this.fams = fams;
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
