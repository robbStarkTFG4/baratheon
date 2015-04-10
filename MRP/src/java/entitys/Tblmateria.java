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
@Table(name = "tblmateria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblmateria.findAll", query = "SELECT t FROM Tblmateria t"),
    @NamedQuery(name = "Tblmateria.findByIdTblMateria", query = "SELECT t FROM Tblmateria t WHERE t.idTblMateria = :idTblMateria"),
    @NamedQuery(name = "Tblmateria.findByNombre", query = "SELECT t FROM Tblmateria t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblmateria.findByStock", query = "SELECT t FROM Tblmateria t WHERE t.stock = :stock"),
    @NamedQuery(name = "Tblmateria.findByFechaCompra", query = "SELECT t FROM Tblmateria t WHERE t.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "Tblmateria.findByPrecio", query = "SELECT t FROM Tblmateria t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tblmateria.findByDescripcion", query = "SELECT t FROM Tblmateria t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tblmateria.findByVolumenAdll", query = "SELECT t FROM Tblmateria t WHERE t.volumenAdll = :volumenAdll")})
public class Tblmateria implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblMateriaidTblMateria")
    private List<Fabricacion> fabricacionList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblMateria")
    private Integer idTblMateria;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Stock")
    private Integer stock;
    @Size(max = 45)
    @Column(name = "fechaCompra")
    private String fechaCompra;
    @Size(max = 45)
    @Column(name = "precio")
    private String precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumenAdll")
    private int volumenAdll;

    public Tblmateria() {
    }

    public Tblmateria(Integer idTblMateria) {
        this.idTblMateria = idTblMateria;
    }

    public Tblmateria(Integer idTblMateria, String descripcion, int volumenAdll) {
        this.idTblMateria = idTblMateria;
        this.descripcion = descripcion;
        this.volumenAdll = volumenAdll;
    }

    public Integer getIdTblMateria() {
        return idTblMateria;
    }

    public void setIdTblMateria(Integer idTblMateria) {
        this.idTblMateria = idTblMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVolumenAdll() {
        return volumenAdll;
    }

    public void setVolumenAdll(int volumenAdll) {
        this.volumenAdll = volumenAdll;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblMateria != null ? idTblMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblmateria)) {
            return false;
        }
        Tblmateria other = (Tblmateria) object;
        if ((this.idTblMateria == null && other.idTblMateria != null) || (this.idTblMateria != null && !this.idTblMateria.equals(other.idTblMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblmateria[ idTblMateria=" + idTblMateria + " ]";
    }

    @XmlTransient
    public List<Fabricacion> getFabricacionList() {
        return fabricacionList;
    }

    public void setFabricacionList(List<Fabricacion> fabricacionList) {
        this.fabricacionList = fabricacionList;
    }
    
}
