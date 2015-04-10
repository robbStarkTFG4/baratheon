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
@Table(name = "tblproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproducto.findAll", query = "SELECT t FROM Tblproducto t"),
    @NamedQuery(name = "Tblproducto.findByIdTblProducto", query = "SELECT t FROM Tblproducto t WHERE t.idTblProducto = :idTblProducto"),
    @NamedQuery(name = "Tblproducto.findByNombre", query = "SELECT t FROM Tblproducto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblproducto.findByPrecio", query = "SELECT t FROM Tblproducto t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tblproducto.findByModelo", query = "SELECT t FROM Tblproducto t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Tblproducto.findByDescripcion", query = "SELECT t FROM Tblproducto t WHERE t.descripcion = :descripcion")})
public class Tblproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblProducto")
    private Integer idTblProducto;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private Integer precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public Tblproducto() {
    }

    public Tblproducto(Integer idTblProducto) {
        this.idTblProducto = idTblProducto;
    }

    public Tblproducto(Integer idTblProducto, String modelo) {
        this.idTblProducto = idTblProducto;
        this.modelo = modelo;
    }

    public Integer getIdTblProducto() {
        return idTblProducto;
    }

    public void setIdTblProducto(Integer idTblProducto) {
        this.idTblProducto = idTblProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblProducto != null ? idTblProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblproducto)) {
            return false;
        }
        Tblproducto other = (Tblproducto) object;
        if ((this.idTblProducto == null && other.idTblProducto != null) || (this.idTblProducto != null && !this.idTblProducto.equals(other.idTblProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblproducto[ idTblProducto=" + idTblProducto + " ]";
    }
    
}
