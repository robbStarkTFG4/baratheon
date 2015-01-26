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
    @NamedQuery(name = "Tblpiezas.findByIdtblpiezas", query = "SELECT t FROM Tblpiezas t WHERE t.idtblpiezas = :idtblpiezas"),
    @NamedQuery(name = "Tblpiezas.findBySerie", query = "SELECT t FROM Tblpiezas t WHERE t.serie = :serie"),
    @NamedQuery(name = "Tblpiezas.findByInventarioUabc", query = "SELECT t FROM Tblpiezas t WHERE t.inventarioUabc = :inventarioUabc"),
    @NamedQuery(name = "Tblpiezas.findByClave2", query = "SELECT t FROM Tblpiezas t WHERE t.clave2 = :clave2"),
    @NamedQuery(name = "Tblpiezas.findByNoPartemodelo", query = "SELECT t FROM Tblpiezas t WHERE t.noPartemodelo = :noPartemodelo"),
    @NamedQuery(name = "Tblpiezas.findByNombre", query = "SELECT t FROM Tblpiezas t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblpiezas.findByComentario", query = "SELECT t FROM Tblpiezas t WHERE t.comentario = :comentario"),
    @NamedQuery(name = "Tblpiezas.findByEstatus", query = "SELECT t FROM Tblpiezas t WHERE t.estatus = :estatus")})
public class Tblpiezas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtblpiezas")
    private Integer idtblpiezas;
    @Size(max = 80)
    @Column(name = "serie")
    private String serie;
    @Size(max = 80)
    @Column(name = "inventario_uabc")
    private String inventarioUabc;
    @Size(max = 80)
    @Column(name = "clave2")
    private String clave2;
    @Size(max = 80)
    @Column(name = "noParte_modelo")
    private String noPartemodelo;
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 80)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "estatus")
    private Boolean estatus;

    public Tblpiezas() {
    }

    public Tblpiezas(Integer idtblpiezas) {
        this.idtblpiezas = idtblpiezas;
    }

    public Integer getIdtblpiezas() {
        return idtblpiezas;
    }

    public void setIdtblpiezas(Integer idtblpiezas) {
        this.idtblpiezas = idtblpiezas;
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

    public String getNoPartemodelo() {
        return noPartemodelo;
    }

    public void setNoPartemodelo(String noPartemodelo) {
        this.noPartemodelo = noPartemodelo;
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
        hash += (idtblpiezas != null ? idtblpiezas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblpiezas)) {
            return false;
        }
        Tblpiezas other = (Tblpiezas) object;
        if ((this.idtblpiezas == null && other.idtblpiezas != null) || (this.idtblpiezas != null && !this.idtblpiezas.equals(other.idtblpiezas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.Tblpiezas[ idtblpiezas=" + idtblpiezas + " ]";
    }
    
}
