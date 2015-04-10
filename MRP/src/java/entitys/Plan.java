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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p"),
    @NamedQuery(name = "Plan.findByIdplan", query = "SELECT p FROM Plan p WHERE p.idplan = :idplan"),
    @NamedQuery(name = "Plan.findByCantidad", query = "SELECT p FROM Plan p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Plan.findByDia", query = "SELECT p FROM Plan p WHERE p.dia = :dia"),
    @NamedQuery(name = "Plan.findByFecha", query = "SELECT p FROM Plan p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Plan.findByEstatus", query = "SELECT p FROM Plan p WHERE p.estatus = :estatus")})
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplan")
    private Integer idplan;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia")
    private int dia;
    @Size(max = 10)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private int estatus;
    @JoinColumn(name = "TblOrdentrabajo_idTblOrdentrabajo", referencedColumnName = "idTblOrdentrabajo")
    @ManyToOne(optional = false)
    private Tblordentrabajo tblOrdentrabajoidTblOrdentrabajo;

    public Plan() {
    }

    public Plan(Integer idplan) {
        this.idplan = idplan;
    }

    public Plan(Integer idplan, int dia, int estatus) {
        this.idplan = idplan;
        this.dia = dia;
        this.estatus = estatus;
    }

    public Integer getIdplan() {
        return idplan;
    }

    public void setIdplan(Integer idplan) {
        this.idplan = idplan;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Tblordentrabajo getTblOrdentrabajoidTblOrdentrabajo() {
        return tblOrdentrabajoidTblOrdentrabajo;
    }

    public void setTblOrdentrabajoidTblOrdentrabajo(Tblordentrabajo tblOrdentrabajoidTblOrdentrabajo) {
        this.tblOrdentrabajoidTblOrdentrabajo = tblOrdentrabajoidTblOrdentrabajo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplan != null ? idplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.idplan == null && other.idplan != null) || (this.idplan != null && !this.idplan.equals(other.idplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Plan[ idplan=" + idplan + " ]";
    }
    
}
