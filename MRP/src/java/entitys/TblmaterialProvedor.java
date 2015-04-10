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
@Table(name = "tblmaterial_provedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblmaterialProvedor.findAll", query = "SELECT t FROM TblmaterialProvedor t"),
    @NamedQuery(name = "TblmaterialProvedor.findByPrecio", query = "SELECT t FROM TblmaterialProvedor t WHERE t.precio = :precio"),
    @NamedQuery(name = "TblmaterialProvedor.findByIdTblMaterialProvedor", query = "SELECT t FROM TblmaterialProvedor t WHERE t.idTblMaterialProvedor = :idTblMaterialProvedor")})
public class TblmaterialProvedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "precio")
    private String precio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblMaterial_Provedor")
    private Integer idTblMaterialProvedor;
    @JoinColumn(name = "TblMateria_idTblMateria", referencedColumnName = "idTblMateria")
    @ManyToOne(optional = false)
    private Tblmateria tblMateriaidTblMateria;
    @JoinColumn(name = "TblProvedores_idTblProvedores", referencedColumnName = "idTblProvedores")
    @ManyToOne(optional = false)
    private Tblprovedores tblProvedoresidTblProvedores;

    public TblmaterialProvedor() {
    }

    public TblmaterialProvedor(Integer idTblMaterialProvedor) {
        this.idTblMaterialProvedor = idTblMaterialProvedor;
    }

    public TblmaterialProvedor(Integer idTblMaterialProvedor, String precio) {
        this.idTblMaterialProvedor = idTblMaterialProvedor;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getIdTblMaterialProvedor() {
        return idTblMaterialProvedor;
    }

    public void setIdTblMaterialProvedor(Integer idTblMaterialProvedor) {
        this.idTblMaterialProvedor = idTblMaterialProvedor;
    }

    public Tblmateria getTblMateriaidTblMateria() {
        return tblMateriaidTblMateria;
    }

    public void setTblMateriaidTblMateria(Tblmateria tblMateriaidTblMateria) {
        this.tblMateriaidTblMateria = tblMateriaidTblMateria;
    }

    public Tblprovedores getTblProvedoresidTblProvedores() {
        return tblProvedoresidTblProvedores;
    }

    public void setTblProvedoresidTblProvedores(Tblprovedores tblProvedoresidTblProvedores) {
        this.tblProvedoresidTblProvedores = tblProvedoresidTblProvedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblMaterialProvedor != null ? idTblMaterialProvedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblmaterialProvedor)) {
            return false;
        }
        TblmaterialProvedor other = (TblmaterialProvedor) object;
        if ((this.idTblMaterialProvedor == null && other.idTblMaterialProvedor != null) || (this.idTblMaterialProvedor != null && !this.idTblMaterialProvedor.equals(other.idTblMaterialProvedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.TblmaterialProvedor[ idTblMaterialProvedor=" + idTblMaterialProvedor + " ]";
    }
    
}
