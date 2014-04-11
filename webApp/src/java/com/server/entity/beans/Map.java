/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.server.entity.beans;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NORE
 */
@Entity
@Table(name = "map")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Map.findAll", query = "SELECT m FROM Map m"),
    @NamedQuery(name = "Map.findByIdMap", query = "SELECT m FROM Map m WHERE m.mapPK.idMap = :idMap"),
    @NamedQuery(name = "Map.findBySubFamiliasidsubFam", query = "SELECT m FROM Map m WHERE m.mapPK.subFamiliasidsubFam = :subFamiliasidsubFam")})
public class Map implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MapPK mapPK;
    @JoinColumn(name = "subFamilias_id_subFam", referencedColumnName = "id_subFam", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subfamilias subfamilias;
    @JoinColumn(name = "tbl_tipomaterial_id_tipomaterial", referencedColumnName = "id_tipomaterial")
    @ManyToOne(optional = false)
    private TblTipomaterial tblTipomaterialIdTipomaterial;

    public Map() {
    }

    public Map(MapPK mapPK) {
        this.mapPK = mapPK;
    }

    public Map(int idMap, int subFamiliasidsubFam) {
        this.mapPK = new MapPK(idMap, subFamiliasidsubFam);
    }

    public MapPK getMapPK() {
        return mapPK;
    }

    public void setMapPK(MapPK mapPK) {
        this.mapPK = mapPK;
    }

    public Subfamilias getSubfamilias() {
        return subfamilias;
    }

    public void setSubfamilias(Subfamilias subfamilias) {
        this.subfamilias = subfamilias;
    }

    public TblTipomaterial getTblTipomaterialIdTipomaterial() {
        return tblTipomaterialIdTipomaterial;
    }

    public void setTblTipomaterialIdTipomaterial(TblTipomaterial tblTipomaterialIdTipomaterial) {
        this.tblTipomaterialIdTipomaterial = tblTipomaterialIdTipomaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mapPK != null ? mapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Map)) {
            return false;
        }
        Map other = (Map) object;
        if ((this.mapPK == null && other.mapPK != null) || (this.mapPK != null && !this.mapPK.equals(other.mapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.server.entity.beans.Map[ mapPK=" + mapPK + " ]";
    }
    
}
