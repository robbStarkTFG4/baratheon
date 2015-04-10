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
@Table(name = "tblactividadalmacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblactividadalmacen.findAll", query = "SELECT t FROM Tblactividadalmacen t"),
    @NamedQuery(name = "Tblactividadalmacen.findByIdTblActividadalmacen", query = "SELECT t FROM Tblactividadalmacen t WHERE t.idTblActividadalmacen = :idTblActividadalmacen"),
    @NamedQuery(name = "Tblactividadalmacen.findByActividad", query = "SELECT t FROM Tblactividadalmacen t WHERE t.actividad = :actividad")})
public class Tblactividadalmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblActividadalmacen")
    private Integer idTblActividadalmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "actividad")
    private String actividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblActividadalmacenidTblActividadalmacen")
    private List<Tblalmacen> tblalmacenList;

    public Tblactividadalmacen() {
    }

    public Tblactividadalmacen(Integer idTblActividadalmacen) {
        this.idTblActividadalmacen = idTblActividadalmacen;
    }

    public Tblactividadalmacen(Integer idTblActividadalmacen, String actividad) {
        this.idTblActividadalmacen = idTblActividadalmacen;
        this.actividad = actividad;
    }

    public Integer getIdTblActividadalmacen() {
        return idTblActividadalmacen;
    }

    public void setIdTblActividadalmacen(Integer idTblActividadalmacen) {
        this.idTblActividadalmacen = idTblActividadalmacen;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
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
        hash += (idTblActividadalmacen != null ? idTblActividadalmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblactividadalmacen)) {
            return false;
        }
        Tblactividadalmacen other = (Tblactividadalmacen) object;
        if ((this.idTblActividadalmacen == null && other.idTblActividadalmacen != null) || (this.idTblActividadalmacen != null && !this.idTblActividadalmacen.equals(other.idTblActividadalmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblactividadalmacen[ idTblActividadalmacen=" + idTblActividadalmacen + " ]";
    }
    
}
