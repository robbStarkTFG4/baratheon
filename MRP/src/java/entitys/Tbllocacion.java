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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbllocacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbllocacion.findAll", query = "SELECT t FROM Tbllocacion t"),
    @NamedQuery(name = "Tbllocacion.findByIdTblLocacion", query = "SELECT t FROM Tbllocacion t WHERE t.idTblLocacion = :idTblLocacion"),
    @NamedQuery(name = "Tbllocacion.findByLocacion", query = "SELECT t FROM Tbllocacion t WHERE t.locacion = :locacion"),
    @NamedQuery(name = "Tbllocacion.findByDescripcion", query = "SELECT t FROM Tbllocacion t WHERE t.descripcion = :descripcion")})
public class Tbllocacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblLocacion")
    private Integer idTblLocacion;
    @Size(max = 45)
    @Column(name = "locacion")
    private String locacion;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblLocacionidTblLocacion")
    private List<Tblalmacen> tblalmacenList;

    public Tbllocacion() {
    }

    public Tbllocacion(Integer idTblLocacion) {
        this.idTblLocacion = idTblLocacion;
    }

    public Integer getIdTblLocacion() {
        return idTblLocacion;
    }

    public void setIdTblLocacion(Integer idTblLocacion) {
        this.idTblLocacion = idTblLocacion;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Tblalmacen> getTblalmacenList() {
        return tblalmacenList;
    }

    public void setTblalmacenList(List<Tblalmacen> tblalmacenList) {
        this.tblalmacenList = tblalmacenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblLocacion != null ? idTblLocacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbllocacion)) {
            return false;
        }
        Tbllocacion other = (Tbllocacion) object;
        if ((this.idTblLocacion == null && other.idTblLocacion != null) || (this.idTblLocacion != null && !this.idTblLocacion.equals(other.idTblLocacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tbllocacion[ idTblLocacion=" + idTblLocacion + " ]";
    }
    
}
