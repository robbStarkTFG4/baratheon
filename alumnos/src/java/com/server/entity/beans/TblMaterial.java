/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server.entity.beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "TblMaterial.findByImagen", query = "SELECT t FROM TblMaterial t WHERE t.imagen = :imagen"),
    @NamedQuery(name = "TblMaterial.findByUnidadMedida", query = "SELECT t FROM TblMaterial t WHERE t.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "TblMaterial.findByMarca", query = "SELECT t FROM TblMaterial t WHERE t.marca = :marca"),
    @NamedQuery(name = "TblMaterial.findBySerie", query = "SELECT t FROM TblMaterial t WHERE t.serie = :serie"),
    @NamedQuery(name = "TblMaterial.findByEstado", query = "SELECT t FROM TblMaterial t WHERE t.estado = :estado"),
    @NamedQuery(name = "TblMaterial.findByUbicacionActual", query = "SELECT t FROM TblMaterial t WHERE t.ubicacionActual = :ubicacionActual"),
    @NamedQuery(name = "TblMaterial.findByResponsable", query = "SELECT t FROM TblMaterial t WHERE t.responsable = :responsable"),
    @NamedQuery(name = "TblMaterial.findByProveedor", query = "SELECT t FROM TblMaterial t WHERE t.proveedor = :proveedor"),
    @NamedQuery(name = "TblMaterial.findByNumeroFactura", query = "SELECT t FROM TblMaterial t WHERE t.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "TblMaterial.findByOrdenCompra", query = "SELECT t FROM TblMaterial t WHERE t.ordenCompra = :ordenCompra"),
    @NamedQuery(name = "TblMaterial.findByCodigoSip", query = "SELECT t FROM TblMaterial t WHERE t.codigoSip = :codigoSip"),
    @NamedQuery(name = "TblMaterial.findByFinanciamiento", query = "SELECT t FROM TblMaterial t WHERE t.financiamiento = :financiamiento"),
    @NamedQuery(name = "TblMaterial.findByTipoCompra", query = "SELECT t FROM TblMaterial t WHERE t.tipoCompra = :tipoCompra"),
    @NamedQuery(name = "TblMaterial.findByFechaRecepcion", query = "SELECT t FROM TblMaterial t WHERE t.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "TblMaterial.findByIdUabc", query = "SELECT t FROM TblMaterial t WHERE t.idUabc = :idUabc")})
public class TblMaterial implements Serializable {

    @Column(name = "showInQuery")
    private Boolean showInQuery;
    @Column(name = "inventariable")
    private Boolean inventariable;
    @Column(name = "total")
    private Integer total;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marca")
    private String marca;
    @Size(max = 12)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ubicacion_actual")
    private String ubicacionActual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "responsable")
    private String responsable;
    @Size(max = 60)
    @Column(name = "proveedor")
    private String proveedor;
    @Size(max = 15)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Size(max = 15)
    @Column(name = "orden_compra")
    private String ordenCompra;
    @Size(max = 15)
    @Column(name = "codigo_sip")
    private String codigoSip;
    @Size(max = 15)
    @Column(name = "financiamiento")
    private String financiamiento;
    @Size(max = 20)
    @Column(name = "tipo_compra")
    private String tipoCompra;
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Size(max = 15)
    @Column(name = "idUabc")
    private String idUabc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
    private List<TblDetalleprestamo> tblDetalleprestamoList;
    @JoinColumn(name = "almacen_idalmacen", referencedColumnName = "idalmacen")
    @ManyToOne(optional = false)
    private Almacen almacenIdalmacen;
    @JoinColumn(name = "subFamilias_id_subFam", referencedColumnName = "id_subFam")
    @ManyToOne(optional = false)
    private Subfamilias subFamiliasidsubFam;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private TblArea idArea;
    @JoinColumn(name = "id_tipomaterial", referencedColumnName = "id_tipomaterial")
    @ManyToOne(optional = false)
    private TblTipomaterial idTipomaterial;

    public TblMaterial() {
    }

    public TblMaterial(Integer idtblMaterial) {
        this.idtblMaterial = idtblMaterial;
    }

    public TblMaterial(String noParte, String nombre, Boolean showInQuery) {
        this.showInQuery = showInQuery;
        this.noParte = noParte;
        this.nombre = nombre;
    }

    public TblMaterial(Integer idtblMaterial, String unidadMedida, String marca, String estado, String ubicacionActual, String responsable) {
        this.idtblMaterial = idtblMaterial;
        this.unidadMedida = unidadMedida;
        this.marca = marca;
        this.estado = estado;
        this.ubicacionActual = ubicacionActual;
        this.responsable = responsable;
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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getCodigoSip() {
        return codigoSip;
    }

    public void setCodigoSip(String codigoSip) {
        this.codigoSip = codigoSip;
    }

    public String getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(String financiamiento) {
        this.financiamiento = financiamiento;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getIdUabc() {
        return idUabc;
    }

    public void setIdUabc(String idUabc) {
        this.idUabc = idUabc;
    }

    @XmlTransient
    public List<TblDetalleprestamo> getTblDetalleprestamoList() {
        return tblDetalleprestamoList;
    }

    public void setTblDetalleprestamoList(List<TblDetalleprestamo> tblDetalleprestamoList) {
        this.tblDetalleprestamoList = tblDetalleprestamoList;
    }

    public Almacen getAlmacenIdalmacen() {
        return almacenIdalmacen;
    }

    public void setAlmacenIdalmacen(Almacen almacenIdalmacen) {
        this.almacenIdalmacen = almacenIdalmacen;
    }

    public Subfamilias getSubFamiliasidsubFam() {
        return subFamiliasidsubFam;
    }

    public void setSubFamiliasidsubFam(Subfamilias subFamiliasidsubFam) {
        this.subFamiliasidsubFam = subFamiliasidsubFam;
    }

    public TblArea getIdArea() {
        return idArea;
    }

    public void setIdArea(TblArea idArea) {
        this.idArea = idArea;
    }

    public TblTipomaterial getIdTipomaterial() {
        return idTipomaterial;
    }

    public void setIdTipomaterial(TblTipomaterial idTipomaterial) {
        this.idTipomaterial = idTipomaterial;
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
        return "com.server.entity.beans.TblMaterial[ idtblMaterial=" + idtblMaterial + " ]";
    }

    public Boolean getShowInQuery() {
        return showInQuery;
    }

    public void setShowInQuery(Boolean showInQuery) {
        this.showInQuery = showInQuery;
    }

    public Boolean getInventariable() {
        return inventariable;
    }

    public void setInventariable(Boolean inventariable) {
        this.inventariable = inventariable;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
