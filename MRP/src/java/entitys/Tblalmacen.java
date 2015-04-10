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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tblalmacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblalmacen.findAll", query = "SELECT t FROM Tblalmacen t"),
    @NamedQuery(name = "Tblalmacen.findByIdTblAlmacen", query = "SELECT t FROM Tblalmacen t WHERE t.idTblAlmacen = :idTblAlmacen"),
    @NamedQuery(name = "Tblalmacen.findByDescripcion", query = "SELECT t FROM Tblalmacen t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tblalmacen.findByCanridad", query = "SELECT t FROM Tblalmacen t WHERE t.canridad = :canridad"),
    @NamedQuery(name = "Tblalmacen.findByFechaMovimiento", query = "SELECT t FROM Tblalmacen t WHERE t.fechaMovimiento = :fechaMovimiento")})
public class Tblalmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblAlmacen")
    private Integer idTblAlmacen;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "Canridad")
    private String canridad;
    @Size(max = 45)
    @Column(name = "fechaMovimiento")
    private String fechaMovimiento;
    @JoinColumn(name = "TblOrdencliente_idTblOrdencliente", referencedColumnName = "idTblOrdencliente")
    @ManyToOne(optional = false)
    private Tblordencliente tblOrdenclienteidTblOrdencliente;
    @JoinColumn(name = "TblMateria_idTblMateria", referencedColumnName = "idTblMateria")
    @ManyToOne(optional = false)
    private Tblmateria tblMateriaidTblMateria;
    @JoinColumn(name = "TblLocacion_idTblLocacion", referencedColumnName = "idTblLocacion")
    @ManyToOne(optional = false)
    private Tbllocacion tblLocacionidTblLocacion;
    @JoinColumn(name = "TblActividadalmacen_idTblActividadalmacen", referencedColumnName = "idTblActividadalmacen")
    @ManyToOne(optional = false)
    private Tblactividadalmacen tblActividadalmacenidTblActividadalmacen;

    public Tblalmacen() {
    }

    public Tblalmacen(Integer idTblAlmacen) {
        this.idTblAlmacen = idTblAlmacen;
    }

    public Integer getIdTblAlmacen() {
        return idTblAlmacen;
    }

    public void setIdTblAlmacen(Integer idTblAlmacen) {
        this.idTblAlmacen = idTblAlmacen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCanridad() {
        return canridad;
    }

    public void setCanridad(String canridad) {
        this.canridad = canridad;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Tblordencliente getTblOrdenclienteidTblOrdencliente() {
        return tblOrdenclienteidTblOrdencliente;
    }

    public void setTblOrdenclienteidTblOrdencliente(Tblordencliente tblOrdenclienteidTblOrdencliente) {
        this.tblOrdenclienteidTblOrdencliente = tblOrdenclienteidTblOrdencliente;
    }

    public Tblmateria getTblMateriaidTblMateria() {
        return tblMateriaidTblMateria;
    }

    public void setTblMateriaidTblMateria(Tblmateria tblMateriaidTblMateria) {
        this.tblMateriaidTblMateria = tblMateriaidTblMateria;
    }

    public Tbllocacion getTblLocacionidTblLocacion() {
        return tblLocacionidTblLocacion;
    }

    public void setTblLocacionidTblLocacion(Tbllocacion tblLocacionidTblLocacion) {
        this.tblLocacionidTblLocacion = tblLocacionidTblLocacion;
    }

    public Tblactividadalmacen getTblActividadalmacenidTblActividadalmacen() {
        return tblActividadalmacenidTblActividadalmacen;
    }

    public void setTblActividadalmacenidTblActividadalmacen(Tblactividadalmacen tblActividadalmacenidTblActividadalmacen) {
        this.tblActividadalmacenidTblActividadalmacen = tblActividadalmacenidTblActividadalmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblAlmacen != null ? idTblAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblalmacen)) {
            return false;
        }
        Tblalmacen other = (Tblalmacen) object;
        if ((this.idTblAlmacen == null && other.idTblAlmacen != null) || (this.idTblAlmacen != null && !this.idTblAlmacen.equals(other.idTblAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblalmacen[ idTblAlmacen=" + idTblAlmacen + " ]";
    }
    
}
