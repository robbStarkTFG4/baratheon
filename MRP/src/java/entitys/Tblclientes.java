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
@Table(name = "tblclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblclientes.findAll", query = "SELECT t FROM Tblclientes t"),
    @NamedQuery(name = "Tblclientes.findByIdTblClientes", query = "SELECT t FROM Tblclientes t WHERE t.idTblClientes = :idTblClientes"),
    @NamedQuery(name = "Tblclientes.findByNombre", query = "SELECT t FROM Tblclientes t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tblclientes.findByNumeroCliente", query = "SELECT t FROM Tblclientes t WHERE t.numeroCliente = :numeroCliente"),
    @NamedQuery(name = "Tblclientes.findByCorreo", query = "SELECT t FROM Tblclientes t WHERE t.correo = :correo"),
    @NamedQuery(name = "Tblclientes.findByTelefono", query = "SELECT t FROM Tblclientes t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "Tblclientes.findByDirecccion", query = "SELECT t FROM Tblclientes t WHERE t.direcccion = :direcccion")})
public class Tblclientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblClientes")
    private Integer idTblClientes;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NumeroCliente")
    private String numeroCliente;
    @Size(max = 45)
    @Column(name = "Correo")
    private String correo;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "direcccion")
    private String direcccion;

    public Tblclientes() {
    }

    public Tblclientes(Integer idTblClientes) {
        this.idTblClientes = idTblClientes;
    }

    public Tblclientes(Integer idTblClientes, String numeroCliente, String direcccion) {
        this.idTblClientes = idTblClientes;
        this.numeroCliente = numeroCliente;
        this.direcccion = direcccion;
    }

    public Integer getIdTblClientes() {
        return idTblClientes;
    }

    public void setIdTblClientes(Integer idTblClientes) {
        this.idTblClientes = idTblClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblClientes != null ? idTblClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblclientes)) {
            return false;
        }
        Tblclientes other = (Tblclientes) object;
        if ((this.idTblClientes == null && other.idTblClientes != null) || (this.idTblClientes != null && !this.idTblClientes.equals(other.idTblClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tblclientes[ idTblClientes=" + idTblClientes + " ]";
    }
    
}
