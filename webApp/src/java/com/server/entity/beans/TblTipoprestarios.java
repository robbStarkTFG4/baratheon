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
@Table(name = "tbl_tipoprestarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoprestarios.findAll", query = "SELECT t FROM TblTipoprestarios t"),
    @NamedQuery(name = "TblTipoprestarios.findByIdTipoprestarios", query = "SELECT t FROM TblTipoprestarios t WHERE t.idTipoprestarios = :idTipoprestarios"),
    @NamedQuery(name = "TblTipoprestarios.findByDescripcion", query = "SELECT t FROM TblTipoprestarios t WHERE t.descripcion = :descripcion")})
public class TblTipoprestarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipoprestarios")
    private Integer idTipoprestarios;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoprestarios")
    private List<TblPrestarios> tblPrestariosList;

    public TblTipoprestarios() {
    }

    public TblTipoprestarios(Integer idTipoprestarios) {
        this.idTipoprestarios = idTipoprestarios;
    }

    public Integer getIdTipoprestarios() {
        return idTipoprestarios;
    }

    public void setIdTipoprestarios(Integer idTipoprestarios) {
        this.idTipoprestarios = idTipoprestarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TblPrestarios> getTblPrestariosList() {
        return tblPrestariosList;
    }

    public void setTblPrestariosList(List<TblPrestarios> tblPrestariosList) {
        this.tblPrestariosList = tblPrestariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoprestarios != null ? idTipoprestarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoprestarios)) {
            return false;
        }
        TblTipoprestarios other = (TblTipoprestarios) object;
        if ((this.idTipoprestarios == null && other.idTipoprestarios != null) || (this.idTipoprestarios != null && !this.idTipoprestarios.equals(other.idTipoprestarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblTipoprestarios[ idTipoprestarios=" + idTipoprestarios + " ]";
    }
    
}
