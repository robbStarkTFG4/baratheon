/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.entity.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "tbl_detalleprestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleprestamo.findAll", query = "SELECT t FROM TblDetalleprestamo t"),
    @NamedQuery(name = "TblDetalleprestamo.findByIdDetalleprestamo", query = "SELECT t FROM TblDetalleprestamo t WHERE t.idDetalleprestamo = :idDetalleprestamo"),
    @NamedQuery(name = "TblDetalleprestamo.findByCantidad", query = "SELECT t FROM TblDetalleprestamo t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TblDetalleprestamo.findByFecharetorno", query = "SELECT t FROM TblDetalleprestamo t WHERE t.fecharetorno = :fecharetorno"),
    @NamedQuery(name = "TblDetalleprestamo.findByHoraretorno", query = "SELECT t FROM TblDetalleprestamo t WHERE t.horaretorno = :horaretorno"),
    @NamedQuery(name = "TblDetalleprestamo.findByRegresados", query = "SELECT t FROM TblDetalleprestamo t WHERE t.regresados = :regresados")})
public class TblDetalleprestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalleprestamo")
    private Integer idDetalleprestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 10)
    @Column(name = "fecharetorno")
    private String fecharetorno;
    @Size(max = 6)
    @Column(name = "horaretorno")
    private String horaretorno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regresados")
    private int regresados;
    @JoinColumn(name = "id_material", referencedColumnName = "idtbl_material")
    @ManyToOne(optional = false)
    private TblMaterial idMaterial;
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    @ManyToOne(optional = false)
    private TblPrestamo idPrestamo;

    public TblDetalleprestamo() {
    }

    public TblDetalleprestamo(Integer idDetalleprestamo) {
        this.idDetalleprestamo = idDetalleprestamo;
    }

    public TblDetalleprestamo(Integer idDetalleprestamo, int cantidad, int regresados) {
        this.idDetalleprestamo = idDetalleprestamo;
        this.cantidad = cantidad;
        this.regresados = regresados;
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

    public int getRegresados() {
        return regresados;
    }

    public void setRegresados(int regresados) {
        this.regresados = regresados;
    }

    public TblMaterial getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(TblMaterial idMaterial) {
        this.idMaterial = idMaterial;
    }

    public TblPrestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(TblPrestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleprestamo != null ? idDetalleprestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleprestamo)) {
            return false;
        }
        TblDetalleprestamo other = (TblDetalleprestamo) object;
        if ((this.idDetalleprestamo == null && other.idDetalleprestamo != null) || (this.idDetalleprestamo != null && !this.idDetalleprestamo.equals(other.idDetalleprestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblDetalleprestamo[ idDetalleprestamo=" + idDetalleprestamo + " ]";
    }
    
}
