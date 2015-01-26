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
@Table(name = "tbl_pendientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPendientes.findAll", query = "SELECT t FROM TblPendientes t"),
    @NamedQuery(name = "TblPendientes.findByIdTblPendientes", query = "SELECT t FROM TblPendientes t WHERE t.idTblPendientes = :idTblPendientes"),
    @NamedQuery(name = "TblPendientes.findByObjeto", query = "SELECT t FROM TblPendientes t WHERE t.objeto = :objeto"),
    @NamedQuery(name = "TblPendientes.findByRazon", query = "SELECT t FROM TblPendientes t WHERE t.razon = :razon"),
    @NamedQuery(name = "TblPendientes.findByConcepto", query = "SELECT t FROM TblPendientes t WHERE t.concepto = :concepto"),
    @NamedQuery(name = "TblPendientes.findByComentario", query = "SELECT t FROM TblPendientes t WHERE t.comentario = :comentario")})
public class TblPendientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTbl_Pendientes")
    private Integer idTblPendientes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "objeto")
    private String objeto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "razon")
    private String razon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 120)
    @Column(name = "comentario")
    private String comentario;

    public TblPendientes() {
    }

    public TblPendientes(Integer idTblPendientes) {
        this.idTblPendientes = idTblPendientes;
    }

    public TblPendientes(Integer idTblPendientes, String objeto, String razon, String concepto) {
        this.idTblPendientes = idTblPendientes;
        this.objeto = objeto;
        this.razon = razon;
        this.concepto = concepto;
    }

    public TblPendientes(String objeto, String razon, String concepto) {
        this.objeto = objeto;
        this.razon = razon;
        this.concepto = concepto;
    }

    public Integer getIdTblPendientes() {
        return idTblPendientes;
    }

    public void setIdTblPendientes(Integer idTblPendientes) {
        this.idTblPendientes = idTblPendientes;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblPendientes != null ? idTblPendientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPendientes)) {
            return false;
        }
        TblPendientes other = (TblPendientes) object;
        if ((this.idTblPendientes == null && other.idTblPendientes != null) || (this.idTblPendientes != null && !this.idTblPendientes.equals(other.idTblPendientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblPendientes[ idTblPendientes=" + idTblPendientes + " ]";
    }
    
}
