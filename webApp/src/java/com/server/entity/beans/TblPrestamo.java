/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.entity.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "tbl_prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPrestamo.findAll", query = "SELECT t FROM TblPrestamo t"),
    @NamedQuery(name = "TblPrestamo.findByIdPrestamo", query = "SELECT t FROM TblPrestamo t WHERE t.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "TblPrestamo.findByFechaprestamo", query = "SELECT t FROM TblPrestamo t WHERE t.fechaprestamo = :fechaprestamo"),
    @NamedQuery(name = "TblPrestamo.findByFecharetorno", query = "SELECT t FROM TblPrestamo t WHERE t.fecharetorno = :fecharetorno"),
    @NamedQuery(name = "TblPrestamo.findByStatusprestamo", query = "SELECT t FROM TblPrestamo t WHERE t.statusprestamo = :statusprestamo"),
    @NamedQuery(name = "TblPrestamo.findByHoraprestamo", query = "SELECT t FROM TblPrestamo t WHERE t.horaprestamo = :horaprestamo")})
public class TblPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fechaprestamo")
    private String fechaprestamo;
    @Size(max = 10)
    @Column(name = "fecharetorno")
    private String fecharetorno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statusprestamo")
    private int statusprestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "horaprestamo")
    private String horaprestamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrestamo")
    private List<TblDetalleprestamo> tblDetalleprestamoList;
    @JoinColumn(name = "id_prestario", referencedColumnName = "id_prestario")
    @ManyToOne(optional = false)
    private TblPrestarios idPrestario;
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id_usuarios")
    @ManyToOne(optional = false)
    private TblUsuarios idUsuarios;

    public TblPrestamo() {
    }

    public TblPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public TblPrestamo(Integer idPrestamo, String fechaprestamo, int statusprestamo, String horaprestamo) {
        this.idPrestamo = idPrestamo;
        this.fechaprestamo = fechaprestamo;
        this.statusprestamo = statusprestamo;
        this.horaprestamo = horaprestamo;
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

    @XmlTransient
    public List<TblDetalleprestamo> getTblDetalleprestamoList() {
        return tblDetalleprestamoList;
    }

    public void setTblDetalleprestamoList(List<TblDetalleprestamo> tblDetalleprestamoList) {
        this.tblDetalleprestamoList = tblDetalleprestamoList;
    }

    public TblPrestarios getIdPrestario() {
        return idPrestario;
    }

    public void setIdPrestario(TblPrestarios idPrestario) {
        this.idPrestario = idPrestario;
    }

    public TblUsuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(TblUsuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPrestamo)) {
            return false;
        }
        TblPrestamo other = (TblPrestamo) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblPrestamo[ idPrestamo=" + idPrestamo + " ]";
    }
    
}
