/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "fabricacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricacion.findAll", query = "SELECT f FROM Fabricacion f"),
    @NamedQuery(name = "Fabricacion.findByCantidad", query = "SELECT f FROM Fabricacion f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "Fabricacion.findByIdFabricacioncol", query = "SELECT f FROM Fabricacion f WHERE f.idFabricacioncol = :idFabricacioncol")})
public class Fabricacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFabricacioncol")
    private Integer idFabricacioncol;
    @JoinColumn(name = "TblProducto_idTblProducto", referencedColumnName = "idTblProducto")
    @ManyToOne(optional = false)
    private Tblproducto tblProductoidTblProducto;
    @JoinColumn(name = "TblMateria_idTblMateria", referencedColumnName = "idTblMateria")
    @ManyToOne(optional = false)
    private Tblmateria tblMateriaidTblMateria;

    public Fabricacion() {
    }

    public Fabricacion(Integer idFabricacioncol) {
        this.idFabricacioncol = idFabricacioncol;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdFabricacioncol() {
        return idFabricacioncol;
    }

    public void setIdFabricacioncol(Integer idFabricacioncol) {
        this.idFabricacioncol = idFabricacioncol;
    }

    public Tblproducto getTblProductoidTblProducto() {
        return tblProductoidTblProducto;
    }

    public void setTblProductoidTblProducto(Tblproducto tblProductoidTblProducto) {
        this.tblProductoidTblProducto = tblProductoidTblProducto;
    }

    public Tblmateria getTblMateriaidTblMateria() {
        return tblMateriaidTblMateria;
    }

    public void setTblMateriaidTblMateria(Tblmateria tblMateriaidTblMateria) {
        this.tblMateriaidTblMateria = tblMateriaidTblMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricacioncol != null ? idFabricacioncol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricacion)) {
            return false;
        }
        Fabricacion other = (Fabricacion) object;
        if ((this.idFabricacioncol == null && other.idFabricacioncol != null) || (this.idFabricacioncol != null && !this.idFabricacioncol.equals(other.idFabricacioncol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Fabricacion[ idFabricacioncol=" + idFabricacioncol + " ]";
    }
    
}
