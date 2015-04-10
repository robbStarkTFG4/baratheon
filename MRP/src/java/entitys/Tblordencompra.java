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
@Table(name = "tblordencompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblordencompra.findAll", query = "SELECT t FROM Tblordencompra t"),
    @NamedQuery(name = "Tblordencompra.findByIdTblOrdencompra", query = "SELECT t FROM Tblordencompra t WHERE t.idTblOrdencompra = :idTblOrdencompra"),
    @NamedQuery(name = "Tblordencompra.findByCantidad", query = "SELECT t FROM Tblordencompra t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "Tblordencompra.findByTotal", query = "SELECT t FROM Tblordencompra t WHERE t.total = :total"),
    @NamedQuery(name = "Tblordencompra.findByIva", query = "SELECT t FROM Tblordencompra t WHERE t.iva = :iva"),
    @NamedQuery(name = "Tblordencompra.findByEstatus", query = "SELECT t FROM Tblordencompra t WHERE t.estatus = :estatus"),
    @NamedQuery(name = "Tblordencompra.findByFechallegada", query = "SELECT t FROM Tblordencompra t WHERE t.fechallegada = :fechallegada"),
    @NamedQuery(name = "Tblordencompra.findByAbc", query = "SELECT t FROM Tblordencompra t WHERE t.abc = :abc")})
public class Tblordencompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblOrdencompra")
    private Integer idTblOrdencompra;
    @Size(max = 45)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 45)
    @Column(name = "total")
    private String total;
    @Size(max = 45)
    @Column(name = "iva")
    private String iva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estatus")
    private String estatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechallegada")
    private String fechallegada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ABC")
    private String abc;
    @JoinColumn(name = "TblUsuarios_idTblUsuarios", referencedColumnName = "idTblUsuarios")
    @ManyToOne(optional = false)
    private Tblusuarios tblUsuariosidTblUsuarios;
    @JoinColumn(name = "TblProvedores_idTblProvedores", referencedColumnName = "idTblProvedores")
    @ManyToOne(optional = false)
    private Tblprovedores tblProvedoresidTblProvedores;
    @JoinColumn(name = "TblOrdencliente_idTblOrdencliente", referencedColumnName = "idTblOrdencliente")
    @ManyToOne(optional = false)
    private Tblordencliente tblOrdenclienteidTblOrdencliente;
    @JoinColumn(name = "TblMateria_idTblMateria", referencedColumnName = "idTblMateria")
    @ManyToOne(optional = false)
    private Tblmateria tblMateriaidTblMateria;

    public Tblordencompra() {
    }

    public Tblordencompra(Integer idTblOrdencompra) {
        this.idTblOrdencompra = idTblOrdencompra;
    }

    public Tblordencompra(Integer idTblOrdencompra, String estatus, String fechallegada, String abc) {
        this.idTblOrdencompra = idTblOrdencompra;
        this.estatus = estatus;
        this.fechallegada = fechallegada;
        this.abc = abc;
    }

    public Integer getIdTblOrdencompra() {
        return idTblOrdencompra;
    }

    public void setIdTblOrdencompra(Integer idTblOrdencompra) {
        this.idTblOrdencompra = idTblOrdencompra;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(String fechallegada) {
        this.fechallegada = fechallegada;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Tblusuarios getTblUsuariosidTblUsuarios() {
        return tblUsuariosidTblUsuarios;
    }

    public void setTblUsuariosidTblUsuarios(Tblusuarios tblUsuariosidTblUsuarios) {
        this.tblUsuariosidTblUsuarios = tblUsuariosidTblUsuarios;
    }

    public Tblprovedores getTblProvedoresidTblProvedores() {
        return tblProvedoresidTblProvedores;
    }

    public void setTblProvedoresidTblProvedores(Tblprovedores tblProvedoresidTblProvedores) {
        this.tblProvedoresidTblProvedores = tblProvedoresidTblProvedores;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblOrdencompra != null ? idTblOrdencompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblordencompra)) {
            return false;
        }
        Tblordencompra other = (Tblordencompra) object;
        if ((this.idTblOrdencompra == null && other.idTblOrdencompra != null) || (this.idTblOrdencompra != null && !this.idTblOrdencompra.equals(other.idTblOrdencompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblordencompra[ idTblOrdencompra=" + idTblOrdencompra + " ]";
    }
    
}
