/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.entity;

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
 * @author NORE
 */
@Entity
@Table(name = "tbl_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMaterial.findAll", query = "SELECT t FROM TblMaterial t"),
    @NamedQuery(name = "TblMaterial.findByIdtblMaterial", query = "SELECT t FROM TblMaterial t WHERE t.idtblMaterial = :idtblMaterial"),
    @NamedQuery(name = "TblMaterial.findByNoParte", query = "SELECT t FROM TblMaterial t WHERE t.noParte = :noParte"),
    @NamedQuery(name = "TblMaterial.findByNombre", query = "SELECT t FROM TblMaterial t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblMaterial.findByDescripcion", query = "SELECT t FROM TblMaterial t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TblMaterial.findByStock", query = "SELECT t FROM TblMaterial t WHERE t.stock = :stock"),
    @NamedQuery(name = "TblMaterial.findByCosto", query = "SELECT t FROM TblMaterial t WHERE t.costo = :costo"),
    @NamedQuery(name = "TblMaterial.findByImagen", query = "SELECT t FROM TblMaterial t WHERE t.imagen = :imagen")})
public class TblMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbl_material")
    private Integer idtblMaterial;
    @Size(max = 45)
    @Column(name = "noParte")
    private String noParte;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "costo")
    private Long costo;
    @Size(max = 45)
    @Column(name = "imagen")
    private String imagen;
    @JoinColumn(name = "subFamilias_id_subFam", referencedColumnName = "id_subFam")
    @ManyToOne(optional = false)
    private Subfamilias subFamiliasidsubFam;
    @JoinColumn(name = "id_tipomaterial", referencedColumnName = "id_tipomaterial")
    @ManyToOne(optional = false)
    private TblTipomaterial idTipomaterial;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private TblArea idArea;

    public TblMaterial() {
    }

    public TblMaterial(Integer idtblMaterial) {
        this.idtblMaterial = idtblMaterial;
    }

    public Integer getIdtblMaterial() {
        return idtblMaterial;
    }

    public void setIdtblMaterial(Integer idtblMaterial) {
        this.idtblMaterial = idtblMaterial;
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Subfamilias getSubFamiliasidsubFam() {
        return subFamiliasidsubFam;
    }

    public void setSubFamiliasidsubFam(Subfamilias subFamiliasidsubFam) {
        this.subFamiliasidsubFam = subFamiliasidsubFam;
    }

    public TblTipomaterial getIdTipomaterial() {
        return idTipomaterial;
    }

    public void setIdTipomaterial(TblTipomaterial idTipomaterial) {
        this.idTipomaterial = idTipomaterial;
    }

    public TblArea getIdArea() {
        return idArea;
    }

    public void setIdArea(TblArea idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblMaterial != null ? idtblMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMaterial)) {
            return false;
        }
        TblMaterial other = (TblMaterial) object;
        if ((this.idtblMaterial == null && other.idtblMaterial != null) || (this.idtblMaterial != null && !this.idtblMaterial.equals(other.idtblMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.TblMaterial[ idtblMaterial=" + idtblMaterial + " ]";
    }
    
}
