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
public class MtlDTO implements Serializable {

    private String noParte;
    private String nombre;
    private int cantidad;
    private int Stock;
    
    public MtlDTO() {
    }

    public MtlDTO(String noParte, String nombre, int cantidad,int Stock) {
        this.noParte = noParte;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.Stock=Stock;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

}
