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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "tbl_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblArea.findAll", query = "SELECT t FROM TblArea t"),
    @NamedQuery(name = "TblArea.findByIdArea", query = "SELECT t FROM TblArea t WHERE t.idArea = :idArea"),
    @NamedQuery(name = "TblArea.findByDescripcion", query = "SELECT t FROM TblArea t WHERE t.descripcion = :descripcion")})
public class TblArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private List<TblMaterial> tblMaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAreaIdArea")
    private List<TblTipomaterial> tblTipomaterialList;

    public TblArea() {
    }

    public TblArea(Integer idArea) {
        this.idArea = idArea;
    }

    public TblArea(Integer idArea, String descripcion) {
        this.idArea = idArea;
        this.descripcion = descripcion;
    }
    

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
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

    @XmlTransient
    public List<TblTipomaterial> getTblTipomaterialList() {
        return tblTipomaterialList;
    }

    public void setTblTipomaterialList(List<TblTipomaterial> tblTipomaterialList) {
        this.tblTipomaterialList = tblTipomaterialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblArea)) {
            return false;
        }
        TblArea other = (TblArea) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblArea[ idArea=" + idArea + " ]";
    }
    
}
