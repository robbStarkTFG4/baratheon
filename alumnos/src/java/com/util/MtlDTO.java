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

    private int idMaterial;
    private String noParte;
    private String nombre;
    private int cantidad;
    private int Stock;
    private boolean inventariable = false;

    public MtlDTO() {
    }

    public MtlDTO(int idMaterial, String noParte, String nombre, int cantidad, int Stock) {
        this.idMaterial = idMaterial;
        this.noParte = noParte;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.Stock = Stock;
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

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public boolean isInventariable() {
        return inventariable;
    }

    public void setInventariable(boolean inventariable) {
        this.inventariable = inventariable;
    }
}
