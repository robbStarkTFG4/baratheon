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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblordentrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblordentrabajo.findAll", query = "SELECT t FROM Tblordentrabajo t"),
    @NamedQuery(name = "Tblordentrabajo.findByIdTblOrdentrabajo", query = "SELECT t FROM Tblordentrabajo t WHERE t.idTblOrdentrabajo = :idTblOrdentrabajo"),
    @NamedQuery(name = "Tblordentrabajo.findByFechacaptura", query = "SELECT t FROM Tblordentrabajo t WHERE t.fechacaptura = :fechacaptura"),
    @NamedQuery(name = "Tblordentrabajo.findByFechaentrega", query = "SELECT t FROM Tblordentrabajo t WHERE t.fechaentrega = :fechaentrega"),
    @NamedQuery(name = "Tblordentrabajo.findByEstatus", query = "SELECT t FROM Tblordentrabajo t WHERE t.estatus = :estatus"),
    @NamedQuery(name = "Tblordentrabajo.findByDuracionDias", query = "SELECT t FROM Tblordentrabajo t WHERE t.duracionDias = :duracionDias"),
    @NamedQuery(name = "Tblordentrabajo.findByCantidadproddia", query = "SELECT t FROM Tblordentrabajo t WHERE t.cantidadproddia = :cantidadproddia")})
public class Tblordentrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblOrdentrabajo")
    private Integer idTblOrdentrabajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechacaptura")
    private String fechacaptura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechaentrega")
    private String fechaentrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estatus")
    private String estatus;
    @Column(name = "duracionDias")
    private Integer duracionDias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadproddia")
    private int cantidadproddia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOrdentrabajoidTblOrdentrabajo")
    private List<Plan> planList;
    @JoinColumn(name = "TblUsuarios_idTblUsuarios", referencedColumnName = "idTblUsuarios")
    @ManyToOne(optional = false)
    private Tblusuarios tblUsuariosidTblUsuarios;
    @JoinColumn(name = "TblProducto_idTblProducto", referencedColumnName = "idTblProducto")
    @ManyToOne(optional = false)
    private Tblproducto tblProductoidTblProducto;
    @JoinColumn(name = "TblOrdencliente_idTblOrdencliente", referencedColumnName = "idTblOrdencliente")
    @ManyToOne(optional = false)
    private Tblordencliente tblOrdenclienteidTblOrdencliente;

    public Tblordentrabajo() {
    }

    public Tblordentrabajo(Integer idTblOrdentrabajo) {
        this.idTblOrdentrabajo = idTblOrdentrabajo;
    }

    public Tblordentrabajo(Integer idTblOrdentrabajo, String fechacaptura, String fechaentrega, String estatus, int cantidadproddia) {
        this.idTblOrdentrabajo = idTblOrdentrabajo;
        this.fechacaptura = fechacaptura;
        this.fechaentrega = fechaentrega;
        this.estatus = estatus;
        this.cantidadproddia = cantidadproddia;
    }

    public Integer getIdTblOrdentrabajo() {
        return idTblOrdentrabajo;
    }

    public void setIdTblOrdentrabajo(Integer idTblOrdentrabajo) {
        this.idTblOrdentrabajo = idTblOrdentrabajo;
    }

    public String getFechacaptura() {
        return fechacaptura;
    }

    public void setFechacaptura(String fechacaptura) {
        this.fechacaptura = fechacaptura;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getCantidadproddia() {
        return cantidadproddia;
    }

    public void setCantidadproddia(int cantidadproddia) {
        this.cantidadproddia = cantidadproddia;
    }

    @XmlTransient
    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    public Tblusuarios getTblUsuariosidTblUsuarios() {
        return tblUsuariosidTblUsuarios;
    }

    public void setTblUsuariosidTblUsuarios(Tblusuarios tblUsuariosidTblUsuarios) {
        this.tblUsuariosidTblUsuarios = tblUsuariosidTblUsuarios;
    }

    public Tblproducto getTblProductoidTblProducto() {
        return tblProductoidTblProducto;
    }

    public void setTblProductoidTblProducto(Tblproducto tblProductoidTblProducto) {
        this.tblProductoidTblProducto = tblProductoidTblProducto;
    }

    public Tblordencliente getTblOrdenclienteidTblOrdencliente() {
        return tblOrdenclienteidTblOrdencliente;
    }

    public void setTblOrdenclienteidTblOrdencliente(Tblordencliente tblOrdenclienteidTblOrdencliente) {
        this.tblOrdenclienteidTblOrdencliente = tblOrdenclienteidTblOrdencliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblOrdentrabajo != null ? idTblOrdentrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblordentrabajo)) {
            return false;
        }
        Tblordentrabajo other = (Tblordentrabajo) object;
        if ((this.idTblOrdentrabajo == null && other.idTblOrdentrabajo != null) || (this.idTblOrdentrabajo != null && !this.idTblOrdentrabajo.equals(other.idTblOrdentrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblordentrabajo[ idTblOrdentrabajo=" + idTblOrdentrabajo + " ]";
    }
    
}
