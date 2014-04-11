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
@Table(name = "tbl_tipousuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipousuarios.findAll", query = "SELECT t FROM TblTipousuarios t"),
    @NamedQuery(name = "TblTipousuarios.findByIdTipousuarios", query = "SELECT t FROM TblTipousuarios t WHERE t.idTipousuarios = :idTipousuarios"),
    @NamedQuery(name = "TblTipousuarios.findByDescripcion", query = "SELECT t FROM TblTipousuarios t WHERE t.descripcion = :descripcion")})
public class TblTipousuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "id_tipousuarios")
    private String idTipousuarios;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipousuarios")
    private List<TblUsuarios> tblUsuariosList;

    public TblTipousuarios() {
    }

    public TblTipousuarios(String idTipousuarios) {
        this.idTipousuarios = idTipousuarios;
    }

    public String getIdTipousuarios() {
        return idTipousuarios;
    }

    public void setIdTipousuarios(String idTipousuarios) {
        this.idTipousuarios = idTipousuarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<TblUsuarios> getTblUsuariosList() {
        return tblUsuariosList;
    }

    public void setTblUsuariosList(List<TblUsuarios> tblUsuariosList) {
        this.tblUsuariosList = tblUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipousuarios != null ? idTipousuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipousuarios)) {
            return false;
        }
        TblTipousuarios other = (TblTipousuarios) object;
        if ((this.idTipousuarios == null && other.idTipousuarios != null) || (this.idTipousuarios != null && !this.idTipousuarios.equals(other.idTipousuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblTipousuarios[ idTipousuarios=" + idTipousuarios + " ]";
    }
    
}
