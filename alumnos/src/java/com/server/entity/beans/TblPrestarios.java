/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.entity.beans;

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
 * @author NORE
 */
@Entity
@Table(name = "tbl_prestarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPrestarios.findAll", query = "SELECT t FROM TblPrestarios t"),
    @NamedQuery(name = "TblPrestarios.findByIdPrestario", query = "SELECT t FROM TblPrestarios t WHERE t.idPrestario = :idPrestario"),
    @NamedQuery(name = "TblPrestarios.findByNombre", query = "SELECT t FROM TblPrestarios t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblPrestarios.findByApaterno", query = "SELECT t FROM TblPrestarios t WHERE t.apaterno = :apaterno"),
    @NamedQuery(name = "TblPrestarios.findByAmaterno", query = "SELECT t FROM TblPrestarios t WHERE t.amaterno = :amaterno"),
    @NamedQuery(name = "TblPrestarios.findByTel", query = "SELECT t FROM TblPrestarios t WHERE t.tel = :tel"),
    @NamedQuery(name = "TblPrestarios.findByEmail", query = "SELECT t FROM TblPrestarios t WHERE t.email = :email"),
    @NamedQuery(name = "TblPrestarios.findByUsuario", query = "SELECT t FROM TblPrestarios t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TblPrestarios.findByCarrera", query = "SELECT t FROM TblPrestarios t WHERE t.carrera = :carrera"),
    @NamedQuery(name = "TblPrestarios.findByActivo", query = "SELECT t FROM TblPrestarios t WHERE t.activo = :activo")})
public class TblPrestarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestario")
    private Integer idPrestario;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apaterno")
    private String apaterno;
    @Size(max = 45)
    @Column(name = "amaterno")
    private String amaterno;
    @Size(max = 45)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 45)
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "activo")
    private Integer activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrestario")
    private List<TblPrestamo> tblPrestamoList;
    @JoinColumn(name = "id_tipoprestarios", referencedColumnName = "id_tipoprestarios")
    @ManyToOne(optional = false)
    private TblTipoprestarios idTipoprestarios;

    public TblPrestarios() {
    }

    public TblPrestarios(Integer idPrestario) {
        this.idPrestario = idPrestario;
    }
    
     public TblPrestarios(Integer idPrestario, String nombre, String apaterno, String amaterno, String tel, String email, String usuario, String carrera, Integer activo) {
        this.idPrestario = idPrestario;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.tel = tel;
        this.email = email;
        this.usuario = usuario;
        this.carrera = carrera;
        this.activo = activo;
    }
     
    public TblPrestarios(Integer idPrestario, String nombre, String apaterno, String amaterno, String tel, String email, String usuario, String carrera) {
        this.idPrestario = idPrestario;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.tel = tel;
        this.email = email;
        this.usuario = usuario;
        this.carrera = carrera;
    }

    public TblPrestarios(Integer idPrestario, String usuario) {
        this.idPrestario = idPrestario;
        this.usuario = usuario;
    }

    public Integer getIdPrestario() {
        return idPrestario;
    }

    public void setIdPrestario(Integer idPrestario) {
        this.idPrestario = idPrestario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<TblPrestamo> getTblPrestamoList() {
        return tblPrestamoList;
    }

    public void setTblPrestamoList(List<TblPrestamo> tblPrestamoList) {
        this.tblPrestamoList = tblPrestamoList;
    }

    public TblTipoprestarios getIdTipoprestarios() {
        return idTipoprestarios;
    }

    public void setIdTipoprestarios(TblTipoprestarios idTipoprestarios) {
        this.idTipoprestarios = idTipoprestarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestario != null ? idPrestario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPrestarios)) {
            return false;
        }
        TblPrestarios other = (TblPrestarios) object;
        if ((this.idPrestario == null && other.idPrestario != null) || (this.idPrestario != null && !this.idPrestario.equals(other.idPrestario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblPrestarios[ idPrestario=" + idPrestario + " ]";
    }
    
}
