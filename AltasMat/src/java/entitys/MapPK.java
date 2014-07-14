/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cristian
 */
@Embeddable
public class MapPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_map")
    private int idMap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subFamilias_id_subFam")
    private int subFamiliasidsubFam;

    public MapPK() {
    }

    public MapPK(int idMap, int subFamiliasidsubFam) {
        this.idMap = idMap;
        this.subFamiliasidsubFam = subFamiliasidsubFam;
    }

    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public int getSubFamiliasidsubFam() {
        return subFamiliasidsubFam;
    }

    public void setSubFamiliasidsubFam(int subFamiliasidsubFam) {
        this.subFamiliasidsubFam = subFamiliasidsubFam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMap;
        hash += (int) subFamiliasidsubFam;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MapPK)) {
            return false;
        }
        MapPK other = (MapPK) object;
        if (this.idMap != other.idMap) {
            return false;
        }
        if (this.subFamiliasidsubFam != other.subFamiliasidsubFam) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.MapPK[ idMap=" + idMap + ", subFamiliasidsubFam=" + subFamiliasidsubFam + " ]";
    }
    
}
