/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NORE
 */
public class PresDTO implements Serializable {

    //SELECT c.idPrestamo, c.fechaprestamo, c.horaprestamo, c.idUsuarios.usuario, c.statusprestamo
    private Integer idPrestamo;
    private String fechaprestamo;
    private String fecharetorno;
    private String horaprestamo;
    private String idUsuarios;
    private int statusprestamo;
    private List<DetailDTO> tblDetalleprestamoList;

    public PresDTO() {
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFecharetorno() {
        return fecharetorno;
    }

    public void setFecharetorno(String fecharetorno) {
        this.fecharetorno = fecharetorno;
    }

    public int getStatusprestamo() {
        return statusprestamo;
    }

    public void setStatusprestamo(int statusprestamo) {
        this.statusprestamo = statusprestamo;
    }

    public String getHoraprestamo() {
        return horaprestamo;
    }

    public void setHoraprestamo(String horaprestamo) {
        this.horaprestamo = horaprestamo;
    }

    public List<DetailDTO> getTblDetalleprestamoList() {
        return tblDetalleprestamoList;
    }

    public void setTblDetalleprestamoList(List<DetailDTO> tblDetalleprestamoList) {
        this.tblDetalleprestamoList = tblDetalleprestamoList;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

}
