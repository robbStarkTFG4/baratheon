/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

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
 * @author cristian
 */
@Entity
@Table(name = "tblprovedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblprovedores.findAll", query = "SELECT t FROM Tblprovedores t"),
    @NamedQuery(name = "Tblprovedores.findByIdTblProvedores", query = "SELECT t FROM Tblprovedores t WHERE t.idTblProvedores = :idTblProvedores"),
    @NamedQuery(name = "Tblprovedores.findByEmpresa", query = "SELECT t FROM Tblprovedores t WHERE t.empresa = :empresa"),
    @NamedQuery(name = "Tblprovedores.findByRfc", query = "SELECT t FROM Tblprovedores t WHERE t.rfc = :rfc"),
    @NamedQuery(name = "Tblprovedores.findByRepresentante", query = "SELECT t FROM Tblprovedores t WHERE t.representante = :representante"),
    @NamedQuery(name = "Tblprovedores.findByTelefono", query = "SELECT t FROM Tblprovedores t WHERE t.telefono = :telefono")})
public class Tblprovedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblProvedores")
    private Integer idTblProvedores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "RFC")
    private String rfc;
    @Size(max = 45)
    @Column(name = "representante")
    private String representante;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblProvedoresidTblProvedores")
    private List<TblmaterialProvedor> tblmaterialProvedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblProvedoresidTblProvedores")
    private List<Tblordencompra> tblordencompraList;

    public Tblprovedores() {
    }

    public Tblprovedores(Integer idTblProvedores) {
        this.idTblProvedores = idTblProvedores;
    }

    public Tblprovedores(Integer idTblProvedores, String empresa, String rfc) {
        this.idTblProvedores = idTblProvedores;
        this.empresa = empresa;
        this.rfc = rfc;
    }

    public Integer getIdTblProvedores() {
        return idTblProvedores;
    }

    public void setIdTblProvedores(Integer idTblProvedores) {
        this.idTblProvedores = idTblProvedores;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<TblmaterialProvedor> getTblmaterialProvedorList() {
        return tblmaterialProvedorList;
    }

    public void setTblmaterialProvedorList(List<TblmaterialProvedor> tblmaterialProvedorList) {
        this.tblmaterialProvedorList = tblmaterialProvedorList;
    }

    @XmlTransient
    public List<Tblordencompra> getTblordencompraList() {
        return tblordencompraList;
    }

    public void setTblordencompraList(List<Tblordencompra> tblordencompraList) {
        this.tblordencompraList = tblordencompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblProvedores != null ? idTblProvedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblprovedores)) {
            return false;
        }
        Tblprovedores other = (Tblprovedores) object;
        if ((this.idTblProvedores == null && other.idTblProvedores != null) || (this.idTblProvedores != null && !this.idTblProvedores.equals(other.idTblProvedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblprovedores[ idTblProvedores=" + idTblProvedores + " ]";
    }
    
}
