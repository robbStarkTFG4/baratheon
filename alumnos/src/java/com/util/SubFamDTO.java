/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.util.interfaces.SubFamilia; 

/**
 *
 * @author NORE
 */
public class SubFamDTO implements  SubFamilia {

    private Integer id;
    private String nombre;
    

    public SubFamDTO() {

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

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public String whatIam() {
        return "subFam";
    }

}
