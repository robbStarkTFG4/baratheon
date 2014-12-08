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
@Table(name = "tbl_rastreo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRastreo.findAll", query = "SELECT t FROM TblRastreo t"),
    @NamedQuery(name = "TblRastreo.findById", query = "SELECT t FROM TblRastreo t WHERE t.id = :id"),
    @NamedQuery(name = "TblRastreo.findByNumSerie", query = "SELECT t FROM TblRastreo t WHERE t.numSerie = :numSerie"),
    @NamedQuery(name = "TblRastreo.findByResponsable", query = "SELECT t FROM TblRastreo t WHERE t.responsable = :responsable"),
    @NamedQuery(name = "TblRastreo.findByFinanciamiento", query = "SELECT t FROM TblRastreo t WHERE t.financiamiento = :financiamiento"),
    @NamedQuery(name = "TblRastreo.findByNumParte", query = "SELECT t FROM TblRastreo t WHERE t.numParte = :numParte"),
    @NamedQuery(name = "TblRastreo.findByEstatus", query = "SELECT t FROM TblRastreo t WHERE t.estatus = :estatus")})
public class TblRastreo implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "idUabc")
    private String idUabc;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "num_serie")
    private String numSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "responsable")
    private String responsable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "financiamiento")
    private String financiamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "numParte")
    private String numParte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private int estatus;

    public TblRastreo() {
    }

    public TblRastreo(Integer id) {
        this.id = id;
    }

    public TblRastreo(Integer id, String numSerie, String responsable, String financiamiento, String numParte, int estatus) {
        this.id = id;
        this.numSerie = numSerie;
        this.responsable = responsable;
        this.financiamiento = financiamiento;
        this.numParte = numParte;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    public String getNumParte() {
        return numParte;
    }

    public void setNumParte(String numParte) {
        this.numParte = numParte;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRastreo)) {
            return false;
        }
        TblRastreo other = (TblRastreo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblRastreo[ id=" + id + " ]";
    }

    public String getIdUabc() {
        return idUabc;
    }

    public void setIdUabc(String idUabc) {
        this.idUabc = idUabc;
    }
    
}
