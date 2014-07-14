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
@Table(name = "subfamilias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subfamilias.findAll", query = "SELECT s FROM Subfamilias s"),
    @NamedQuery(name = "Subfamilias.findByIdsubFam", query = "SELECT s FROM Subfamilias s WHERE s.idsubFam = :idsubFam"),
    @NamedQuery(name = "Subfamilias.findByNombre", query = "SELECT s FROM Subfamilias s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Subfamilias.findByDescripcion", query = "SELECT s FROM Subfamilias s WHERE s.descripcion = :descripcion")})
public class Subfamilias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subFam")
    private Integer idsubFam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subfamilias")
    private List<Map> mapList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subFamiliasidsubFam")
    private List<TblMaterial> tblMaterialList;

    public Subfamilias() {
    }

    public Subfamilias(Integer idsubFam, String nombre) {
        this.idsubFam = idsubFam;
        this.nombre = nombre;
    }

    public Subfamilias(Integer idsubFam) {
        this.idsubFam = idsubFam;
    }

   

    public Integer getIdsubFam() {
        return idsubFam;
    }

    public void setIdsubFam(Integer idsubFam) {
        this.idsubFam = idsubFam;
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
        hash += (idsubFam != null ? idsubFam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subfamilias)) {
            return false;
        }
        Subfamilias other = (Subfamilias) object;
        if ((this.idsubFam == null && other.idsubFam != null) || (this.idsubFam != null && !this.idsubFam.equals(other.idsubFam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Subfamilias[ idsubFam=" + idsubFam + " ]";
    }
    
}
