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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "tbl_tipomaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipomaterial.findAll", query = "SELECT t FROM TblTipomaterial t"),
    @NamedQuery(name = "TblTipomaterial.findByIdTipomaterial", query = "SELECT t FROM TblTipomaterial t WHERE t.idTipomaterial = :idTipomaterial"),
    @NamedQuery(name = "TblTipomaterial.findByDescripcion", query = "SELECT t FROM TblTipomaterial t WHERE t.descripcion = :descripcion")})
public class TblTipomaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipomaterial")
    private Integer idTipomaterial;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "tbl_area_id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private TblArea tblAreaIdArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblTipomaterialIdTipomaterial")
    private List<Map> mapList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipomaterial")
    private List<TblMaterial> tblMaterialList;

    public TblTipomaterial() {
    }

    public TblTipomaterial(Integer idTipomaterial) {
        this.idTipomaterial = idTipomaterial;
    }

    public Integer getIdTipomaterial() {
        return idTipomaterial;
    }

    public TblTipomaterial(Integer idTipomaterial, String descripcion) {
        this.idTipomaterial = idTipomaterial;
        this.descripcion = descripcion;
    }

    public void setIdTipomaterial(Integer idTipomaterial) {
        this.idTipomaterial = idTipomaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TblArea getTblAreaIdArea() {
        return tblAreaIdArea;
    }

    public void setTblAreaIdArea(TblArea tblAreaIdArea) {
        this.tblAreaIdArea = tblAreaIdArea;
    }

    @XmlTransient
    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }

    @XmlTransient
    public List<TblMaterial> getTblMaterialList() {
        return tblMaterialList;
    }

    public void setTblMaterialList(List<TblMaterial> tblMaterialList) {
        this.tblMaterialList = tblMaterialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipomaterial != null ? idTipomaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipomaterial)) {
            return false;
        }
        TblTipomaterial other = (TblTipomaterial) object;
        if ((this.idTipomaterial == null && other.idTipomaterial != null) || (this.idTipomaterial != null && !this.idTipomaterial.equals(other.idTipomaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.TblTipomaterial[ idTipomaterial=" + idTipomaterial + " ]";
    }
    
}
