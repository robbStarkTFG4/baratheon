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
@Table(name = "tbltipous")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbltipous.findAll", query = "SELECT t FROM Tbltipous t"),
    @NamedQuery(name = "Tbltipous.findByIdTblTipous", query = "SELECT t FROM Tbltipous t WHERE t.idTblTipous = :idTblTipous"),
    @NamedQuery(name = "Tbltipous.findByTipo", query = "SELECT t FROM Tbltipous t WHERE t.tipo = :tipo")})
public class Tbltipous implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTblTipous")
    private Integer idTblTipous;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTblTipous")
    private List<Tblusuarios> tblusuariosList;

    public Tbltipous() {
    }

    public Tbltipous(Integer idTblTipous) {
        this.idTblTipous = idTblTipous;
    }

    public Tbltipous(Integer idTblTipous, String tipo) {
        this.idTblTipous = idTblTipous;
        this.tipo = tipo;
    }

    public Integer getIdTblTipous() {
        return idTblTipous;
    }

    public void setIdTblTipous(Integer idTblTipous) {
        this.idTblTipous = idTblTipous;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Tblusuarios> getTblusuariosList() {
        return tblusuariosList;
    }

    public void setTblusuariosList(List<Tblusuarios> tblusuariosList) {
        this.tblusuariosList = tblusuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblTipous != null ? idTblTipous.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbltipous)) {
            return false;
        }
        Tbltipous other = (Tbltipous) object;
        if ((this.idTblTipous == null && other.idTblTipous != null) || (this.idTblTipous != null && !this.idTblTipous.equals(other.idTblTipous))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Tbltipous[ idTblTipous=" + idTblTipous + " ]";
    }
    
}
