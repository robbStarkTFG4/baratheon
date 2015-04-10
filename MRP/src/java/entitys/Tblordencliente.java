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
@Table(name = "tblordencliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblordencliente.findAll", query = "SELECT t FROM Tblordencliente t"),
    @NamedQuery(name = "Tblordencliente.findByIdTblOrdencliente", query = "SELECT t FROM Tblordencliente t WHERE t.idTblOrdencliente = :idTblOrdencliente"),
    @NamedQuery(name = "Tblordencliente.findByCantidad", query = "SELECT t FROM Tblordencliente t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "Tblordencliente.findByFechaEntrega", query = "SELECT t FROM Tblordencliente t WHERE t.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Tblordencliente.findByFechaCaptura", query = "SELECT t FROM Tblordencliente t WHERE t.fechaCaptura = :fechaCaptura"),
    @NamedQuery(name = "Tblordencliente.findByEstatus", query = "SELECT t FROM Tblordencliente t WHERE t.estatus = :estatus")})
public class Tblordencliente implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOrdenclienteidTblOrdencliente")
    private List<Tblordentrabajo> tblordentrabajoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblOrdencliente")
    private Integer idTblOrdencliente;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 45)
    @Column(name = "FechaEntrega")
    private String fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FechaCaptura")
    private String fechaCaptura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estatus")
    private String estatus;
    @JoinColumn(name = "idTblProducto", referencedColumnName = "idTblProducto")
    @ManyToOne(optional = false)
    private Tblproducto idTblProducto;
    @JoinColumn(name = "idTblClientes", referencedColumnName = "idTblClientes")
    @ManyToOne(optional = false)
    private Tblclientes idTblClientes;

    public Tblordencliente() {
    }

    public Tblordencliente(Integer idTblOrdencliente) {
        this.idTblOrdencliente = idTblOrdencliente;
    }

    public Tblordencliente(Integer idTblOrdencliente, String fechaCaptura, String estatus) {
        this.idTblOrdencliente = idTblOrdencliente;
        this.fechaCaptura = fechaCaptura;
        this.estatus = estatus;
    }

    public Integer getIdTblOrdencliente() {
        return idTblOrdencliente;
    }

    public void setIdTblOrdencliente(Integer idTblOrdencliente) {
        this.idTblOrdencliente = idTblOrdencliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(String fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Tblproducto getIdTblProducto() {
        return idTblProducto;
    }

    public void setIdTblProducto(Tblproducto idTblProducto) {
        this.idTblProducto = idTblProducto;
    }

    public Tblclientes getIdTblClientes() {
        return idTblClientes;
    }

    public void setIdTblClientes(Tblclientes idTblClientes) {
        this.idTblClientes = idTblClientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblOrdencliente != null ? idTblOrdencliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblordencliente)) {
            return false;
        }
        Tblordencliente other = (Tblordencliente) object;
        if ((this.idTblOrdencliente == null && other.idTblOrdencliente != null) || (this.idTblOrdencliente != null && !this.idTblOrdencliente.equals(other.idTblOrdencliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblordencliente[ idTblOrdencliente=" + idTblOrdencliente + " ]";
    }

    @XmlTransient
    public List<Tblordentrabajo> getTblordentrabajoList() {
        return tblordentrabajoList;
    }

    public void setTblordentrabajoList(List<Tblordentrabajo> tblordentrabajoList) {
        this.tblordentrabajoList = tblordentrabajoList;
    }
    
}
