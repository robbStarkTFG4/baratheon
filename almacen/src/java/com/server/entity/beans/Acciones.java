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
 * @author cristian
 */
@Entity
@Table(name = "acciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acciones.findAll", query = "SELECT a FROM Acciones a"),
    @NamedQuery(name = "Acciones.findByIdAcciones", query = "SELECT a FROM Acciones a WHERE a.idAcciones = :idAcciones"),
    @NamedQuery(name = "Acciones.findByDescripcion", query = "SELECT a FROM Acciones a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Acciones.findByUsuario", query = "SELECT a FROM Acciones a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "Acciones.findByFecha", query = "SELECT a FROM Acciones a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Acciones.findByHora", query = "SELECT a FROM Acciones a WHERE a.hora = :hora"),
    @NamedQuery(name = "Acciones.findByIdelementoModif", query = "SELECT a FROM Acciones a WHERE a.idelementoModif = :idelementoModif")})
public class Acciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acciones")
    private Integer idAcciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "hora")
    private String hora;
    @Size(max = 10)
    @Column(name = "id_elementoModif")
    private String idelementoModif;

    public Acciones() {
    }

    public Acciones(Integer idAcciones) {
        this.idAcciones = idAcciones;
    }

    public Acciones(Integer idAcciones, String descripcion, String usuario, String fecha, String hora) {
        this.idAcciones = idAcciones;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getIdAcciones() {
        return idAcciones;
    }

    public void setIdAcciones(Integer idAcciones) {
        this.idAcciones = idAcciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdelementoModif() {
        return idelementoModif;
    }

    public void setIdelementoModif(String idelementoModif) {
        this.idelementoModif = idelementoModif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcciones != null ? idAcciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acciones)) {
            return false;
        }
        Acciones other = (Acciones) object;
        if ((this.idAcciones == null && other.idAcciones != null) || (this.idAcciones != null && !this.idAcciones.equals(other.idAcciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.Acciones[ idAcciones=" + idAcciones + " ]";
    }
    
}
