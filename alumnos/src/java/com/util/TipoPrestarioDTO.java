/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

/**
 *
 * @author NORE
 */
public class TipoPrestarioDTO {

    private Integer idTipoprestarios;
    private String descripcion;

    public TipoPrestarioDTO() {
    }

    public TipoPrestarioDTO(Integer idTipoprestarios, String descripcion) {
        this.idTipoprestarios = idTipoprestarios;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoprestarios() {
        return idTipoprestarios;
    }

    public void setIdTipoprestarios(Integer idTipoprestarios) {
        this.idTipoprestarios = idTipoprestarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
