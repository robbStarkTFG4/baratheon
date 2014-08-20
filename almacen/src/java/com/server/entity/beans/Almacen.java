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
@Table(name = "almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a"),
    @NamedQuery(name = "Almacen.findByIdalmacen", query = "SELECT a FROM Almacen a WHERE a.idalmacen = :idalmacen"),
    @NamedQuery(name = "Almacen.findByDescripcion", query = "SELECT a FROM Almacen a WHERE a.descripcion = :descripcion")})
public class Almacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalmacen")
    private Integer idalmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacenIdalmacen")
    private List<TblMaterial> tblMaterialList;

    public Almacen() {
    }

    public Almacen(Integer idalmacen) {
        this.idalmacen = idalmacen;
    }

    public Almacen(Integer idalmacen, String descripcion) {
        this.idalmacen = idalmacen;
        this.descripcion = descripcion;
    }

    

    public Integer getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(Integer idalmacen) {
        this.idalmacen = idalmacen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TblMaterial> getTblMaterialList() {
        return tblMaterialList;
    }

    public void setTblMaterialList(List<TblMaterial> tblMaterialList) {
        this.tblMaterialList = tblMaterialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalmacen != null ? idalmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.idalmacen == null && other.idalmacen != null) || (this.idalmacen != null && !this.idalmacen.equals(other.idalmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.Almacen[ idalmacen=" + idalmacen + " ]";
    }
    
}
