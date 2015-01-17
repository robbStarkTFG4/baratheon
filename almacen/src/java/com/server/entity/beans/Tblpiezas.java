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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "tblpiezas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblpiezas.findAll", query = "SELECT t FROM Tblpiezas t"),
    @NamedQuery(name = "Tblpiezas.findByTblPiezasid", query = "SELECT t FROM Tblpiezas t WHERE t.tblPiezasid = :tblPiezasid"),
    @NamedQuery(name = "Tblpiezas.findBySerie", query = "SELECT t FROM Tblpiezas t WHERE t.serie = :serie"),
    @NamedQuery(name = "Tblpiezas.findByInventarioUabc", query = "SELECT t FROM Tblpiezas t WHERE t.inventarioUabc = :inventarioUabc"),
    @NamedQuery(name = "Tblpiezas.findByClave2", query = "SELECT t FROM Tblpiezas t WHERE t.clave2 = :clave2"),
    @NamedQuery(name = "Tblpiezas.findByPartemodelo", query = "SELECT t FROM Tblpiezas t WHERE t.partemodelo = :partemodelo"),
    @NamedQuery(name = "Tblpiezas.findByNombre", query = "SELECT t FROM Tblpiezas t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblpiezas.findByComentario", query = "SELECT t FROM Tblpiezas t WHERE t.comentario = :comentario"),
    @NamedQuery(name = "Tblpiezas.findByEstatus", query = "SELECT t FROM Tblpiezas t WHERE t.estatus = :estatus")})
public class Tblpiezas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TblPiezas_id")
    private Integer tblPiezasid;
    @Size(max = 100)
    @Column(name = "serie")
    private String serie;
    @Size(max = 100)
    @Column(name = "inventario_uabc")
    private String inventarioUabc;
    @Size(max = 100)
    @Column(name = "clave2")
    private String clave2;
    @Size(max = 50)
    @Column(name = "#Parte_modelo")
    private String partemodelo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "estatus")
    private Boolean estatus;

    public Tblpiezas() {
    }

    public Tblpiezas(Integer tblPiezasid) {
        this.tblPiezasid = tblPiezasid;
    }

    public Integer getTblPiezasid() {
        return tblPiezasid;
    }

    public void setTblPiezasid(Integer tblPiezasid) {
        this.tblPiezasid = tblPiezasid;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getInventarioUabc() {
        return inventarioUabc;
    }

    public void setInventarioUabc(String inventarioUabc) {
        this.inventarioUabc = inventarioUabc;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getPartemodelo() {
        return partemodelo;
    }

    public void setPartemodelo(String partemodelo) {
        this.partemodelo = partemodelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblPiezasid != null ? tblPiezasid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblpiezas)) {
            return false;
        }
        Tblpiezas other = (Tblpiezas) object;
        if ((this.tblPiezasid == null && other.tblPiezasid != null) || (this.tblPiezasid != null && !this.tblPiezasid.equals(other.tblPiezasid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.Tblpiezas[ tblPiezasid=" + tblPiezasid + " ]";
    }
    
}
