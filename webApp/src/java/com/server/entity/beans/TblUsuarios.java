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
@Table(name = "tbl_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuarios.findAll", query = "SELECT t FROM TblUsuarios t"),
    @NamedQuery(name = "TblUsuarios.findByIdUsuarios", query = "SELECT t FROM TblUsuarios t WHERE t.idUsuarios = :idUsuarios"),
    @NamedQuery(name = "TblUsuarios.findByNombre", query = "SELECT t FROM TblUsuarios t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblUsuarios.findByContrase\u00f1a", query = "SELECT t FROM TblUsuarios t WHERE t.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "TblUsuarios.findByApellidop", query = "SELECT t FROM TblUsuarios t WHERE t.apellidop = :apellidop"),
    @NamedQuery(name = "TblUsuarios.findByApellidom", query = "SELECT t FROM TblUsuarios t WHERE t.apellidom = :apellidom"),
    @NamedQuery(name = "TblUsuarios.findByEmail", query = "SELECT t FROM TblUsuarios t WHERE t.email = :email"),
    @NamedQuery(name = "TblUsuarios.findByTel", query = "SELECT t FROM TblUsuarios t WHERE t.tel = :tel"),
    @NamedQuery(name = "TblUsuarios.findByUsuario", query = "SELECT t FROM TblUsuarios t WHERE t.usuario = :usuario")})
public class TblUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuarios")
    private Integer idUsuarios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidop")
    private String apellidop;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidom")
    private String apellidom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "tel")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @JoinColumn(name = "id_tipousuarios", referencedColumnName = "id_tipousuarios")
    @ManyToOne(optional = false)
    private TblTipousuarios idTipousuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarios")
    private List<TblPrestamo> tblPrestamoList;

    public TblUsuarios() {
    }

    public TblUsuarios(Integer idUsuarios, String usuario, TblTipousuarios idTipousuarios) {
        this.idUsuarios = idUsuarios;
        this.usuario = usuario;
        this.idTipousuarios = idTipousuarios;
    }
    public TblUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public TblUsuarios(Integer idUsuarios, String nombre, String contraseña, String apellidop, String apellidom, String usuario) {
        this.idUsuarios = idUsuarios;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.usuario = usuario;
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TblTipousuarios getIdTipousuarios() {
        return idTipousuarios;
    }

    public void setIdTipousuarios(TblTipousuarios idTipousuarios) {
        this.idTipousuarios = idTipousuarios;
    }

    @XmlTransient
    public List<TblPrestamo> getTblPrestamoList() {
        return tblPrestamoList;
    }

    public void setTblPrestamoList(List<TblPrestamo> tblPrestamoList) {
        this.tblPrestamoList = tblPrestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuarios)) {
            return false;
        }
        TblUsuarios other = (TblUsuarios) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.TblUsuarios[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
